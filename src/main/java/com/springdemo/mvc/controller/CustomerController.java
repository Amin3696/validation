package com.springdemo.mvc.controller;

import com.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    //add an initbinder ... to convert trim inputs
    //remove leading and trailing whitespace
    //resolve issue of validation with whitespace

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        var stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/v1/customerForm")
    public String showCostomerForm(Model model) {

        Customer theCustomer = new Customer();

        logger.info(" /v1/customerForm is called!");

        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/v1/processCustomerForm")
    public String processCustomer(
            @Valid @ModelAttribute("customer") Customer theCutomer,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            logger.error("Validation is failed! check First name, Last name, Free Pass or course code.");
            return "customer-form";
        } else {
            //Log2
            logger.info("Customer {} {} is registerd!", theCutomer.getFirstName(), theCutomer.getLastName());

            return "customer-confirmation";
        }
    }


}
