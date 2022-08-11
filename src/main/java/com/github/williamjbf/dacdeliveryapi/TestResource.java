package com.github.williamjbf.dacdeliveryapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestResource {

    @GetMapping
    public String teste(){
        return "funcionando";
    }
}
