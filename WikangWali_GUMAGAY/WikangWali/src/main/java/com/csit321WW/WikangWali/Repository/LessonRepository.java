package com.csit321WW.WikangWali.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.csit321WW.WikangWali.Entity.LessonEntity;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, Integer> {
   
}
