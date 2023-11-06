package com.lcsoft.ChefsHubApp.init;

import com.lcsoft.ChefsHubApp.model.enums.RoleType;
import com.lcsoft.ChefsHubApp.model.entity.Role;
import com.lcsoft.ChefsHubApp.model.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final String defaultAdminPass;

    public DBInit(@Value("${chefshub.default.admin.pass}") String defaultAdminPass, RoleRepository roleRepository) {
        this.defaultAdminPass = defaultAdminPass;

        this.roleRepository = roleRepository;
    }

    @Override

    public void run(String... args) throws Exception {
        /*if(roleRepository.count() == 0){
            for (RoleType roleType : RoleType.values()) {
                Role role = new Role();
                role.setName(roleType);
                roleRepository.save(role);
            }
        }*/
    }
}
