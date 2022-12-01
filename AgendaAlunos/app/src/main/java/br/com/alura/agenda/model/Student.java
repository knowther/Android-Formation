package br.com.alura.agenda.model;

public class Student {
    private String name;
    private String phone;
    private String mail;

    public Student(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return name;
    }
}
