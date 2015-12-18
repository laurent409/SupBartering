/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.form;

import com.supinfo.supbartering.entity.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Laurent
 */
public final class RegisterForm {
    private static final String mailValue = "mail";
    private static final String usernameValue = "username";
    private static final String firstNameValue = "firstName";
    private static final String lastNameValue = "lastName";
    private static final String postalCodeValue = "postalCode";
    private static final String passwordValue = "password";
    
    private String results;
    private final Map<String, String> errors = new HashMap<String, String>();
    
    public String getResults() {
        return results;
    }
    
    public Map<String, String> getErrors() {
        return errors;
    }
    
    public User registerUser(HttpServletRequest request) {
        String email = getValeurChamp(request, mailValue);
        String username = getValeurChamp(request, usernameValue);
        String firstName = getValeurChamp(request, firstNameValue);
        String lastName = getValeurChamp(request, lastNameValue);
        String postalCode = getValeurChamp(request, postalCodeValue);
        String password = getValeurChamp(request, passwordValue);
        
        User user = new User();
        
        try {
            validationEmail(email);
        } catch (Exception e) {
            setError(mailValue, e.getMessage());
        }
        user.setMailAddress(email);

        try {
            validationUsername(username);
        } catch (Exception e) {
            setError(usernameValue, e.getMessage());
        }
        user.setUserName(username);
        
        try {
            validationFirstName(firstName);
        } catch (Exception e) {
            setError(firstNameValue, e.getMessage());
        }
        user.setFirstName(firstName);
        
        try {
            validationLastName(lastName);
        } catch (Exception e) {
            setError(lastNameValue, e.getMessage());
        }
        user.setLastName(lastName);
        
        try {
            validationPostalCode(postalCode);
            int pc = Integer.parseInt(postalCode);
            user.setPostalCode(pc);
        } catch (Exception e) {
            setError(postalCodeValue, e.getMessage());
        }
        
        try {
            validationPassword(password);
        } catch (Exception e) {
            setError(passwordValue, e.getMessage());
        }
        user.setPassword(password);

        if ( !errors.isEmpty() )
            results = "Inscription failed !";
        
        return user;
    }    

    private void validationEmail(String email) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Please, set a valid mail address !" );
            }            
        } else {
            throw new Exception ("Please, set a mail address !");
        }
    }

    private void validationUsername(String username) throws Exception {
        if ( username == null) 
            throw new Exception("Please, set an username !");
    }

    private void validationFirstName(String firstName) throws Exception {
        if ( firstName == null) 
            throw new Exception("Please, set an first name !");
    }

    private void validationLastName(String lastName) throws Exception {
        if ( lastName == null) 
            throw new Exception("Please, set an last name !");
    }

    private void validationPostalCode(String postalCode) throws Exception {
        if ( postalCode == null )
                throw new Exception("Please, set a postal code !");
    }
    
    private void validationPassword(String password) throws Exception {
        if ( password != null ) 
            throw new Exception("Please, set a password !");
    }
    
    private void setError(String champ, String message) {
        errors.put(champ, message);
    }
    
    private static String getValeurChamp(HttpServletRequest request, String champValue) {
        String value = request.getParameter(champValue);
        if ( value == null || value.trim().length() == 0 )
            return null;
        else 
            return value.trim();
    }    
}
