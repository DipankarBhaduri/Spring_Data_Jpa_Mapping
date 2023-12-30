package com.springdatajpamappings.services;

import com.springdatajpamappings.dtos.TeacherWithLaptop;
import com.springdatajpamappings.entities.Laptop;
import com.springdatajpamappings.entities.Teacher;
import com.springdatajpamappings.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RetrievalRestServices {
    private static Logger logger = Logger.getLogger("SaveRestServices");
    @Autowired
    private TeacherRepository teacherRepository;

    public ResponseEntity<TeacherWithLaptop> getTeacherLaptop (int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        TeacherWithLaptop teacherWithLaptop = new TeacherWithLaptop();
        Teacher teacher1 = new Teacher();
        teacher1.setName(teacher.get().getName());
        teacher1.setAbout(teacher.get().getAbout());

        List<Laptop> laptopList = new ArrayList<>();
        teacher.get().getLaptopList().forEach(laptop -> {
            Laptop laptop1 = new Laptop();
            laptop1.setModel(laptop.getModel());
            laptop1.setDescription(laptop.getDescription());
            laptopList.add(laptop1);
        });

        teacherWithLaptop.setTeacher(teacher1);
        teacherWithLaptop.setLaptopList(laptopList);
        return new ResponseEntity<>(teacherWithLaptop, HttpStatus.OK);
    }
}
