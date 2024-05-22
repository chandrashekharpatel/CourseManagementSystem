package com.course.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.course.management.model.Course;
import com.course.management.service.CourseService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@PostMapping("/createCourse")
      private int save(@RequestBody Course course) {
    	  courseService.save(course);
    	  return course.getId();
      }
	//
	//
	@PutMapping("/updateCourse/{id}")
	private Course update(@RequestBody Course course) {
		  courseService.save(course);
		  return course;
	}
	@DeleteMapping("/deleteCourse/{id}")
	private void delete(@PathVariable("id") int id) {
		courseService.delete(id);
	}
	@GetMapping("/course/{id}")
	private Course getCourseById(@PathVariable("id") int id) {
		return courseService.findByCourseId(id);
	}
	@GetMapping("/courses")
	private List<Course> getAllCourse(){
	    return courseService.getAllCourse()	;
	}
	  @GetMapping("/searchCourse")
	    public List<Course> searchCourse(@RequestParam String  queryString){
	    	List<Course> matchCourse=courseService.searchCourse(queryString);
	    	return  matchCourse;
	    }
}