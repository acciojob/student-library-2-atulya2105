package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

//Add required annotations
@RestController
@RequestMapping("/student")
public class StudentController {

    //Add required annotations
    @Autowired
    StudentService studentService;


    @GetMapping("/getStudentByEmail")
    public ResponseEntity getStudentByEmail(@RequestParam("email") String email){
        studentService.getDetailsByEmail(email);
        return new ResponseEntity<>("Student details printed successfully ", HttpStatus.OK);
    }

    //Add required annotations
    @GetMapping("/getStudentById")
    public ResponseEntity getStudentById(@RequestParam("id") int id){

        studentService.getDetailsById(id);
        return new ResponseEntity<>("Student details printed successfully ", HttpStatus.OK);
    }

    //Add required annotations
    @PostMapping("/create")
    public ResponseEntity createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations
    @PutMapping("/update")
    public ResponseEntity updateStudent(@RequestBody Student student){

        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){


        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
