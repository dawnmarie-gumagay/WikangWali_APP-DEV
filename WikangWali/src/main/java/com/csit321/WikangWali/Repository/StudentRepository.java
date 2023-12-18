package com.csit321.WikangWali.Repository;

import com.csit321.WikangWali.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // You can add custom query methods if needed
}
