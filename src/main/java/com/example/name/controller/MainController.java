
package com.example.name.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.name.dao.ChennelDAO;
import com.example.name.dao.SubscriberDAO;
import com.example.name.model.Chennel;
import com.example.name.model.Subscriber;

@Controller
public class MainController {

    @Autowired
    private SubscriberDAO subscriberDAO;
    @Autowired
    private ChennelDAO chennelDAO;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model) {
        List<Subscriber> subscribers = subscriberDAO.getAll();
        model.addAttribute("subscribers_list", subscribers);
        model.addAttribute("subscriber", new Subscriber());
        
        List<Chennel> chennels = chennelDAO.getAll();
        model.addAttribute("chennels_list", chennels);
        model.addAttribute("chennel", new Chennel());
        
        return "index";
    }


    @RequestMapping(value = "subscriber/add", method = RequestMethod.POST)
    public String addSubscriber(Model model, Subscriber subscriber) {

        return "redirect:";
    }


    @RequestMapping(value = "chennel/add", method = RequestMethod.POST)
    public String addChennel(Model model, Chennel chennel) {

        return "redirect:";
    }


    @RequestMapping(value = "subscriber/update", method = RequestMethod.POST)
    public String updateSubscriber(Model model, Subscriber subscriber) {

        return "list_page";
    }


    @RequestMapping(value = "chennel/update", method = RequestMethod.POST)
    public String updateChennel(Model model, Chennel chennel) {

        return "list_page";
    }


    @RequestMapping(value = "subscriber/delete", method = RequestMethod.POST)
    public String deleteSubscriber(Model model) {

        return "redirect:";
    }


    @RequestMapping(value = "chennel/delete", method = RequestMethod.POST)
    public String deleteChennel(Model model) {

        return "redirect:";
    }
}
