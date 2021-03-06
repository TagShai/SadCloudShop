package org.mannayakasha.service.impl.security;

import org.mannayakasha.entity.Role;
import org.mannayakasha.entity.User;
import org.mannayakasha.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserDetailsService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 28.10.2017
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private IUserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userService.getByEmail(email);
        LOGGER.info("User : {}", user);
        if (user == null){
            LOGGER.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(Role role : user.getRoles()) {
            LOGGER.info("Role : {}", role);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        LOGGER.info("authorities : {}", authorities);
        return authorities;
    }

}