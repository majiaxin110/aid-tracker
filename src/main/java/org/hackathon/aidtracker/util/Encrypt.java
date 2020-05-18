package org.hackathon.aidtracker.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;


public enum Encrypt {
    INS;
    private SymmetricCrypto aes;
     Encrypt(){

         //would be better to use a static key
         byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
         //byte[] key ="".getBytes();
         aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
    }



    public  String encode(String content){
        return  aes.encryptHex(content);
    }
    public  String decode(String encryptStr){
        return  aes.decryptStr(encryptStr);
    }
}
