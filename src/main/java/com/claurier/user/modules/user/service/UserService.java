package com.claurier.user.modules.user.service;

import com.claurier.user.modules.user.lightbeans.UserLightbean;
import java.util.Collection;
import java.util.Optional;

public interface UserService {
    public Optional<UserLightbean> getUserById(Long var1);

    public Optional<UserLightbean> getUserByEmail(String var1);

    public Optional<UserLightbean> getUserByLogin(String var1);

    public Collection<UserLightbean> getAllUsers();

    public UserLightbean create(Long var1, UserLightbean var2);

    public boolean delete(Long var1, Long var2);

    public UserLightbean save(Long var1, UserLightbean var2);
}

