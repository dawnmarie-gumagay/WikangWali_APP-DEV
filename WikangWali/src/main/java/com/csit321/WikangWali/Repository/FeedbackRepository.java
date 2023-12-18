package com.csit321.WikangWali.Repository;

import com.csit321.WikangWali.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {

    List<FeedbackEntity> findByEmail(String email);

    // Add other custom queries based on your requirements

    // Example: List<FeedbackEntity> findByParentName(String parentName);
    // Example: List<FeedbackEntity> findByFeedbackMessageContaining(String keyword);
}
