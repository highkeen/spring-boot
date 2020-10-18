package com.highken.training.bootlearn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highken.training.bootlearn.controller.model.PageRequest;
import com.highken.training.bootlearn.service.StudentService;
import com.highken.training.bootlearn.service.model.StudentModel;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<StudentModel>> getAllStudents(PageRequest pageRequest){
			org.springframework.data.domain.PageRequest pr=org.springframework.data.domain.PageRequest
					.of(pageRequest.getPage(), pageRequest.getSize());
		
			return ResponseEntity.ok(studentService.getAll(pr)) ;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentModel> getById(@PathVariable("id") Long id){
			return ResponseEntity.ok(studentService.getById(id)) ;
	}
	
	
	
}
