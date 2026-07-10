package com.example.school_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.school_management.model.Student;
import com.example.school_management.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {

	@Autowired
	private StudentService stuService;
	
	@GetMapping("/api/students")
	public List<Student> getAllStudentsAPI(){
		return stuService.getAllStudents();
	}
	
	@GetMapping("/api/students/{id}")
	public Optional<Student> searchStudent(@PathVariable int id){		
		return stuService.getStudent(id);
	}
	
	@PostMapping("/api/students")
	public Student addNewStudentAPI(@RequestBody Student student) {
		
		Optional<Student> opt = stuService.getStudent(student.getRollno());
		if(opt.isEmpty())
			return stuService.addStudent(student);
		else
			return new Student();
	}
	
	@PutMapping("/api/students")
	public Student updateStudentAPI(@RequestBody Student student)
	{
		Optional<Student> opt=stuService.getStudent(student.getRollno());
		if(opt.isPresent())
			return stuService.addStudent(student);
		else
			return new Student();		
	}
	
	@DeleteMapping("/api/students/{id}")
	public Optional<Student> deleteStudent(@PathVariable int id) {
		Optional<Student> opt=stuService.getStudent(id);
		if(opt.isPresent()) {
			stuService.deleteStudent(id);
			return opt;}
		else
			return opt;
	}
	
	
}
