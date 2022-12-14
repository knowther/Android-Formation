package br.com.alura.agenda.dao;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Student;



public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Student student) {
        student.setId(idCounter);
        students.add(student);
        idCounter++;
    }

    public void edit(Student student){
        Student studentFinded = null;
        Log.i("student", "edit: " + student);
        for(Student s : students){
            if(s.getId() == student.getId()){
                studentFinded = s;
            }
        }
        if (studentFinded != null){
          int studentPosition =  students.indexOf(studentFinded);
            Log.i("position:", "edit: "+ studentPosition);
          students.set(studentPosition, student);
        }
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }



}
