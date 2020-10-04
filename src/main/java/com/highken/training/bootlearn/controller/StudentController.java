package com.highken.training.bootlearn.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.highken.training.bootlearn.dao.StudentDao;
import com.highken.training.bootlearn.dao.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	@PostConstruct
	@Transactional
	public void init() {
		studentDao.saveAll(Arrays.asList(new Student("f1", "l1", "123"),
				new Student("f2", "l2", "1234"),
				new Student("f3", "l3", "1235")));
	}

	
	
	@GetMapping
	public String getStudents(Model model) {
		List<Student>  students=studentDao.findAll();
		model.addAttribute("students", students);
		return "student_view";
	}
}
