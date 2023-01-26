package com.driver.services;

import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email){
        Student student = null;

        student = studentRepository4.findByEmailId(email);

        return student;
    }

    public Student getDetailsById(int id){
        Student student = null;

        student = studentRepository4.findById(id).get();
        return student;
    }

    public void createStudent(Student student){

        Student student1 = new Student();
        Card newCard = new Card();
        newCard = cardService4.createCard(student);

        student1.setCard(newCard);
        studentRepository4.save(student1);


    }

    public void updateStudent(Student student){

        studentRepository4.save(student);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
        Student student = studentRepository4.findById(id).get();

        student.getCard().setCardStatus(CardStatus.DEACTIVATED);
        studentRepository4.save(student);
    }
}
