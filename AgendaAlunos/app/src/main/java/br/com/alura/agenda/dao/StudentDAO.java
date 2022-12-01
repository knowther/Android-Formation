package br.com.alura.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Student;



public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }



}
