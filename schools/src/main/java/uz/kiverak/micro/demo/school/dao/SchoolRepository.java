package uz.kiverak.micro.demo.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.kiverak.micro.demo.school.entity.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
