package br.com.alura.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.StudentDAO;
import br.com.alura.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle("Cadastrar Aluno");

        StudentDAO dao = new StudentDAO();

        //elements
        final EditText nameField = findViewById(R.id.activity_student_form_name_edit_text);
        final EditText phoneField = findViewById(R.id.activity_student_form_phone_edit_text);
        final EditText mailField = findViewById(R.id.activity_student_form_mail_edit_text);
        final Button saveButton = findViewById(R.id.activity_student_form_button_save);

        saveButton.setOnClickListener(view -> {
            String name = nameField.getText().toString();
            String phone = phoneField.getText().toString();
            String mail = mailField.getText().toString();

            Student newStudent = new Student(name, phone, mail);
            dao.save(newStudent);

            startActivity(new Intent(StudentFormActivity.this, StudentListActivity.class));
        } );
    }
}