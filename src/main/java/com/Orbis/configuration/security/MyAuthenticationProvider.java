package com.Orbis.configuration.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.Orbis.configuration.security.Authentification_Moodle.LDAPObject;
import com.Orbis.configuration.security.Authentification_Moodle.LDAPaccess;
import com.Orbis.model.Admin;
import com.Orbis.model.Eleve;
import com.Orbis.model.Professeur;





/**
 * Created by lyriaaw on 15/12/16.
 */
public class MyAuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        

		Eleve eleve = Eleve.getEleveByLogin(login);
        if (eleve != null && BCrypt.checkpw(password, eleve.getMdp())){
        	List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ELEVE"));
			return new UsernamePasswordAuthenticationToken(eleve.getLogin(), eleve.getMdp(), grantedAuthorityList);
        }
        Professeur professeur = Professeur.getProfesseurByLogin(login);
        if (professeur != null && BCrypt.checkpw(password, professeur.getMdp())){
        	List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_PROFESSEUR"));
			return new UsernamePasswordAuthenticationToken(professeur.getId_professeur(), professeur.getMdp(), grantedAuthorityList);
        }
        Admin admin = Admin.getAdminByLogin(login);
        if (admin != null && BCrypt.checkpw(password, admin.getMdp())){
        	List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
	        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new UsernamePasswordAuthenticationToken(admin.getId_admin(), admin.getMdp(), grantedAuthorityList);
        }
        
        
    	LDAPaccess access = new LDAPaccess();
		try {
			System.out.println("test");
			LDAPObject test = access.LDAPget(login, password); // remplacez login par la variable qui contient le login, et mdp par la variable qui contient le mot de passe
			System.out.println("test");
			if (test != null)
			{
				List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ELEVE"));
				return new UsernamePasswordAuthenticationToken(test.getLogin(), test.getPassword(), grantedAuthorityList);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
    	

        /*
        System.out.println("Trying to authenticate with " + login + " - " + password);

        User user = User.getUserByLogin(login);

        if (user == null){
            return null;
        }

        System.out.println("A user has been found : " + user.toString());

        //if (!BCrypt.checkpw(password, user.getPassword())) {
        //    return null;
        //}
        if (!Objects.equals(user.getPassword(), password))
            return null;


        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        //if (user.isAdmin()){
        //    grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //}

        System.out.println("Authorities finished");

        //SecurityContextHolder.getContext().getAuthentication().getName();
        return new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword(), grantedAuthorityList);*/
        throw new BadCredentialsException("Iddentifiants incorrects");
    }



    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
