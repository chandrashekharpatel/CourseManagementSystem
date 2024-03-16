package com.course.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int courseId;
	private String title;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Lession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lession(int id, int courseId, String title) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
	}


}
