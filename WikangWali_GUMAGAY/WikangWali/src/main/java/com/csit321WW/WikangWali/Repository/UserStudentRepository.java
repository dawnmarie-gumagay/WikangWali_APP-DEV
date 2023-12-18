package com.csit321WW.WikangWali.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.csit321WW.WikangWali.Entity.UserStudentEntity;

@Repository
public interface UserStudentRepository extends JpaRepository<UserStudentEntity, Integer> {
    // Additional custom queries can be added here if needed
}