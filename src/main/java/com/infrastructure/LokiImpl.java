package com.infrastructure;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.gateways.ILogger;
import com.javapractice.gateways.ILoki;
import com.javapractice.gateways.ITodoRepository;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.io.IOException;

@Repository
public class LokiImpl implements ILoki {
    private static final String LOKI_ENDPOINT = "http://loki-address:3100/loki/api/v1/push";
    private static final HttpClient httpClient = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)
        .connectTimeout(Duration.ofSeconds(10))
        .build();


    @Override
    public String deleteTodo(DeleteTodoRequest request) {
        try {
            // writeStringToFile(request.username, "./");
            // sendLogToLoki("Deleted todo with ID " + request.id);
            return "Wrote to file and Logged to Loki";
        } catch (Exception e) {
            // TODO: handle exception
            return "Failed to write to file and log to Loki";
        }
    }

    public static void writeStringToFile(String content, String filePath) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes(StandardCharsets.UTF_8));
    }

    public static void sendLogToLoki(String logMessage) throws IOException, InterruptedException {
        String payload = createLokiPayload(logMessage);

        HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(payload))
            .uri(URI.create(LOKI_ENDPOINT))
            .header("Content-Type", "application/json")
            .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() != 204) {
            System.err.println("Failed to send log to Loki: " + response.body());
        }
    }

    private static String createLokiPayload(String logMessage) {
        // This is a basic example, and you'll need to adjust this based on your needs.
        return "{"
            + "\"streams\": [{"
            + "\"stream\": {"
            + "\"label\": \"java_logger\""
            + "},"
            + "\"values\": [["
            + "\"" + System.currentTimeMillis() + "000000\","  // Loki expects microsecond precision
            + "\"" + logMessage + "\""
            + "]]"
            + "}]"
            + "}";
    }
    
}
