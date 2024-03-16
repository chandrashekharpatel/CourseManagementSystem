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
import org.springframework.web.bind.annotation.RestController;

import com.course.management.model.Lession;
import com.course.management.service.LessionService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class LessionController {
	@Autowired
	private LessionService lessionService;
	@PostMapping("/createLession")
    private int save(@RequestBody Lession lession) {
    	lessionService.save(lession);
    	return lession.getId();
    }
	@PutMapping("/updateLession/{id}")
	private Lession update(@RequestBody Lession lession) {
		 lessionService.update(lession);
		  return lession;
	}
	@DeleteMapping("/deleteLession/{id}")
	private void delete(@PathVariable("id") int id) {
		lessionService.delete(id);
	}
	
	@GetMapping("/lession/{id}")
	private Lession findById(@PathVariable("id") int id) {
		 return lessionService.getLessionById(id);
	}
	@GetMapping("/lessions")
	private List<Lession> getAllLession(){
		return lessionService.getAllLession();
		
	}
}
