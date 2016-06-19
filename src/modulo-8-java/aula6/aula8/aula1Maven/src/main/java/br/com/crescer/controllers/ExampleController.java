package br.com.crescer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Hedo Eccker
 */
@Controller
@RequestMapping(value = "/example")
public class ExampleController {

    @RequestMapping(value = "/index")
    String toIndex(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name != null ? name : "Default");
        return "index";
    }
}
