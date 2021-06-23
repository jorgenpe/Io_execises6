package data_access;


import Models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentDaoListImpl implements StudentDao {

    List<Student> students;

    public StudentDaoListImpl(List<Student> students) {
        this.students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if(!students.contains(student)){
            students.add(student);
        }

        return student;
    }

    @Override
    public Student find(int id) {
        for(Student m: students)
        {
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students) ;
    }

    @Override
    public void delete(int id) {

        for(Student m: students)
        {
            if(m.getId() == id){
                students.remove(m);
            }
        }

    }
}
