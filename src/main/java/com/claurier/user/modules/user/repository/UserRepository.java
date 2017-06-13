package com.claurier.user.modules.user.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.claurier.user.modules.user.model.User;

@Repository
public interface UserRepository
extends JpaRepository<User, Long> {
    public Collection<User> findByDisabledFalseOrderByEmail();

    public Optional<User> findOneByEmail(String var1);

    public Optional<User> findOneByLogin(String var1);

    public Page<User> findAll(Pageable var1);

    public List<User> findAllByDisabledFalse(Sort var1);
}

