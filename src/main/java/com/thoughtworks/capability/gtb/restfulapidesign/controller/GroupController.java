package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupController {
    final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<List<Group>> divideGroup(){
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.divideGroup());
    }

    @PatchMapping(path = "{id}/{name}")
    public ResponseEntity<Group> updateGroup(@PathVariable int id,@PathVariable String name){
        return ResponseEntity.ok(groupService.updateGroup(id,name));
    }

    @GetMapping
    public ResponseEntity<List<Group>> getGroups(){
        return ResponseEntity.ok(groupService.getGroups());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Group> getOneGroup(@PathVariable int id){
        return ResponseEntity.ok(groupService.getOneGroup(id));
    }
}
