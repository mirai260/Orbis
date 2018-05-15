package com.Orbis.configuration.security;


import com.Orbis.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by lyriaaw on 15/12/16.
 */
public class MyAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();


        System.out.println("Trying to authenticate with " + login + " - " + password);

        User user = User.getUserByLogin(login);

        if (user == null){
            return null;
        }

        System.out.println("A user has been found : " + user.toString());

        /*if (!BCrypt.checkpw(password, user.getPassword())) {
            return null;
        }*/
        if (!Objects.equals(user.getPassword(), password))
            return null;


        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        /*if (user.isAdmin()){
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }*/

        System.out.println("Authorities finished");

        //SecurityContextHolder.getContext().getAuthentication().getName();
        return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), grantedAuthorityList);
    }



    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
