package com.example.ksb2;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductApi {

/* PARAMETR
@GetMapping
  public String getProducts(@RequestParam String name,
                            @RequestParam(required = false, defaultValue = "") String surname) {
    return "Hello " + name + " " + surname;
  }*/

/* PATH poprzez sciezke
@GetMapping("/{name}")
  public String getProducts(@PathVariable String name) {
    return "Hello " + name;
  }
  */

  //HEADER
/*  @GetMapping
  public String getProducts(@RequestHeader String name) {
    return "Hello " + name;
  }*/


  //BODY
/*  @GetMapping
  public String getProducts(@RequestBody String name) {
    return "Hello " + name;
  }*/

  @PostMapping
  public String addProducts() {
    return "Hello world with POST";
  }

  @PutMapping
  public String modProducts() {
    return "Hello world with PUT";
  }

  @DeleteMapping
  public String removeProducts() {
    return "Hello world with DELETE";
  }
}
