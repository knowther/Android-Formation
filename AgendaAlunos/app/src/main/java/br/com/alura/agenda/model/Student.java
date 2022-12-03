package br.com.alura.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Student implements Parcelable {
    private int id;
    private String name;
    private String phone;
    private String mail;

    public Student(){

    }

    public Student(int id, String name, String phone, String mail) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    private Student(Parcel p){
        id = p.readInt();
        name = p.readString();
        phone = p.readString();
        mail = p.readString();
    }

    public static final Parcelable.Creator<Student>
            CREATOR = new Parcelable.Creator<Student>() {

        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int i) {
            return new Student[0];
        }
    };



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeString(name);
            parcel.writeString(phone);
            parcel.writeString(mail);

    }

    @Override
    public String toString() {
        return name;
    }

    public boolean hasValidId() {
      return  id > 0;
    }
}
