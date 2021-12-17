package org.controller;


import org.model.Product;
import org.service.ProductCategoryService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductCategoryService productCategoryService;

    public ProductController(ProductCategoryService productCategoryService)
    {
        this.productCategoryService=productCategoryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping ("/product-form")
    public String showForm(Model model)
    {
        model.addAttribute("product",new Product());
        model.addAttribute("categories",productCategoryService.getAll());
        return "product-form";
    }

    @RequestMapping("/process-request")
    public String processRequest(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors())
        {
            model.addAttribute("categories",productCategoryService.getAll());
            return "product-form";
        }
        else {
            return "confirmation";
        }
    }


}
