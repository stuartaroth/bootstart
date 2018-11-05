package org.stuartaroth.bootstart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.stuartaroth.bootstart.models.Book;
import org.stuartaroth.bootstart.services.config.ConfigService;
import org.stuartaroth.bootstart.services.data.DataService;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private DataService dataService;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public String root() {
        return "i am root";
    }

    @RequestMapping(
            value = "/book",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Book book() {
        return new Book("It", "Stephen King", "Horror");
    }

    @RequestMapping(
            value = "/config",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    public ConfigService config() {
        return configService;
    }

    @RequestMapping(
            value = "/http",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Book http() {
        RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject("http://localhost:8080/book", Book.class);
        return book;
    }

    @RequestMapping(
            value = "/post",
            method = RequestMethod.POST,
            produces = { MediaType.TEXT_PLAIN_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE })
    public String post(@RequestBody Book book) {
        String received = String.format("Book(%s,%s,%s)", book.getTitle(), book.getAuthor(), book.getGenre());
        return "Received: " + received;
    }

    @RequestMapping(
            value = "/headers",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Map<String, String> headers(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @RequestMapping(
            value = "/data",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<String> data() {
        return dataService.getData();
    }
}
