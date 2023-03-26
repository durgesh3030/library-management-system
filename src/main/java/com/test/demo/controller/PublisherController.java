package com.test.demo.controller;

import com.test.demo.entity.Publisher;
import com.test.demo.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class PublisherController {
    public final PublisherService publisherService;
    public PublisherController(PublisherService publisherService){
        this.publisherService=publisherService;
    }
    @RequestMapping("/publishers")
    @ResponseBody
    public  List<Publisher>getAllPublisher(){
        return publisherService.findAllPublishers ();
    }
    @RequestMapping("/publisher/{id}")
    @ResponseBody
    public Publisher getPublisherById( @PathVariable("id")Long id ){
        return publisherService.findPublisherById (id);
    }
    @RequestMapping(value = "/publisher/create", method = RequestMethod.POST)
    @ResponseBody
    public  String createPublisher( @RequestBody Publisher publisher){
        publisherService.createPublisher (publisher);
        return "Category created successfully";
    }
    @RequestMapping(value = "/publisher/update",method = RequestMethod.PUT)
    @ResponseBody
    public String updatePublisher(@RequestBody Publisher publisher){
        publisherService.updatePublisher (publisher);
        return "Publisher Update successfully";
    }
    @RequestMapping(value = "/publisher/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePublisher(@PathVariable("id") Long id){
        publisherService.deletePublisher (id);
        return  "Publisher Delete successfully";
    }
}


