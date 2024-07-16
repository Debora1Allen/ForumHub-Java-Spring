package com.forum.forumhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.forumhub.model.Topic;
import com.forum.forumhub.repository.TopicRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic saveTopic(Topic topic) {
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(topic.getTitle(), topic.getMessage());
        if (existingTopic.isPresent()) {
            throw new RuntimeException("Topic with same title and message already exists");
        }

        topic.setCreationDate(LocalDateTime.now());
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic updateTopic(Long id, Topic updatedTopic) {
        Topic existingTopic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        existingTopic.setTitle(updatedTopic.getTitle());
        existingTopic.setMessage(updatedTopic.getMessage());
        existingTopic.setAuthor(updatedTopic.getAuthor());
        existingTopic.setCourse(updatedTopic.getCourse());

        return topicRepository.save(existingTopic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}

