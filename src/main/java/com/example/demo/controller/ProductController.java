package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /*
        http://localhost:8085/product/buyProduct
        {
          "pname":"Samsung LED TV",
          "price":89000.444,
          "quantity":4
        }
     */

    @GetMapping(value = "/testProduct")
    public String productTestPage()
    {
       String msg="<h2 style='color:green'>Product Service Is Working!</h2>";
       return msg;
    }
    @PostMapping(value = "/buyProduct")
    public ResponseEntity<Product> buyProduct(@RequestBody Product product)
    {
    	
          return new ResponseEntity<>(productService.buyProduct(product), HttpStatus.CREATED);
    }
}