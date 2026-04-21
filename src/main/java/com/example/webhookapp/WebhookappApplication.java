package com.example.webhookapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebhookappApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebhookappApplication.class, args);
    }

    @Override
    public void run(String... args) {

        RestTemplate restTemplate = new RestTemplate();

        // STEP 1: Generate webhook
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        WebhookRequest request = new WebhookRequest();
        request.setName("John Doe");
        request.setRegNo("REG12347");   // 👉 CHANGE IF YOUR REG NO IS DIFFERENT
        request.setEmail("john@example.com");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<WebhookRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<WebhookResponse> response =
                restTemplate.postForEntity(url, entity, WebhookResponse.class);

        String webhookUrl = response.getBody().getWebhook();
        String token = response.getBody().getAccessToken();

        System.out.println("Webhook URL: " + webhookUrl);
        System.out.println("Token: " + token);

        // STEP 2: FINAL SQL QUERY
        String finalQuery = "SELECT p.AMOUNT AS SALARY, CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) AS NAME, TIMESTAMPDIFF(YEAR, e.DOB, CURDATE()) AS AGE, d.DEPARTMENT_NAME FROM PAYMENTS p JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID WHERE DAY(p.PAYMENT_TIME) <> 1 ORDER BY p.AMOUNT DESC LIMIT 1;";

        // STEP 3: Send answer
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.set("Authorization", token);

        String body = "{ \"finalQuery\": \"" + finalQuery + "\" }";

        HttpEntity<String> entity2 = new HttpEntity<>(body, headers2);

        ResponseEntity<String> result =
                restTemplate.postForEntity(webhookUrl, entity2, String.class);

        System.out.println("Submission Response: " + result.getBody());
    }
}