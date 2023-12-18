package com.csit321.WikangWali.Controller;

import com.csit321.WikangWali.Entity.ParentEntity;
import com.csit321.WikangWali.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping("/insertParent")
    public ResponseEntity<ParentEntity> insertParent(@RequestBody ParentEntity parent) {
        try {
            ParentEntity createdParent = parentService.insertParent(parent);
            return new ResponseEntity<>(createdParent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllParents")
    public ResponseEntity<List<ParentEntity>> getAllParents() {
        try {
            List<ParentEntity> parents = parentService.getAllParents();
            if (parents.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(parents, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateParent/{parentId}")
    public ResponseEntity<ParentEntity> updateParent(
            @PathVariable Long parentId,
            @RequestBody ParentEntity newParentDetails
    ) {
        try {
            ParentEntity updatedParent = parentService.updateParent(parentId, newParentDetails);
            return new ResponseEntity<>(updatedParent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteParent/{parentId}")
    public ResponseEntity<String> deleteParent(@PathVariable Long parentId) {
        try {
            String message = parentService.deleteParent(parentId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}