package com.ayush.Commit_tracker.Controller;


import com.ayush.Commit_tracker.Model.Author;
import com.ayush.Commit_tracker.Model.Commit;
import com.ayush.Commit_tracker.Repository.AuthorRepository;
import com.ayush.Commit_tracker.Repository.CommitRepository;
import com.ayush.Commit_tracker.Service.SlackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class GithubWebController {

    private final AuthorRepository authorRepo;
    private final CommitRepository commitRepo;
    private final SlackService slackService;


    public GithubWebController(AuthorRepository authorRepo, CommitRepository commitRepo, SlackService slackService) {
        this.authorRepo = authorRepo;
        this.commitRepo = commitRepo;
        this.slackService = slackService;
    }

    @PostMapping("/github")
    public String handleWebhook(@RequestBody Map<String, Object> payload) {

        Map<String, Object> pusher = (Map<String, Object>) payload.get("pusher");
        String authorName = (String) pusher.get("name");

        Author author = new Author();
        author.setName(authorName);
        authorRepo.save(author);

        List<Map<String, Object>> commits =
                (List<Map<String, Object>>) payload.get("commits");

        List<String> messages = new ArrayList<>();

        for (Map<String, Object> c : commits) {
            String msg = (String) c.get("message");

            Commit commit = new Commit();
            commit.setMessage(msg);
            commit.setAuthor(author);

            commitRepo.save(commit);
            messages.add(msg);
        }

        slackService.sendMessage(authorName, messages);

        return "OK";
    }
}
