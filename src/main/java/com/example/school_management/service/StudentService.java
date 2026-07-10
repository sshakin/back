package com.example.school_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school_management.model.Student;
import com.example.school_management.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository stuRepo;
	
	public List<Student> getAllStudents(){
		return stuRepo.findAll();
	}
	
	public Optional<Student> getStudent(int rollno){
		return stuRepo.findById(rollno);
	}
	
	public Student addStudent(Student student) {
		return stuRepo.save(student);
	}
	
	public void deleteStudent(int id) {
		stuRepo.deleteById(id);
	}
}
