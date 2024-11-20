package uz.kiverak.micro.demo.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.kiverak.micro.demo.student.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllBySchoolId(Integer schoolId);
}
