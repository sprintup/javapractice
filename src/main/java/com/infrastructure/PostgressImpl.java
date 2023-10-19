package com.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javapractice.gateways.ITodoRepository;

// This is the concrete implementation of the ITodoRepository, currently implemented with Postgress
// This @Repository decorator allows this repository to enter the inversion of control (IOC) container. It basically just means it's now injectable.
@Repository
public class PostgressImpl implements ITodoRepository {

    private final String url = "jdbc:postgresql://localhost:5432/mydb";
    private final String user = "username";
    private final String password = "password";
    Connection conn;

    public PostgressImpl() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addTodo(String todo) {
        String SQL = "INSERT INTO users(name, email) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, todo);

            return pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
    }
}
