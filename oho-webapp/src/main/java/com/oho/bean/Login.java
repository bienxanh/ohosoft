package com.oho.bean;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class Login {
    protected static Logger log = Logger.getLogger(Login.class.getSimpleName());
    
    private String username;
    private String password;
    
    //private Context context;

    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(username, password);
            //Authentication result = context.getAuthenticationManager().authenticate(request);
            //SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tài khoản hoặc mật khẩu không đúng", null));
            return null;
        }
        //log.info(String.format("User %s is logged in", context.getGlobal().getLoggedInUsername()));
        return "success";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*public Context getContext() {
        return context;
    }
    
    public void setContext(Context context) {
        this.context = context;
    }*/
}
