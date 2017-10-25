package org.mannayakasha.controller.web;

import org.mannayakasha.entity.Product;
import org.mannayakasha.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("products", productService.getAll());

        return "index";
    }
}
