package org.mannayakasha.controller.rest;

import org.mannayakasha.entity.Product;
import org.mannayakasha.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = {"http://localhost:8100","file://"})
@CrossOrigin(origins = "http://localhost:8100")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{category}")
    public ResponseEntity<List<Product>> getAllProductsWithCategory(@PathVariable String category) {
        List<Product> products = productService.getAllWithCategory(category);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
