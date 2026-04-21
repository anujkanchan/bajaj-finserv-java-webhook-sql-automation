package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void startFlow() {

        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> request = new HashMap<>();
        request.put("name", "John Doe");
        request.put("regNo", "REG12347");
        request.put("email", "john@example.com");

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        Map<String, Object> body = response.getBody();

        if (body == null) {
            System.out.println("Error: No response from API");
            return;
        }

        String webhookUrl = (String) body.get("webhook");
        String accessToken = (String) body.get("accessToken");

        System.out.println("Webhook URL: " + webhookUrl);
        System.out.println("Access Token: " + accessToken);

        // ✅ FINAL SQL QUERY (CORRECT)
        String finalQuery = "SELECT p.AMOUNT AS SALARY, CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) AS NAME, TIMESTAMPDIFF(YEAR, e.DOB, CURDATE()) AS AGE, d.DEPARTMENT_NAME FROM PAYMENTS p JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID WHERE DAY(p.PAYMENT_TIME) <> 1 ORDER BY p.AMOUNT DESC LIMIT 1;";

        submitAnswer(webhookUrl, accessToken, finalQuery);
    }

    private void submitAnswer(String webhookUrl, String token, String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("finalQuery", query);

        HttpEntity<Map<String, String>> entity =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(webhookUrl, entity, String.class);

        System.out.println("Final Response: " + response.getBody());
    }
}