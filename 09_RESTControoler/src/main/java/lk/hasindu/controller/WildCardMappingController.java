package lk.hasindu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class WildCardMappingController {

    @GetMapping("test/*/hello")
    public String test() {
        return "test";
    }

//    @GetMapping("hello/**/ijse")
//    public String hello() {
//        return "hello 2";
//    }
//
//    @GetMapping("test/*/*")
//    public String test2() {
//        return "test 2";
//    }
}
