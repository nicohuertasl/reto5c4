package com.usa.ciclo4.reto3ciclo4.controller;

import com.usa.ciclo4.reto3ciclo4.model.Product;
import com.usa.ciclo4.reto3ciclo4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int id){
        return productService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return productService.delete(id);
    }
/**
 * reto5
 * @param price
 * @return 
 */
    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable("price") double price){
        return productService.getByPrice(price);
    }
/**
 * reto5
 * @param description
 * @return 
 */
    @GetMapping("/description/{description}")
    public List<Product> getByDescriptionContains(@PathVariable("description") String description){
        return productService.getByDescriptionContains(description);
    }
}
