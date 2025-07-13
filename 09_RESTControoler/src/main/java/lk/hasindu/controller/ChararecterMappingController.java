package lk.hasindu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/char")
public class ChararecterMappingController {

    @GetMapping(path = "item/I???")
    public String item(){
        return "Item with character mapping";
    }

    @GetMapping(path = "????/search")
    public String search(){
        return "Search with character mapping";
    }
}
