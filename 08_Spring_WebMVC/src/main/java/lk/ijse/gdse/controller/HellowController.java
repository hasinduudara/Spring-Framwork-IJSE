package lk.ijse.gdse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("hello")
public class HellowController {
    public HellowController() {
        System.out.println("Hello Controller Constructor");
    }

    @GetMapping
    public String hello() {
        return "index";
//        System.out.println("Hello, World!");
    }

//    @GetMapping("one")
//    public  String hello1(){
//        return "Hello, One!";
//    }
//
//    @GetMapping("two")
//    public  String hello2(){
//        return "Hello, Two!";
//    }
}
