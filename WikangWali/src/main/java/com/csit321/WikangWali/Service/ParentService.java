package com.csit321.WikangWali.Service;

import com.csit321.WikangWali.Entity.ParentEntity;
import com.csit321.WikangWali.Repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParentService {

    @Autowired
    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public ParentEntity insertParent(ParentEntity parent) {
        return parentRepository.save(parent);
    }

    public List<ParentEntity> getAllParents() {
        return parentRepository.findAll();
    }

    public ParentEntity updateParent(Long parentId, ParentEntity newParentDetails) {
        ParentEntity parent = getParentById(parentId);
        // Update relevant details from newParentDetails
        // For example:
        parent.setPassword(newParentDetails.getPassword());
        parent.setEmail(newParentDetails.getEmail());
        parent.setContactDetails(newParentDetails.getContactDetails());
        parent.setName(newParentDetails.getName());
        return parentRepository.save(parent);
    }

    public String deleteParent(Long parentId) {
        if (parentRepository.existsById(parentId)) {
            parentRepository.deleteById(parentId);
            return "Parent " + parentId + " is successfully deleted!";
        } else {
            return "Parent " + parentId + " does not exist.";
        }
    }

    private ParentEntity getParentById(Long parentId) {
        return parentRepository.findById(parentId)
                .orElseThrow(() -> new NoSuchElementException("Parent " + parentId + " does not exist!"));
    }
}
