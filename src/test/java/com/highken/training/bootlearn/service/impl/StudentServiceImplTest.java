package com.highken.training.bootlearn.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.highken.training.bootlearn.dao.StudentDao;
import com.highken.training.bootlearn.dao.entity.Student;
import com.highken.training.bootlearn.service.StudentService;
import com.highken.training.bootlearn.service.config.DataConfiguration;
import com.highken.training.bootlearn.service.model.StudentModel;

@SpringBootTest
public class StudentServiceImplTest {

	
	@MockBean
	private StudentDao studentDao;

	@Autowired
	private DataConfiguration dataConfiguration;
	
	@Autowired
	private StudentService studentService;


//	@TestConfiguration
//	static class StudentServiceImplTestConfig {
//		@Bean
//		public StudentService studentService() {
//			return new StudentServiceImpl();
//		}
//	}

	@BeforeEach
	public void setup() {

		List<Student> students = IntStream.rangeClosed(1, dataConfiguration.getInitStudentCount()).boxed()
				.map(i -> new Student(i + " - f1", i + " - l1", "123")).collect(Collectors.toList());

		Mockito.when(studentDao.findAll()).thenReturn(students);
	}

	@Test
	public void getAllTest() {
		List<StudentModel> result = studentService.getAll();
		assertEquals(dataConfiguration.getInitStudentCount(), result.size());

	}

}
