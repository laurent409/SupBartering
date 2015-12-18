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
public final class LoginForm {
    private static final String usernameValue = "username";
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
        String username = getValeurChamp(request, usernameValue);
        String password = getValeurChamp(request, passwordValue);
        
        User user = new User();
        
        try {
            validationUsername(username);
        } catch (Exception e) {
            setError(usernameValue, e.getMessage());
        }
        user.setUserName(username);
        
        try {
            validationPassword(password);
        } catch (Exception e) {
            setError(passwordValue, e.getMessage());
        }
        user.setPassword(password);

        if ( !errors.isEmpty() )
            results = "Login failed !";
        
        return user;
    }    
    
    private void validationUsername(String username) throws Exception {
        if ( username == null) 
            throw new Exception("Please, set an username !");
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
