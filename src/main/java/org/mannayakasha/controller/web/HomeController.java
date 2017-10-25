package org.mannayakasha.controller.web;

import org.mannayakasha.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Home Controller
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {

        List<Product> products = new ArrayList<>();

        Product product1 = new Product("product1", 100.0);
        Product product2 = new Product("product2", 200.0);

        products.add(product1);
        products.add(product2);

        model.addAttribute("products", products);

        return "index";
    }
}
