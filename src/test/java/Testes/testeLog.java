package Testes;

import com.gooPet.Auth.Log.Log;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class testeLog {
    
    public testeLog() {
    }
    
    @Test
    public void logEscreve() {
        Log.LogAuthenticationComponent("DatabaseManager", "ERROR", "Erro na importação dos dados do ambiente.");
    }
}
