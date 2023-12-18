package com.csit321.WikangWali.Repository;

import com.csit321.WikangWali.Entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
    // You can add custom query methods if needed


}
