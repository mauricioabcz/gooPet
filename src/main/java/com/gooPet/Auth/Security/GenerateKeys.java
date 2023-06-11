package com.gooPet.Auth.Security;

import com.gooPet.Auth.Log.Log;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 *
 * @author mauricio.rodrigues
 */
public class GenerateKeys {
    
    private static GenerateKeys generateKeys;

    private GenerateKeys() {
        
    }
    
    public static GenerateKeys getInstance() {
        if(GenerateKeys.generateKeys == null)
            GenerateKeys.generateKeys = new GenerateKeys();
        return GenerateKeys.generateKeys;
    }
    
    public KeyPair generateKeys(){
        try {
            // Adiciona o provedor Bouncy Castle
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            // Gera um par de chaves pública e privada
            KeyPair keyPair = generateKeyPair();

            return keyPair;
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Gera um par de chaves pública e privada usando RSA
    private KeyPair generateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        Log.LogAuthenticationComponent("GenerateKeys", "INFO", "Gerando um par de chaves pública e privada usando RSA.");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048); // Tamanho da chave (em bits)
        Log.LogAuthenticationComponent("GenerateKeys", "INFO", "Retornando par de chaves gerado.");
        return keyPairGenerator.generateKeyPair();
    }
    
}

