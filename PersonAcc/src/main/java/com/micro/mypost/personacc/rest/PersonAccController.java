package com.micro.mypost.personacc.rest;

import com.micro.mypost.personacc.client.OfficeAPI;
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
    @Autowired
    private OfficeAPI officeAPI;


    @GetMapping(value = "/")
    public String getIndex() {
        return userAPI.getUser("Adam").toString();
    }

    @GetMapping(value = "/offices")
    public ModelAndView getOffices(ModelMap model) {
        List<Office> officesList = officeAPI.getAllOffices().stream()
                .map(officeDTO ->
                        new Office(officeDTO.getNumber(), officeDTO.getAddress(), officeDTO.getWorkTime())).toList();
        model.addAttribute("allOffices", officesList);
        return new ModelAndView("offices", model);
    }


}
