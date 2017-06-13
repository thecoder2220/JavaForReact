package com.claurier.core.config;

import com.claurier.user.modules.user.service.GroupService;
import com.claurier.user.modules.user.service.GroupServiceImpl;
import com.claurier.user.modules.user.service.UserService;
import com.claurier.user.modules.user.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfiguration {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public GroupService getGroupService() {
        return new GroupServiceImpl();
    }
}

