package com.course.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.course.management.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
