package org.atech.dbi.controller;

//import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService helloService;

//    @GetMapping("/hello")
//    public String hello(@RequestParam("name") String name){
//        return helloService.sayHello(name);
//    }
//
//    @GetMapping("/hello2")
//    public String circuitBreaker(@RequestParam("name") String name){
//        return helloService.circuitBreaker(name);
//    }

}
