package com.jttrinh.restfullapi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RESTAPI
@RestController
public class HelloWorldController {

//    @RequestMapping(method = RequestMethod.GET, path = "hello-world")
    @GetMapping(path = "hello-world")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world bean");
    }

    @GetMapping(path = "path-variable/{name}")
    public HelloWorldBean pathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world, %s", name));
    }

}
