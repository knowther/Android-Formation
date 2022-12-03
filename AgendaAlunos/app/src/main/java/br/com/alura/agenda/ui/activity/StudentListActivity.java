package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.StudentDAO;
import br.com.alura.agenda.model.Student;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle("Lista de Alunos");
        FloatingActionButton addStudentButton = findViewById(R.id.floatingActionButton7);
        addStudentButton.setOnClickListener(view -> {
           openFormActivity();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
       configList();
    }


    private void openFormActivity(){
        startActivity(new Intent(StudentListActivity.this, StudentFormActivity.class));
    }

    private void configList(){
        StudentDAO dao = new StudentDAO();
        dao.save(new Student("Johnny", "12345613", "teste@teste.com"));
        final ListView studentList = findViewById(R.id.activity_main_list_view);
        final List<Student> students = dao.getStudents();
        studentList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.getStudents()));
        studentList.setOnItemClickListener((adapterView, view, position, id) -> {
            Student selectedStudent = students.get(position);
          Intent goToFormActivity =  new Intent(StudentListActivity.this, StudentFormActivity.class);
          goToFormActivity.putExtra("student", selectedStudent);
          startActivity(goToFormActivity);
        });

    }
}
