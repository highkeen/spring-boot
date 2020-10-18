package com.highken.training.bootlearn.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highken.training.bootlearn.dao.StudentDao;
import com.highken.training.bootlearn.dao.entity.Student;
import com.highken.training.bootlearn.exception.ExceptionCode;
import com.highken.training.bootlearn.exception.HighkeenBootLearnNotFoundException;
import com.highken.training.bootlearn.service.StudentService;
import com.highken.training.bootlearn.service.config.DataConfiguration;
import com.highken.training.bootlearn.service.model.StudentModel;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private DataConfiguration dataConfiguration;
	
	@PostConstruct
	@Transactional
	public void init() {
		
		List<Student> students= IntStream.rangeClosed(1, dataConfiguration.getInitStudentCount())
		.boxed()
		.map(i-> new Student(i+" - f1", i+" - l1", "123"))
		.collect(Collectors.toList());
		
		studentDao.saveAll(students);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StudentModel> getAll(PageRequest pageRequest) {
		return studentDao.findAll(pageRequest).stream()
				.map(this::convert)
				.collect(Collectors.toList());
	}
	
	private StudentModel convert(Student student) {
		return StudentModel.builder()
				.studentId(student.getStudentId())
				.firstName(student.getFirstName())
				.lastName(student.getLastName())
				.contactNo(student.getContactNo())
				.build();
	}

	@Override
	public List<StudentModel> getAll() {
		return studentDao.findAll().stream()
				.map(this::convert)
				.collect(Collectors.toList());
	}

	@Override
	public StudentModel getById(Long id) {
		return studentDao.findById(id).map(this::convert)
				.orElseThrow(()->
				new HighkeenBootLearnNotFoundException(ExceptionCode.NOT_FOUND.getErrorCode(),
						String.join(",", ExceptionCode.NOT_FOUND.getMessage(),id.toString())));
	}
	
}
