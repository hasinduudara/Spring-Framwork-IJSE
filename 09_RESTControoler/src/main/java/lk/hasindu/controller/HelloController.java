package lk.hasindu.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String hello1(){
        return "hello 1";
    }

    @GetMapping("/two")
    public String hello2(){
        return "hello 2";
    }

    @PostMapping
    public  String post(){
        return "post";
    }

    @PutMapping
    public  String put(){
        return "put";
    }

    @PatchMapping
    public  String patch(){
        return "patch";
    }

    @DeleteMapping
    public  String delete(){
        return "delete";
    }

}
