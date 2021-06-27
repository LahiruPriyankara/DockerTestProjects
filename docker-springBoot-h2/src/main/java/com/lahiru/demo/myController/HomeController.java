package com.lahiru.demo.myController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lahiru.demo.dto.Student;
import com.lahiru.demo.repo.StudentRepo;


@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/test")
	@ResponseBody
	public String testMethod() {
		return "From testMethod.";
	}

	@GetMapping("/getStu")
	public String getStudents(Model model) {
		model.addAttribute("sudents", repo.findAll());
		return "index";
	}

	@GetMapping("/addStu")
	public String addStudents(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("grade") int grade,@RequestParam("address") String address,Model model) {
		
		Student stu = new Student(name, age, grade, address);
		repo.save(stu);

		model.addAttribute("sudents", repo.findAll());
		return "index";
	}

	//@DeleteMapping("/deleteStu")
	@PostMapping("/deleteStu")
	public String delteStudents(@RequestParam("id") int id, Model model) {

		Student stu = repo.getOne(id);
		if (stu != null)
			repo.delete(stu);

		model.addAttribute("sudents", repo.findAll());
		return "index";
	}

	@PostMapping("/updateStu")
	public String updateStudents(@RequestParam("id") int id, @RequestParam("name") String name, Model model) {

		Student stu = repo.getOne(id);
		if (stu != null) {
			stu.setStuName(name);
			repo.save(stu);
		}

		model.addAttribute("sudents", repo.findAll());
		return "index";
	}
}
