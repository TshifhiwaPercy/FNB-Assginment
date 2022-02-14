package com.example.fnb.assignment.controller;

import com.example.fnb.assignment.entity.API_ENTITY;
import com.example.fnb.assignment.logic.Change;
import com.example.fnb.assignment.repository.API_ENTITY_REPOSITORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private API_ENTITY_REPOSITORY API_ENTITY_REPO;
    @GetMapping("/")//Echo server
    public boolean echo(){return true;}
    //This api allows a user to create a login Id
    //Usage example localhost:8080/login?=1
    @RequestMapping(value="/login", method= RequestMethod.PUT)
    public String getApiKey(@RequestParam long ID){
        try{
            API_ENTITY_REPO.save(new API_ENTITY(ID));
            return "Login credentials created";
        }
        catch(Exception ex){
            return ex.toString();
        }
    }
    //This api allows a user to pass an amount then returns the minimum combination of rands
    //Usage: localhost:8080/amount?amount=212&Id=2342 -->user id that they provided during the login page phase
    @GetMapping("/change")
    public String getChange(@RequestParam Integer[] arr,@RequestParam int amount, @RequestParam long Id){
       Optional<API_ENTITY> enti = API_ENTITY_REPO.findById(Id);
       if(enti.isEmpty()){


           return "<html>" +
                   "<head>" +
                   "<title>Error</title>" +
                   "</head>" +
                   "<body>" +
                   "<h1>User unauthorized</h1>" +
                   "</body>" +
                   "</html>";
       }
       else{
          Change change = new Change(arr,amount);
          return change.getChange().toString();
       }
    }

    //Displays all the current users in the system.
    @GetMapping("/users")
    public Iterable<API_ENTITY> getUsers(){
        return API_ENTITY_REPO.findAll();
    }
}
