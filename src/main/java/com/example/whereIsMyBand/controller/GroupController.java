package com.example.whereIsMyBand.controller;

import com.example.whereIsMyBand.profiles.Group;
import com.example.whereIsMyBand.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/group_list")
    public ResponseEntity<List<Group>> getAllGroup() {
        List<Group> groupList = groupService.getAllGroup();
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }

    @GetMapping("/group_detail/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") Long id) {
        Group groupDetail = groupService.findById(id);
        return new ResponseEntity<>(groupDetail, HttpStatus.OK);
    }

    @PostMapping("/group_create")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @PutMapping("/group_update/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable("id") Long id,@RequestBody Group group) {
        Group updatedGroup = groupService.updateGroupById(id, group);
        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
    }

    @DeleteMapping("/group_delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroupById(id);
    }
}
