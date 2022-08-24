package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//This Annotation will directly affect the Database
@SpringBootTest
//This Annotation will help us to test the repository layer and will flush the data out.
    //@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    public StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ayushkumarjain1105@gmail.com")
                .firstName("Ayush")
                .lastName("Jain")
                //.guardianName("Ashish")
                //.guardianEmail("ashish@gmail.com")
                //.guardianMobile("9878787878")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List =" + studentList);
    }
    @Test
public void saveStudentWithGuardian(){

    Guardian guardian = Guardian.builder().
            name("Shrinu")
            .email("dog@gmail.com")
            .mobile("969696969")
            .build();



        Student student = Student.builder()
                .firstName("Ashish")
                .lastName("Aganihotri")
                .emailId("ashish@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
}
        @Test
        public void findByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Ayush");
            System.out.println("Students Name " + studentList);
        }
        @Test
        public void getStudentByEmailAddress(){
            Student student = studentRepository.getStudentByEmailAddress("ashish@gmail.com");
            System.out.println("Email Name " + student);

        }

        @Test
        public void getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("ashish@gmail.com");
            System.out.println("First Name  " + firstName);
        }

    @Test
    public void getStudentByEmailAddressNative(){
        Student firstName = studentRepository.getStudentByEmailAddressNative("ashish@gmail.com");
        System.out.println("First Name  " + firstName);
    }
    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student firstName = studentRepository.getStudentByEmailAddressNativeNamedParam("ashish@gmail.com");
        System.out.println("First Name  " + firstName);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Monu",
                "ashish@gmail.com"
        );

    }
}