package org.hackathon.aidtracker.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;


public class Encrypt {

    private SymmetricCrypto aes;
    private static Encrypt instance = new Encrypt();

    public static Encrypt ins(){
        return instance;
    }
    public Encrypt(){
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
    }
    public  String encode(String content){
        return  aes.encryptHex(content);
    }
    public  String decode(String encryptStr){
        return  aes.decryptStr(encryptStr);
    }
}
