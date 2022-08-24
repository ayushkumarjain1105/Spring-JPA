package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    //Entity relationships often depend on the existence of another entity,
    // for example the Person–Address relationship. Without the Person, the Address
    // entity doesn't have any meaning of its own.
    // When we delete the Person entity, our Address entity should also get deleted.
    @OneToOne(
        cascade = CascadeType.ALL
            //fetch = FetchType.EAGER
            //DataIntegrityViolationException
            //course will not be saved without Course Material
            ,optional = false
            //If the fetch type is lazy then it will not bring the course. when called.Until specifically called.
            //When fetch type is eger then all the data will be called
    )
    //object references an unsaved transient instance - save the transient instance before flushing
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
