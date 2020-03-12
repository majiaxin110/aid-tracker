package org.hackathon.aidtracker.auth.filter;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.hackathon.aidtracker.auth.exception.WeChatAuthenticationException;
import org.hackathon.aidtracker.auth.security.WeChatAuthenticationToken;
import org.hackathon.aidtracker.constant.SysConst;
import org.hackathon.aidtracker.util.Encrypt;
import org.hackathon.aidtracker.util.JwtUtil;
import org.hackathon.aidtracker.util.WechatUtil;
import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.hackathon.aidtracker.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;


import javax.servlet.FilterChain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WeChatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private Logger logger = LoggerFactory.getLogger(WeChatAuthenticationFilter.class);
    private AuthenticationManager authenticationManager;
    private SysUserRepo sysUserRepo;


    public WeChatAuthenticationFilter(String url, AuthenticationManager authenticationManager, SysUserRepo sysUserRepo) {
        super(new AntPathRequestMatcher(url, "POST"));
        setAuthenticationManager(authenticationManager);
        this.authenticationManager = authenticationManager;
        this.sysUserRepo = sysUserRepo;
    }

    //登录流程
    //打开小程序: 前端调用wx.login拿到code,调用验证接口: /api-user-auth 参数{authCode:''}(post方法，开放接口，不需要授权)发给后端验证，
    // 后端使用此code去微信服务器获取openId,验证此openId是否在sysUser表里存在,若不存在，即---首次登录，若存在即---非首次登录；
    // 1--首次登录: 直接返回给前端{resCode:401,msg:'first login'},同时request header里面会有有一个base_token(基于时间戳加密的密钥,为了保护注册接口)
    // 需要前端跳转角色选择页面，让用户确定是捐助方还是受捐方(role)，同时需要用户授权获取用户基本信息userInfo,进入注册流程
    // 然后前端需要再次调用wx.login拿到code,因为这个授权码有效期为5分钟，要重复获取，
    // 调用注册接口/api-user-register(post方法，需要将base_token放进request的header里面)
    // 参数：{authCode:''(wx.login返回值), userInfo:{nickName:'',avatarUrl:'',gender:0 (0,1,2;未知，男，女),
    // province:'',city:'',country:'',role:0(0:捐赠者,1:受捐者,3:管理员，orgName:'',orgType:0)，supplierLocation:'',demanderDefaultAddress:''}}
    //  orgType: --
    //        individual(1),school(2),enterprise(3),other_with_auth(4),
    //        other_without_auth(5),community(6),medical_institution(7);
    // 返回值:userInfo对象及放在response header 里面是正式的access_token，调用其他接口都需要此token
    // 2--非首次登录: 返回userInfo对象及放在response header里面的access_token
    //plus: 其实还涉及到用户更换微信名的情况，要有一个跟服务器同步的机制，暂时不用考虑，以后写的时候，逻辑可以放在前端，后端提供更新用户信息的接口

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JSONObject json = objectMapper.readValue(request.getInputStream(), JSONObject.class);
            String authCode = json.getStr(SysConst.WX_AUTH_PARAM_KEY);
            JSONObject userInfo = json.getJSONObject("userInfo");
            String nickName = userInfo.getStr("nickName");
            String avatarUrl = userInfo.getStr("avatarUrl");
            String openId = WechatUtil.getOpenId(authCode);
            if (StringUtils.isEmpty(openId)) {
                logger.error("invalid auth code!");
                throw new WeChatAuthenticationException("asas");
            }

            SysUser byOpenId = sysUserRepo.findByOpenId(openId);
            WeChatAuthenticationToken authToken;
            if (Objects.nonNull(byOpenId)) {
                // not first login update sysUser
                byOpenId.setNickName(nickName);
                byOpenId.setAvatarUrl(avatarUrl);
                sysUserRepo.save(byOpenId);
                String roleFlg = Objects.isNull(byOpenId.getRole()) ? "withoutRole" : "withRole";
                authToken = new WeChatAuthenticationToken(openId, byOpenId, false);
            } else {
                //first login create sysUser
                SysUser sysUser = new SysUser();
                sysUser.setOpenId(openId);
                sysUser.setNickName(nickName);
                sysUser.setAvatarUrl(avatarUrl);
                sysUserRepo.save(sysUser);
                authToken = new WeChatAuthenticationToken(openId, sysUser);
            }
            return authenticationManager.authenticate(authToken);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) {
        logger.info("user [ " + authResult.getName() + " ] login success with weChat client");
        BaseUser baseUser = (BaseUser) authResult.getCredentials();
        List<String> roles = baseUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = JwtUtil.createToken(authResult.getName(), roles);
        response.setHeader(SysConst.TOKEN_HEADER, token);
        response.setHeader(SysConst.BASE_TOKEN_HEADER, Encrypt.ins().encode(String.valueOf(new Date().getTime())));
        CommonUtil.writeJSON(response, baseUser);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        WeChatAuthenticationException weChatAuthException = (WeChatAuthenticationException) failed;
        response.setHeader(SysConst.BASE_TOKEN_HEADER, Encrypt.ins().encode(String.valueOf(new Date().getTime())));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resCode", HttpServletResponse.SC_UNAUTHORIZED);
        jsonObject.put("msg", "go fill form!");
        jsonObject.put("userInfo", weChatAuthException.getBaseUser());
        CommonUtil.writeJSON(response, jsonObject);
    }
}
