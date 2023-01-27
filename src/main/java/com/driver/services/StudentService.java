package com.driver.services;

import com.driver.models.Card;
import com.driver.models.CardStatus;
import com.driver.models.Student;
import com.driver.repositories.CardRepository;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;
    @Autowired
    private CardRepository cardRepository;

    public Student getDetailsByEmail(String email){
        Student student = new Student();

        student = studentRepository4.findByEmailId(email);

        return student;
    }

    public Student getDetailsById(int id){
        Student student = new Student();

        student = studentRepository4.findById(id).get();
        return student;
    }

    public void createStudent(Student student){

//        Student student1 = new Student();
        Card newCard = new Card();
        newCard = cardService4.createAndReturn(student);
//
//        student1.setCard(newCard);
//        studentRepository4.save(student1);


    }

    public void updateStudent(Student student){

        studentRepository4.updateStudentDetails(student);
        studentRepository4.save(student);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
//        Student student = studentRepository4.findById(id).get();

//        Card card = new Card();

//        cardRepository.save(card);
       // student.getCard().setCardStatus(CardStatus.DEACTIVATED);
        cardService4.deactivateCard(id);
        studentRepository4.deleteCustom(id);
//        studentRepository4.save(student);
    }
}
