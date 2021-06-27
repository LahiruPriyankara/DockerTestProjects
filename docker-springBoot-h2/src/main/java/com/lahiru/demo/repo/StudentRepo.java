package com.lahiru.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lahiru.demo.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
