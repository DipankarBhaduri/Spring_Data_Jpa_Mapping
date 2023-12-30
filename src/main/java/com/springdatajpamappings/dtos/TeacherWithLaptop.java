package com.springdatajpamappings.dtos;

import com.springdatajpamappings.entities.Laptop;
import com.springdatajpamappings.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherWithLaptop {
    private Teacher teacher;
    private List<Laptop> laptopList;
}
