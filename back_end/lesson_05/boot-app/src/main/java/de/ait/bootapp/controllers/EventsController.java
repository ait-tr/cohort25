package de.ait.bootapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 9/6/2023
 * boot-app
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Controller
public class EventsController {

    private List<String> words = new ArrayList<>();

    @PostMapping("/words")
    public String addWord(@RequestParam("word") String word) {
        words.add(word);
        return "redirect:/success_add_word.html";
    }

    @GetMapping("/words")
    public String getWordsPage(Model model) {
        model.addAttribute("wordsList", words);
        return "words_page";
    }
}
