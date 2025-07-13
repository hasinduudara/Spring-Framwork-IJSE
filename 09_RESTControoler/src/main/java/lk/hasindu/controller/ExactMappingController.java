package lk.hasindu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exact")
public class ExactMappingController {

    @GetMapping(path = "/hello")
    public String sayHello(){
        return "hello world";
    }

    @GetMapping(path = "/hello/two")
    public String sayHelloGet(){
        return "hello world two";
    }

    @GetMapping(path = "hello/two/api")
    public String sayHelloPost(){
        return "hello world two api";
    }
}
