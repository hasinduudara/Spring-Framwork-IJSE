package lk.ijse.gdse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {
    public ItemController() {
        System.out.println("Item Controller Constructor");
    }

    @GetMapping
    public String item() {
        return  "item";
    }
}
