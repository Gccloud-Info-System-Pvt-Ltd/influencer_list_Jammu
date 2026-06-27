package com.example.formapp.controller;

import com.example.formapp.model.Submission;
import com.example.formapp.repository.SubmissionRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Sort;

@Controller
public class FormController {

    private final SubmissionRepository repository;

    public FormController(SubmissionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        if (!model.containsAttribute("submission")) {
            model.addAttribute("submission", new Submission());
        }
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@Valid @ModelAttribute("submission") Submission submission,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        repository.save(submission);
        return "redirect:/submissions";
    }

    @GetMapping("/submissions")
    public String listSubmissions(Model model) {
        model.addAttribute("submissions",
                repository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return "submissions";
    }
}
