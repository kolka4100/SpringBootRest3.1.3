package springboot.crud.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboot.crud.model.Role;
import springboot.crud.model.User;
import springboot.crud.repos.RoleRepository;
import springboot.crud.repos.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class DataInitialaizer {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private Set<Role> rolesSet;

    public DataInitialaizer(UserRepository userRepository,
                            RoleRepository roleRepository,
                            BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initRoles() {
        Role[] rolesArray = new Role[]{new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        rolesSet = new HashSet<>();
        rolesSet.addAll(Arrays.asList(rolesArray));
        roleRepository.saveAll(rolesSet);
    }

    @PostConstruct
    public void initUsers() {
        User admin = new User("admin", "admin",  30, "admin@mail.ru", passwordEncoder.encode("admin"), rolesSet);
        userRepository.save(admin);
    }
}