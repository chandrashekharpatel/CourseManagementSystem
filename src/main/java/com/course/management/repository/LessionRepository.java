package com.course.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.course.management.model.Lession;

@Repository
public interface LessionRepository extends CrudRepository<Lession, Integer> {

}
