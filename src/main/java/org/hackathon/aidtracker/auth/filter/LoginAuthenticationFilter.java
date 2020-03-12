package org.hackathon.aidtracker.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hackathon.aidtracker.constant.SysConst;
import org.hackathon.aidtracker.auth.dto.JwtUser;
import org.hackathon.aidtracker.auth.dto.LoginUser;
import org.hackathon.aidtracker.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private ThreadLocal<Boolean> rememberMe = new ThreadLocal<>();
    private static final Logger logger = Logger.getLogger(LoginAuthenticationFilter.class.getName());
    public LoginAuthenticationFilter(String url, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl(url);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LoginUser loginUser = objectMapper.readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.isRememberMe());
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        List<String> roles = jwtUser.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = JwtUtil.createToken(jwtUser.getUsername(), roles);
        response.setHeader(SysConst.TOKEN_HEADER, token);
        response.sendRedirect(SysConst.LOGIN_SUCCESS_PATH);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

    }
}
