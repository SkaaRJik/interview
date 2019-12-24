package ru.filippov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.filippov.entity.EntitySort;
import ru.filippov.task3.JPARepos.SortRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private SortRepo sortRepo;


    @GetMapping("/")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="User") String name, Model model) {
        model.addAttribute("name", name);
        List<EntitySort> all = new ArrayList<>();

                sortRepo.findAll().forEach(all::add);;
        System.out.println(all);
        model.addAttribute("sorts", all);


        return "index";
    }
}
