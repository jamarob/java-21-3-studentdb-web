package de.neuefische.studentdb.service;

import de.neuefische.studentdb.model.Student;
import de.neuefische.studentdb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student createStudent(Student student) {
        String id = UUID.randomUUID().toString();
        Student newStudent = new Student(id, student.getName());
        return studentRepository.save(newStudent);
    }

    public Optional<Student> deleteStudent(String id) {
        return studentRepository.deleteById(id);
    }
}
