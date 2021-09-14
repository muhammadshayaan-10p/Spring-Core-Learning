package com.shayaan.dao;

import com.shayaan.jdbcdemo.Student;

import java.util.List;

public interface StudentDAO {
    public void insert(Student student);
    public boolean deleteByID(int rollNo);
    public boolean deleteByNameOrAddress(String name, String address);
    void insert(List<Student> students);


}
