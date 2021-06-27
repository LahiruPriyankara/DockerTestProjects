package com.lahiru.demo.myController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lahiru.demo.dto.Student;
import com.lahiru.demo.repo.StudentRepo;

@Controller
@RequestMapping("/restApi")
public class RestController {
	@Autowired
	private StudentRepo repo;

	@GetMapping("/test")
	@ResponseBody
	public String testMethod() {
		return "From testMethod.";
	}

	@GetMapping(path="/getStu",produces = {"application/json"})
	@ResponseBody
	public ArrayList<Student> getStudents() {
		ArrayList<Student> stuArry= null;
		try {
			stuArry = (ArrayList<Student>) repo.findAll();
		}catch (Exception e) {
			stuArry = new ArrayList<>();
		}		
		return stuArry;
	}

	@GetMapping(path="/addStu",produces = {"application/json"})
	@ResponseBody
	public ArrayList<Student> addStudents(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("grade") int grade, @RequestParam("address") String address) {

		Student stu = new Student(name, age, grade, address);
		repo.save(stu);
		return getStudents();
	}

	// @DeleteMapping("/deleteStu")
	@PostMapping(path="/deleteStu",produces = {"application/json"})
	@ResponseBody
	public ArrayList<Student> delteStudents(@RequestParam("id") int id) {

		Student stu = repo.getOne(id);
		if (stu != null)
			repo.delete(stu);
		return getStudents();
	}

	@PostMapping(path="/updateStu",produces = {"application/json"})
	@ResponseBody
	public ArrayList<Student> updateStudents(@RequestParam("id") int id, @RequestParam("name") String name) {

		Student stu = repo.getOne(id);
		if (stu != null) {
			stu.setStuName(name);
			repo.save(stu);
		}

		return getStudents();
	}
}
