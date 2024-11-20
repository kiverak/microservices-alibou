package uz.kiverak.micro.demo.school.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.kiverak.micro.demo.school.client.StudentClient;
import uz.kiverak.micro.demo.school.dao.SchoolRepository;
import uz.kiverak.micro.demo.school.dto.FullSchoolResponse;
import uz.kiverak.micro.demo.school.entity.School;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}