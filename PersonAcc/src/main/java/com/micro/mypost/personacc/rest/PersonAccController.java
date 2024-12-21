package com.micro.mypost.personacc.rest;

import com.micro.mypost.personacc.client.UserAPI;
import com.micro.mypost.personacc.office.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController

public class PersonAccController {
    @Autowired
    private UserAPI userAPI;


    @GetMapping(value = "/")
    public String getIndex() {
        return userAPI.getUser("Adam").toString();
    }

    @GetMapping(value = "/offices")
    public ModelAndView getOffices(ModelMap model) {
        List<Office> officesList = List.of(
                new Office(1, "ул.Пушкина д.Колотушкина", "10-20, Перерыв с 12-13"),
                new Office(2, "ул.Луганка д.2", "10-20, Перерыв с 12-13"),
                new Office(3, "ул.Красная Площадь д.1", "10-20, Перерыв с 12-13"));
        model.addAttribute("allOffices", officesList);
        return new ModelAndView("offices", model);
    }


}
