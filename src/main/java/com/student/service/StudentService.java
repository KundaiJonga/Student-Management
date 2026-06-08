package com.student.service;

import com.student.dto.StudentRequestDto;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentRequestDto dto){

        Student student = new Student();  
        student.setStudentName(dto.getStudentName());
        student.setMarks(dto.getMarks());
        student.setAddress(dto.getAddress());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int studentId){
        return studentRepository.findById(studentId).get();
    }

    public String updateStudent(StudentRequestDto dto, int studentId){
        Student s = studentRepository.findById(studentId).get();
        s.setStudentName(dto.getStudentName());
        s.setMarks(dto.getMarks());
        s.setAddress(dto.getAddress());
        studentRepository.save(s);
        return "Student updated successfully";
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }
}

