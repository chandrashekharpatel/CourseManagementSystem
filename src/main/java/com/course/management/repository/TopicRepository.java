package com.course.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.course.management.model.Topics;
@Repository
public interface TopicRepository extends JpaRepository<Topics, Integer> {
	  @Modifying
	    @Query(value = "INSERT INTO topic (  course_id, lession_id, title, summary,  completion_time, active, sequence, body, image_url, video_url, document) " + "VALUES (:courseId, :lessionId, :title, :summary, :completionTime, :active, :sequence, :body, :imageUrl, :videoUrl, :document)", nativeQuery = true)
void saveTopics(  int courseId, int lessionId, String title, String summary,String completionTime, int active, int sequence, String body,String imageUrl, String videoUrl, String document);

}
