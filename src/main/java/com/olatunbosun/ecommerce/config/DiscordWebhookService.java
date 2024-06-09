package com.olatunbosun.ecommerce.config;

/**
 * @author olulodeolatunbosun
 * @created 09/06/2024/06/2024 - 19:09
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class DiscordWebhookService {

    @Value("${application.discord.webhook.url}")
    private static String webhookUrl;

    public DiscordWebhookService(@Value("${application.discord.webhook.url}") String webhookUrl) {
        DiscordWebhookService.webhookUrl = webhookUrl;
    }

    public static void sendLog(String message) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = null;
        try {
            jsonPayload = objectMapper.writeValueAsString(Collections.singletonMap("content", message));
            System.out.println("Payload: " + jsonPayload);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }


        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);
        ResponseEntity<String> response = restTemplate.exchange(webhookUrl, HttpMethod.POST, entity, String.class);

        System.out.println("Response: " + response.getBody());
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Log sent to Discord successfully");
        } else {
            System.err.println("Failed to send log to Discord");
        }
    }
}
