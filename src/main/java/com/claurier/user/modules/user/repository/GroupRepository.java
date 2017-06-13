package com.claurier.user.modules.user.repository;

import com.claurier.user.modules.user.model.Group;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository
extends JpaRepository<Group, Integer> {
    @Deprecated
    public Group findOne(Integer var1);

    default public Optional<Group> findOptOne(Integer id) {
        return Optional.ofNullable(this.getOne((Integer)id));
    }

    public Optional<Group> findByShortcut(String var1);
}

