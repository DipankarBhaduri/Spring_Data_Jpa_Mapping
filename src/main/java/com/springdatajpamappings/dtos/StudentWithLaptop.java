package com.springdatajpamappings.dtos;

import com.springdatajpamappings.entities.Laptop;
import com.springdatajpamappings.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithLaptop {
    private Student student;
    private Laptop laptop;
}
