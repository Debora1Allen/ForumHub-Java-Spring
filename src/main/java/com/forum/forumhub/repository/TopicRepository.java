package com.forum.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forum.forumhub.model.Topic;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByTitleAndMessage(String title, String message);
}
