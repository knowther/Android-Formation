package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.StudentDAO;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle("Lista de Alunos");
        FloatingActionButton addStudentButton = findViewById(R.id.floatingActionButton7);
        addStudentButton.setOnClickListener(view -> {
            startActivity(new Intent(StudentListActivity.this, StudentFormActivity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAO();
        final ListView studentList = findViewById(R.id.activity_main_list_view);
        studentList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.getStudents()));
    }
}