package com.ayush.Commit_tracker.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SlackService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String webhookUrl = "https://hooks.slack.com/services/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";

    public void sendMessage(String author, List<String> commits) {

        String text = " " + author + " pushed this :\n";

        for (String msg : commits) {
            text += "- " + msg + "\n";
        }

        Map<String, String> body = new HashMap<>();
        body.put("text", text);

        restTemplate.postForObject(webhookUrl, body, String.class);
    }
}