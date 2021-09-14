package com.shayaan.dao;

import com.shayaan.jdbcdemo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {


    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        //logic to store student obj to the DB
        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        Object[] arg = {student.getRollNo(),student.getName(),student.getAddress()};

        jdbcTemplate.update(sql, arg);
    }

    @Override
    public boolean deleteByID(int rollNo) {

        String query = "DELETE FROM STUDENT WHERE Roll_No = ?";
        int record = jdbcTemplate.update(query, rollNo);
        System.out.println("Number of rows deleted: " + record);
        return record == 1;
    }

    @Override
    public boolean deleteByNameOrAddress(String name, String address) {
        String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";
        Object[] args = {name,address};
        jdbcTemplate.update(sql, args);
        return false;
    }

    @Override
    public void insert(List<Student> students) {
        String sql = "INSERT INTO STUDENT(Roll_No, Student_Name, Student_Address) VALUES(?,?,?)";

        ArrayList<Object[]> sqlArgs = new ArrayList<>();
        for (Student temp: students) {
            Object[] args = {temp.getRollNo(), temp.getName(), temp.getAddress()};
        }
        jdbcTemplate.batchUpdate(sql,sqlArgs);
    }


    //Configured in Beans.xml
//    public DataSource getDataSource(){
//        String url = "jdbc:mysql://localhost:3306/school";
//        String username = "root";
//        String password = "password";
//
//        DataSource dataSource = new DriverManagerDataSource(url, username, password);
//        return dataSource;
//    }
}
