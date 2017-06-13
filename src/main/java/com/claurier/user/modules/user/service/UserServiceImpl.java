package com.claurier.user.modules.user.service;

import com.claurier.user.modules.user.lightbeans.UserLightbean;
import com.claurier.user.modules.user.model.User;
import com.claurier.user.modules.user.repository.UserRepository;
import com.claurier.user.modules.user.utils.LightBeanToBeanUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl
implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserLightbean> getUserById(Long id) {
        return Optional.ofNullable(this.userRepository.findOne(id)).map(LightBeanToBeanUtils::copyFrom);
    }

    @Override
    public Optional<UserLightbean> getUserByEmail(String email) {
        return this.userRepository.findOneByEmail(email).map(LightBeanToBeanUtils::copyFrom);
    }

    @Override
    public Optional<UserLightbean> getUserByLogin(String login) {
        return this.userRepository.findOneByLogin(login).map(LightBeanToBeanUtils::copyFrom);
    }

    @Override
    public Collection<UserLightbean> getAllUsers() {
        return this.userRepository.findByDisabledFalseOrderByEmail().stream().map(LightBeanToBeanUtils::copyFrom).collect(Collectors.toList());
    }

    @Override
    public UserLightbean create(Long idUser, UserLightbean userLightbean) {
        User user = new User();
        user.setDateCreation(LocalDateTime.now());
        user.setIdUserCreation(idUser);
        return this.maj(idUser, userLightbean, user);
    }

    @Override
    public boolean delete(Long idUser, Long idUserDelete) {
        User user = (User)this.userRepository.findOne(idUserDelete);
        user.setDisabled(true);
        this.userRepository.save(user);
        return true;
    }

    @Override
    public UserLightbean save(Long idUser, UserLightbean userLightbean) {
        User user = (User)this.userRepository.findOne(Long.valueOf(userLightbean.getId()));
        return this.maj(idUser, userLightbean, user);
    }

    private UserLightbean maj(Long idUser, UserLightbean userLightbean, User user) {
        user.setFirstname(userLightbean.getFirstname());
        user.setLastname(userLightbean.getLastname());
        user.setLogin(userLightbean.getLogin());
        user.setEmail(userLightbean.getEmail());
        user.setPhoneNumber(userLightbean.getPhoneNumber());
        user.setCompany(userLightbean.getCompany());
        if (userLightbean.getPassword() != null) {
            user.setPasswordHash(this.passwordEncoder.encode((CharSequence)userLightbean.getPassword()));
        }
        user.setDateModification(LocalDateTime.now());
        user.setIdUserModification(idUser);
        return LightBeanToBeanUtils.copyFrom((User)this.userRepository.save(user));
    }
}

