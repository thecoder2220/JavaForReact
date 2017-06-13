package com.claurier.user.modules.user.service;

import com.claurier.user.modules.user.model.Group;
import com.claurier.user.modules.user.repository.GroupRepository;
import com.claurier.user.modules.user.service.GroupService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GroupServiceImpl
implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Optional<Group> getGroupById(int id) {
        return this.groupRepository.findOptOne(id);
    }

    @Override
    public Optional<Group> getGroupByShortcut(String shortcut) {
        return this.groupRepository.findByShortcut(shortcut);
    }

    @Override
    public List<Group> getGroups() {
        return this.groupRepository.findAll();
    }

    @Override
    public List<Group> getGroups(Sort sort) {
        return this.groupRepository.findAll(sort);
    }

    @Override
    public Page<Group> getGroups(Pageable page) {
        return this.groupRepository.findAll(page);
    }
}

