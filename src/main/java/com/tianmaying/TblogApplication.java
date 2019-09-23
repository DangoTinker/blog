package com.tianmaying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@Controller
public class TblogApplication {

    @RequestMapping("/")
    @ResponseBody
    String greeting() {
        return "Hello World";
    }

    @RequestMapping("/index.html")
    @ResponseBody
    public String index() {
        return "<html><head><title>Hello World!</title></head><body><h1>Hello World!</h1><p>This is my first web site</p></body></html>";
    }


    @RequestMapping("/time")

    @ResponseBody

    public String time() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date now = new Date();

        String hehe = dateFormat.format(now);

        return hehe;

    }

    public static void main(String[] args) {
        SpringApplication.run(TblogApplication.class, args);
    }

}