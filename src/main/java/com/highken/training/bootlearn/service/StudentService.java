package com.highken.training.bootlearn.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.highken.training.bootlearn.service.model.StudentModel;

public interface StudentService {
	List<StudentModel> getAll();
	List<StudentModel> getAll(PageRequest pageRequest); 
	StudentModel getById(Long id);
	
}
