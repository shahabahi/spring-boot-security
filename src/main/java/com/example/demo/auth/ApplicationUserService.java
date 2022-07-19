package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ApplicationUserService implements UserDetailsService {
    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserDao.selectApplicationUserByUserName(userName);
        if (applicationUser == null) throw new UsernameNotFoundException(userName);
        List<GrantedAuthority> authorities = getUserAuthority(applicationUser.getRoles());
        return buildUserForAuthentication(applicationUser, authorities);
    }

    private UserDetails buildUserForAuthentication(ApplicationUser user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<ApplicationUserRole> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            if (role.getRole().contains(":")) {
                roles.add(new SimpleGrantedAuthority(role.getRole()));
            } else {
                roles.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
            }
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }
}
