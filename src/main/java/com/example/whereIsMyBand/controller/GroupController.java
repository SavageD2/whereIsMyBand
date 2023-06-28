package com.example.whereIsMyBand.controller;

import com.example.whereIsMyBand.profiles.Band;
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
    public ResponseEntity<List<Band>> getAllGroup() {
        List<Band> bandList = groupService.getAllGroup();
        return new ResponseEntity<>(bandList, HttpStatus.OK);
    }

    @GetMapping("/group_detail/{id}")
    public ResponseEntity<Band> getGroupById(@PathVariable("id") Long id) {
        Band bandDetail = groupService.findById(id);
        return new ResponseEntity<>(bandDetail, HttpStatus.OK);
    }

    @PostMapping("/group_create")
    public ResponseEntity<Band> createGroup(@RequestBody Band band) {
        Band createdBand = groupService.createGroup(band);
        return new ResponseEntity<>(createdBand, HttpStatus.CREATED);
    }

    @PutMapping("/group_update/{id}")
    public ResponseEntity<Band> updateGroup(@PathVariable("id") Long id, @RequestBody Band band) {
        Band updatedBand = groupService.updateGroupById(id, band);
        return new ResponseEntity<>(updatedBand, HttpStatus.OK);
    }

    @DeleteMapping("/group_delete/{id}")
    public void deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroupById(id);
    }
}
