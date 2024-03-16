package com.course.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Topics {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int lessionId;
	private int courseId;
	private String title;
	private String summary;
	private String completionTime;
	private int active;
	private int sequence;
	private String body;
	private String imageUrl;
	private String videoUrl;
	private  String document;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLessionId() {
		return lessionId;
	}
	public void setLessionId(int lessionId) {
		this.lessionId = lessionId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public Topics(int id, int lessionId, int courseId, String title, String summary, String completionTime, int active,
			int sequence, String body, String imageUrl, String videoUrl, String document) {
		super();
		this.id = id;
		this.lessionId = lessionId;
		this.courseId = courseId;
		this.title = title;
		this.summary = summary;
		this.completionTime = completionTime;
		this.active = active;
		this.sequence = sequence;
		this.body = body;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.document = document;
	}
	public Topics() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
