package de.neuefische.studentdb.repository;

import de.neuefische.studentdb.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    private List<Student> students;

    public StudentRepository(){
        students = new ArrayList<>(List.of(
                new Student("1", "Franz"),
                new Student("2", "Lucy"),
                new Student("3", "Peter")
        ));
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(String id) {
        for (Student student : students) {
            if(student.getId().equals(id)){
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Student save(Student student){
        for(Student aStudent: students){
            if(aStudent.getId().equals(student.getId())){
                aStudent.setName(student.getName());
                return aStudent;
            }
        }
        students.add(student);
        return student;
    }

    public Optional<Student> deleteById(String id) {
        Optional<Student> optionalStudent = findById(id);
        if(optionalStudent.isPresent()){
            students.remove(optionalStudent.get());
        }
        return optionalStudent;
    }
}
