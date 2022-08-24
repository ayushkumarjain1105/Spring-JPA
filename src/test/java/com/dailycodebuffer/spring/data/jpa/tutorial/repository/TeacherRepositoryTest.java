package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

//    public List<Course> listCourse(){
//        List<Course> courses = new ArrayList<>();
//        Course course = Course.builder()
//                .title("DBA")
//                .credit(4)
//                .build();
//        Course course1 = Course.builder()
//                .title("Bio")
//                .credit(4)
//                .build();
//        courses.add(course);
//        courses.add(course1);
//        return courses;
//    }
    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("DBA")
                .credit(4)
               .build();
        Course course1 = Course.builder()
                .title("Bio")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Devansh")
                .lastName("Langada")
                .courses(List.of(course, course1))
                .build();
    teacherRepository.save(teacher);
    }
}