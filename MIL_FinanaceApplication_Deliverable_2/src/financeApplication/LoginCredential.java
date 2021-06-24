/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeApplication;

/**
 *
 * @author mauriciolitvak
 */
public class LoginCredential {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    
    
    
    
    
    public LoginCredential(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    
    
    @Override
    public String toString() {
        return firstName + " " + lastName + "; Email: " + email + "; Pass: " + password;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return password;
    }
    
   
}
