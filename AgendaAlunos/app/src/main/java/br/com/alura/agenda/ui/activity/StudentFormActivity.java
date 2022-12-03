package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.StudentDAO;
import br.com.alura.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    private EditText nameField;
    private EditText phoneField;
    private EditText mailField;
    private StudentDAO dao;
    private Student newStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle("Cadastrar Aluno");

        dao = new StudentDAO();
        initializeElements();
        configureSaveButton();
        Intent data = getIntent();
        Student student = getIntent().getExtras().getParcelable("student");
        nameField.setText(student.getName());
        phoneField.setText(student.getPhone());
        mailField.setText(student.getMail());

    }
    private Student createStudent(){
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String mail = mailField.getText().toString();
        newStudent = new Student(name, phone, mail);
        return newStudent;
    }

    private void configureSaveButton(){
        final Button saveButton = findViewById(R.id.activity_student_form_button_save);
        saveButton.setOnClickListener(view -> {
            save(createStudent());
        } );
    }

    private void initializeElements(){
        //elements
        nameField = findViewById(R.id.activity_student_form_name_edit_text);
        phoneField = findViewById(R.id.activity_student_form_phone_edit_text);
        mailField = findViewById(R.id.activity_student_form_mail_edit_text);
    }
    private void save(Student newStudent){
        dao.save(newStudent);
        finish();
    }
}