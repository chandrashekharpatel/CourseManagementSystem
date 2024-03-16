package com.course.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.management.model.Lession;
import com.course.management.repository.LessionRepository;

@Service
public class LessionService {
	@Autowired
	private LessionRepository lessionRepository;
	
     public void save(Lession lession) {
    	 lessionRepository.save(lession);
    	 
     }
     public void update(Lession lession) {
    	 lessionRepository.save(lession);
     }
     public void delete(int id) {
    	 lessionRepository.deleteById(id);
     }
     public Lession getLessionById(int id) {
    	  return lessionRepository.findById(id).get();
     }
     public List<Lession> getAllLession(){
    	 List<Lession> newList =new ArrayList<>();
    	 lessionRepository.findAll().forEach(l->newList.add(l));
    	 return newList;
     }
     
}
