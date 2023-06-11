package com.gooPet.Auth.Security;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Database.Entities.Config;
import com.gooPet.Auth.Log.Log;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Security {

    private static Security security;
    
    private Security() {
        
    }

    public static Security getInstance() {
        if(Security.security == null)
            Security.security = new Security();
        return Security.security;
    }
    
    public boolean generateKeyPair(){
        Log.LogAuthenticationComponent("Security", "INFO", "Iniciando processo de criação/atualização do par de chaves de criptografia.");
        GenerateKeys geraChaves = GenerateKeys.getInstance();
        KeyPair keyPair = geraChaves.generateKeys();
        
        String publicKey, privateKey;
        publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        
        Config config = new Config(publicKey, privateKey);
        
        DatabaseManager banco = DatabaseManager.getInstance();
        banco.createConfig(config);
        Log.LogAuthenticationComponent("Security", "INFO", "Finalizando processo de criação/atualização do par de chaves de criptografia.");
        return true;
    }
    
    public PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException{
        Log.LogAuthenticationComponent("Security", "INFO", "Buscando PublicKey na base de dados.");
        DatabaseManager banco = DatabaseManager.getInstance();
        byte[] publicKeyBytes = Base64.getDecoder().decode(banco.getPublicKey());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Log.LogAuthenticationComponent("Security", "INFO", "Retornando PublicKey.");
        return keyFactory.generatePublic(keySpec);
    }
    
    public String encryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception{
        Log.LogAuthenticationComponent("Security", "INFO", "Iniciando processo de criptografia de senha.");
        CryptographyManager cripto = CryptographyManager.getInstance();
        String textoCriptografadoComChavePublica = cripto.encrypt(password, getPublicKey());
        Log.LogAuthenticationComponent("Security", "INFO", "Finalizando processo de criptografia de senha.");
        return textoCriptografadoComChavePublica;
    }
    
    public PrivateKey getPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Log.LogAuthenticationComponent("Security", "INFO", "Buscando PrivateKey na base de dados.");
        DatabaseManager banco = DatabaseManager.getInstance();
        byte[] privateKeyBytes = Base64.getDecoder().decode(banco.getPrivateKey());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Log.LogAuthenticationComponent("Security", "INFO", "Retornando PrivateKey.");
        return keyFactory.generatePrivate(keySpec);
    }
    
    public String decryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException, Exception{
        Log.LogAuthenticationComponent("Security", "INFO", "Iniciando processo de decriptografia de senha.");
        CryptographyManager cripto = CryptographyManager.getInstance();
        String textoDecriptografadoComChavePrivada = cripto.decrypt(password, getPrivateKey());
        Log.LogAuthenticationComponent("Security", "INFO", "Finalizando processo de decriptografia de senha.");
        return textoDecriptografadoComChavePrivada;
    }
    
}
