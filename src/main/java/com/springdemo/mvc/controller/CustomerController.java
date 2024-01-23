package com.springdemo.mvc.controller;

import com.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/v1/customerForm")
    public String showCostomerForm(Model model) {

        Customer theCustomer = new Customer();

        logger.info(" /v1/customerForm is called!");

        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/v1/processCustomerForm")
    public String processCustomer(@Valid @ModelAttribute("customer") Customer theCutomer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.error("Firstname and Lastname Validation is failed!");
            return "customer-form";
        } else {
            //Log2
            logger.info("Customer {} {} is registerd!", theCutomer.getFirstName(), theCutomer.getLastName());

            return "customer-confirmation";
        }
    }


}
