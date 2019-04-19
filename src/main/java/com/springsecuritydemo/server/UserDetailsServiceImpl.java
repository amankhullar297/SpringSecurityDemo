package com.springsecuritydemo.server;

import com.springsecuritydemo.entity.Role;
import com.springsecuritydemo.entity.User;
import com.springsecuritydemo.repository.RoleRepository;
import com.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RoleRepository roleRep;

    @Autowired
    UserRepository userRep;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRep.findByName(username);

        if(user==null){
            return new org.springframework.security.core.userdetails.User(
                    " ", " ",getAuthorities(roleRep.findByName("user")));
        }
        else{
            Role roles=user.getRole();
            return new org.springframework.security.core.userdetails.User(

                    username, user.getPassword(),getAuthorities(roles));
        }
    }


    private Collection<? extends GrantedAuthority> getAuthorities(
            Role roles) {
        return getGrantedAuthorities(roles);
    }


    private List<GrantedAuthority> getGrantedAuthorities(Role roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles.getName()));
        return authorities;
    }

}
