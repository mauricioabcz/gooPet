package Testes;

import com.gooPet.Auth.Database.DatabaseManager;
import com.gooPet.Auth.Security.Security;
import org.junit.Test;

/**
 *
 * @author mauricio.rodrigues
 */
public class createDadosBasicos {
    
    public createDadosBasicos() {
    }
    
    @Test
    public void createDadosBasicos() throws Exception{
        DatabaseManager banco = DatabaseManager.getInstance();
        Security sec = Security.getInstance();
        sec.generateKeyPair();
        banco.createUserType("Administrador", "Usuário com acesso de administrador");
        banco.createUserType("Cliente", "Usuário com acesso de cliente");
        banco.createUser("Admin", "admin", sec.encryptPassword("teste123"), "Administrador");
        banco.createUser("Cliente", "client", sec.encryptPassword("teste123"), "Cliente");
    }
}
