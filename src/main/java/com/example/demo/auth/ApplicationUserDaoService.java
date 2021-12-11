package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;
@Repository("fake")
public class ApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser ->userName.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(new ApplicationUser(
                        "Shahab",
                        passwordEncoder.encode("A123"),
                        STUDENT.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "Ali",
                        passwordEncoder.encode("A123"),
                        ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "Kamran",
                        passwordEncoder.encode("A123"),
                        ADMINTRAINEE.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true
                ));
        return applicationUsers;
    }
}
