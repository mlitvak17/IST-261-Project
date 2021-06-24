package financeApplication;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauriciolitvak
 */
public class LoginCredentialsList {

    private final List<LoginCredential> loginCredentials;
    
    public LoginCredentialsList() {
        loginCredentials = new ArrayList<>();
        addInitialLoginCredentialsToList();
    }
    
    private void addInitialLoginCredentialsToList() {
        loginCredentials.add(new LoginCredential("John", "Doe", "JohnDoe@gmail.com", "JDpassword123"));
        loginCredentials.add(new LoginCredential("Mauricio", "Litvak", "mml5604@psu.edu", "MLpassword123"));
    }

    List<LoginCredential> getLoginCredentials() {
        return loginCredentials;
    }
    
}
