package com.claurier.user.modules.user.service;

import com.claurier.user.modules.user.model.Group;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface GroupService {
    public Optional<Group> getGroupById(int var1);

    public Optional<Group> getGroupByShortcut(String var1);

    public List<Group> getGroups();

    public List<Group> getGroups(Sort var1);

    public Page<Group> getGroups(Pageable var1);
}

