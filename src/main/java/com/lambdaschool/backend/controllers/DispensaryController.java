package com.lambdaschool.backend.controllers;

import com.lambdaschool.backend.models.Dispensary;
import com.lambdaschool.backend.services.DispensaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispensary")
public class DispensaryController {
   @Autowired
    private DispensaryService dispensaryServices;

   @GetMapping(value = "/dispensary/{dispensarycode}", produces = "application/json")
    public ResponseEntity<?>findByDispensaryCode(@PathVariable long dispensarycode){
       Dispensary myDispensary = dispensaryServices.findByDispensaryCode(dispensarycode);
       return new ResponseEntity<>(myDispensary, HttpStatus.OK);
   }





}
