package ru.filippov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.filippov.entity.EntitySort;
import ru.filippov.sorter.BubbleSorter;
import ru.filippov.task3.JPARepos.SortRepo;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    private SortRepo sortRepo;





    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="User") String name, Map<String, Object> model) {
        model.put("name", name);

        model.put("sorts", sortRepo.findAll());


        return "index";
    }

    @PostMapping("/")
    public String addSort(@RequestParam String arr, Map<String, Object> model) {

        List<Double> collect = Arrays.stream(arr.split(" ")).map(s -> Double.parseDouble(s)).collect(Collectors.toList());
        new BubbleSorter().sort(collect, (Comparator<Double>) (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            }
            return 0;
        });

        StringBuilder stringBuilder2 = new StringBuilder(30);

        collect.stream().forEach(value -> stringBuilder2.append(value + " "));

        EntitySort entity = new EntitySort();
        entity.setInputs(arr);
        entity.setOutput(stringBuilder2.toString());
        entity.setDate(new Date());

        sortRepo.save(entity);

        model.put("sorts", sortRepo.findAll());


        return "index";
    }
}
