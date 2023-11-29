package vakcheck.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vakcheck")
public class Controller {

    @GetMapping
    public String teste(){
        return "teste url";
    }
}
