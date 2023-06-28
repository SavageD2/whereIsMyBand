package com.example.whereIsMyBand.services;

import com.example.whereIsMyBand.profiles.Group;
import com.example.whereIsMyBand.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.IllegalPathStateException;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public Group updateGroupById(Long id, Group group) {
        Group groupFound = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalPathStateException("No group found with id: " + id)); // juste au cas où je ne le trouve pas ^^
        groupFound.setEmail(groupFound.getEmail());
        groupFound.setPassword(groupFound.getPassword());
        groupFound.setGroupName(groupFound.getGroupName());
        groupFound.setDescription(groupFound.getDescription());
        groupFound.setBanner(groupFound.getBanner());
        groupFound.setCity(groupFound.getCity());
        groupFound.setWebsite(groupFound.getWebsite());
        return groupRepository.save(groupFound);

    }
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }

}
