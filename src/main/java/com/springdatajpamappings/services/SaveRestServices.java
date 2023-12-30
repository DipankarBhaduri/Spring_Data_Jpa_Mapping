package com.springdatajpamappings.services;

import com.springdatajpamappings.dtos.StudentWithLaptop;
import com.springdatajpamappings.dtos.TeacherWithLaptop;
import com.springdatajpamappings.entities.Laptop;
import com.springdatajpamappings.entities.Student;
import com.springdatajpamappings.entities.Teacher;
import com.springdatajpamappings.repositories.LaptopRepository;
import com.springdatajpamappings.repositories.StudentRepository;
import com.springdatajpamappings.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SaveRestServices {
    private static Logger logger = Logger.getLogger("SaveRestServices");

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LaptopRepository laptopRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public ResponseEntity<String> saveStudent (Student student) {
        Student std = null;
        try {
            std = studentRepository.save(student);
        }catch (Exception e) {
            logger.info("Error during save Student data : {} "+student.getName());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student.getName() + " Saved!!", HttpStatus.OK);
    }

    public ResponseEntity<String> saveLaptop(Laptop laptop) {
        Laptop lap = null;
        try {
            lap = laptopRepository.save(laptop);
        }catch (Exception e) {
            logger.info("Error during save laptop data : {} ");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(lap.getModel()+" Saved!!", HttpStatus.OK);
    }

    public ResponseEntity<String> saveStudentWithLaptop(StudentWithLaptop studentWithLaptop) {
        Student student = studentWithLaptop.getStudent();
        Laptop laptop = studentWithLaptop.getLaptop();

        try {
            if (student != null && laptop != null) {
                // set the student object to laptop
                laptop.setStudent(student);

                //set the laptop object to student
                student.setLaptop(laptop);
                saveStudent(student);

                return new ResponseEntity<>(student.getName()+" Saved!!", HttpStatus.OK);
            }
        }catch (Exception e) {
            logger.info("Error during save the student and laptop object : {} ");
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> saveTeacherWithLaptop(TeacherWithLaptop teacherWithLaptop) {
        Teacher teacher = teacherWithLaptop.getTeacher();
        List<Laptop> laptopList = teacherWithLaptop.getLaptopList();

        try {
            if (teacher != null && laptopList != null) {
                // set the student object to laptop
                laptopList.forEach(laptop -> laptop.setTeacher(teacher));

                //set the laptop object to student
                teacher.setLaptopList(laptopList);
                saveTeacher(teacher);
                return new ResponseEntity<>(teacher.getName()+" Saved!!", HttpStatus.OK);
            }
        }catch (Exception e) {
            logger.info("Error during save the Teacher and laptop object : {} ");
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> saveTeacher(Teacher teacher) {
        Teacher teacherForResponse = null;
        try {
            teacherForResponse = teacherRepository.save(teacher);
        }catch (Exception e) {
            logger.info("Error during save Teacher data : {} "+teacher.getName());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacher.getName() + " Saved!!", HttpStatus.OK);
    }
}
