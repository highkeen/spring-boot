package com.highken.training.bootlearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highken.training.bootlearn.dao.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
