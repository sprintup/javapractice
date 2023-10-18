package com.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.gateways.ITodoRepository;

@Repository
public class PostgressImpl implements ITodoRepository {

    private final String url = "jdbc:postgresql://localhost:5432/mydb";
    private final String user = "username";
    private final String password = "password";
    Connection conn;

    // constructor that connects to the database
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

    @Override
    public String deleteTodo(DeleteTodoRequest request) {
        // for example purposes only
        return "Todo with ID " + request.id + " has been deleted.";

        // try {
        //     String sql = "DELETE FROM todos WHERE id = ?";
        //     PreparedStatement pstmt = conn.prepareStatement(sql);

        //     pstmt.setInt(1, request.id);

        //     int affectedRows = pstmt.executeUpdate();
        //     if (affectedRows > 0) {
        //         return "Todo with ID " + request.id + " has been deleted.";
        //     } else {
        //         return "Todo with ID " + request.id + " was not found.";
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        //     return "Failed to delete todo with ID " + request.id;
        // }
    }
}
