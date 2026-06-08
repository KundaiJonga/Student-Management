package com.student.controller;

import com.student.dto.StudentRequestDto;
import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody StudentRequestDto dto){
        return studentService.createStudent(dto);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@RequestBody StudentRequestDto dto, @PathVariable int studentId){
        return studentService.updateStudent(dto, studentId);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        return studentService.deleteStudentById(studentId);
    }


}
