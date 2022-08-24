package com.dailycodebuffer.spring.data.jpa.tutorial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
//Using Embeddable Annotation what will happen is a new entity will
// not be created this class will be embeddable in the database.
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//mapping the names to the table name in the Data-base
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),@AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),@AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
)
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
