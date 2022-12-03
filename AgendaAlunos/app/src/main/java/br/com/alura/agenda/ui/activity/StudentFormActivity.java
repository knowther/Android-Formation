package br.com.alura.agenda.ui.activity;

import static br.com.alura.agenda.ui.activity.ConstraintsActivity.KEY_STUDENT;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.StudentDAO;
import br.com.alura.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {




    private EditText nameField;
    private EditText phoneField;
    private EditText mailField;
    private StudentDAO dao;
    private int studentId;
    private Student newStudent = new Student();
    private String title_appbar_create;
    private String title_appbar_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: VER COMO FUNCIONA STRING RESOURCE JAVA
        String res = getResources().getString(R.string.add_student_title_bar);
        setContentView(R.layout.activity_student_form);
        title_appbar_create = res;
        title_appbar_edit = getString(R.string.edit_student_app_bar);


        dao = new StudentDAO();
        initializeElements();
        configureSaveButton();
        loadStudent();
    }

    private void loadStudent() {
        Intent data = getIntent();
        if(data.hasExtra(KEY_STUDENT)){
            setTitle(title_appbar_edit);
            Student student = data.getParcelableExtra(KEY_STUDENT);
            nameField.setText(student.getName());
            phoneField.setText(student.getPhone());
            mailField.setText(student.getMail());
            studentId = student.getId();
        }else{
            setTitle(title_appbar_create);
            newStudent = new Student();
        }
    }

    private void createStudent(){

        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String mail = mailField.getText().toString();

        newStudent.setId(studentId);
        fillFields(name, phone, mail);
    }

    private void fillFields(String name, String phone, String mail) {
        newStudent.setName(name);
        newStudent.setPhone(phone);
        newStudent.setMail(mail);
    }

    private void configureSaveButton(){
        final Button saveButton = findViewById(R.id.activity_student_form_button_save);
        saveButton.setOnClickListener(view -> {
//            save(createStudent());
            createStudent();
            if(newStudent.hasValidId()){
                dao.edit(newStudent);
            }else{
                dao.save(newStudent);
            }
            finish();
        } );
    }

    private void initializeElements(){
        //elements
        nameField = findViewById(R.id.activity_student_form_name_edit_text);
        phoneField = findViewById(R.id.activity_student_form_phone_edit_text);
        mailField = findViewById(R.id.activity_student_form_mail_edit_text);
    }
}