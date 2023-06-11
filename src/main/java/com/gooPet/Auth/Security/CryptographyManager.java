package com.gooPet.Auth.Security;

import com.gooPet.Auth.Log.Log;
import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author mauricio.rodrigues
 */
public class CryptographyManager {
    
    private static CryptographyManager Crypt;

    private CryptographyManager() {
        
    }
    
    public static CryptographyManager getInstance() {
        if(CryptographyManager.Crypt == null)
            CryptographyManager.Crypt = new CryptographyManager();
        return CryptographyManager.Crypt;
    }
    
    // Criptografar o texto usando a chave pública
    public String encrypt(String texto, PublicKey chavePublica) throws Exception {
        Log.LogAuthenticationComponent("CryptographyManager", "INFO", "Criptografando senha com o algoritmo RSA.");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chavePublica);
        byte[] textoCriptografado = cipher.doFinal(texto.getBytes());
        Log.LogAuthenticationComponent("Security", "INFO", "Retornando senha criptografada com o algoritmo RSA.");
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    // Descriptografar o texto usando a chave privada
    public String decrypt(String textoCriptografado, PrivateKey chavePrivada) throws Exception {
        Log.LogAuthenticationComponent("CryptographyManager", "INFO", "Decriptografando senha com o algoritmo RSA.");
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, chavePrivada);
        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
        Log.LogAuthenticationComponent("Security", "INFO", "Retornando senha decriptografada com o algoritmo RSA.");
        return new String(textoDescriptografado);
    }
    
}
