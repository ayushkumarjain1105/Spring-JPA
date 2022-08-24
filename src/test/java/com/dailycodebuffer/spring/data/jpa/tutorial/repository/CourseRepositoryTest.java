package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courses =
        courseRepository.findAll();

        System.out.println("Courses = " + courses);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                (Pageable) PageRequest.of(0,2);
        Pageable secondPageWithTwoRecords =
                (Pageable) PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords).getContent();
        System.out.println("courses = " + courses);

    }
}