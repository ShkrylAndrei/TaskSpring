package ru.andrei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.andrei.model.MessageDynamoDB;
import ru.andrei.repository.InfoDynamoRepository;

@Controller
public class WorkWithDatabase {
    @Autowired
    private InfoDynamoRepository repo;

    @GetMapping("/getAllData")
    public String getAllData(Model model){
        Iterable<MessageDynamoDB>  messageCollection = repo.findAll();
        model.addAttribute("allData",messageCollection);
        return "AllData";
    }

}
