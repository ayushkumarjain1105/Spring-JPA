package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//Defining the Table name
//Adding Constraints in the Table
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    //Generating the sequence which will be automatically increment the primary key
  @SequenceGenerator(
          name = "student_sequence",
          sequenceName = "student_sequence",
          allocationSize = 1
  )
    //sequence are created in oracle
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    //Defining th Name of Colum
    @Column(name = "email_address",
            //Defining emailId should be not nullable
            nullable = false
            )
    private String emailId;
    //this class is Embedded
    @Embedded
    private Guardian guardian;

}
