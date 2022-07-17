package com.example.demo.auth;

import com.example.demo.repository.OprUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    public final OprUserRepository userRepository;

    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder, OprUserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public ApplicationUser selectApplicationUserByUserName(String userName) {
        return getApplicationUser(userName);
    }

    private ApplicationUser getApplicationUser(String userName) {
        ApplicationUser applicationUser=  userRepository.findByUserName(userName);

//        Optional<ApplicationUser> applicationUser = Optional.of(new ApplicationUser(
//                "Shahab",
//                passwordEncoder.encode("A123"),
//                STUDENT.getGrantedAuthority(),
//                true,
//                true,
//                true,
//                true
//        ));
        return applicationUser;
    }
}
