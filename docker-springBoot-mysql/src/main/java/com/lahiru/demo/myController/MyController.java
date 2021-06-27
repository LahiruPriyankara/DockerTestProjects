package com.lahiru.demo.myController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lahiru.demo.dto.Student;
import com.lahiru.demo.repo.StudentRepo;

@RestController
@RequestMapping(("/home"))
public class MyController {
	
	@Autowired
	private StudentRepo repo;

	@RequestMapping(path="/getStu")
	public ArrayList<Student> getStudents() {
		return (ArrayList<Student>) repo.findAll();
	}

	@RequestMapping("/addStu")
	public ArrayList<Student> addStudents(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("address") String address) {
		
		Student stu = new Student(name, age, grade, address);
		System.out.println("OBJECT : "+stu.toString());
		repo.save(stu);
		
		return getStudents();
	}

	//@DeleteMapping("/deleteStu")
	@RequestMapping("/deleteStu")
	public ArrayList<Student> delteStudents(@RequestParam("id") int id) {

		Student stu = repo.getOne(id);
		System.out.println("OBJECT : "+stu.toString());
		if (stu != null)
			repo.delete(stu);
		
		return getStudents();
	}

	@RequestMapping("/updateStu")
	public String updateStudents(@RequestParam("id") int id, @RequestParam("name") String name) {

		Student stu = repo.getOne(id);
		if (stu != null) {
			stu.setStuName(name);
			System.out.println("OBJECT : "+stu.toString());
			repo.saveAndFlush(stu);
		}
		System.out.println("OBJECT : ");
		return "redirect:/home/getStu";
	}

}
