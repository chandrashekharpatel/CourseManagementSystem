package com.course.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.management.model.Course;
import com.course.management.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
     public void save(Course course) {
    	 courseRepository.save(course);
     }
     public void update(Course course) {
    	 courseRepository.save(course);
     }
     public void delete(int id) {
    	 courseRepository.deleteById(id);
     }
     public List<Course> getAllCourse(){
    	 List<Course> newList=new ArrayList<>();
    	 courseRepository.findAll().forEach(l->newList.add(l));
    	 return newList;
     }
     public Course findByCourseId(int id) {
    	 return courseRepository.findById(id).get();
     }
 	public List<Course> searchCourse(String query){
		List<Course> roles= (List<Course>)courseRepository.findAll();
		List<Course> matchCourse= new ArrayList<Course>();
		for(Course role:roles) {
			if( role.getTitle() .toLowerCase().contains(query.toLowerCase())) {
				matchCourse.add(role);
			}
		}
		return matchCourse;
	}
     
}
