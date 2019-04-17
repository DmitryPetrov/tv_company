
package com.example.name.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.name.dao.ChennelDAO;
import com.example.name.dao.FavoriteChennelDAO;
import com.example.name.dao.SubscriberDAO;
import com.example.name.model.Chennel;
import com.example.name.model.FavoriteChennel;
import com.example.name.model.Subscriber;

@Controller
public class MainController {

    @Autowired
    private SubscriberDAO subscriberDAO;
    @Autowired
    private ChennelDAO chennelDAO;
    @Autowired
    private FavoriteChennelDAO favoriteChennelDAO;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(Model model, @RequestParam(value = "subscriberId",
            required = false) String subscriberId) {
        FavoriteChennel favoriteChennel = new FavoriteChennel();
        if (subscriberId != null) {
            List<Chennel> favoriteChennelsForSubscriber =
                    chennelDAO.getFavoriteChannelForSubscriber(
                            Long.valueOf(subscriberId));
            model.addAttribute("favoriteChennelsForSubscriber",
                    favoriteChennelsForSubscriber);
            
            model.addAttribute("selectedSubscriberId",
                    Long.valueOf(subscriberId));
            
            favoriteChennel.setIdSubscriber(Long.valueOf(subscriberId));  
        }
        model.addAttribute("favoriteChennel", favoriteChennel);
        
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
        subscriberDAO.insert(subscriber);

        return "redirect:/";
    }


    @RequestMapping(value = "subscriber/update", method = RequestMethod.POST)
    public String updateSubscriber(Model model, Subscriber subscriber) {
        subscriberDAO.update(subscriber);

        return "redirect:/";
    }


    @RequestMapping(value = "subscriber/delete", method = RequestMethod.POST)
    public String deleteSubscriber(Model model, Subscriber subscriber) {
        subscriberDAO.delete(subscriber);

        return "redirect:/";
    }


    @RequestMapping(value = "favorite_chennel/add",
            method = RequestMethod.POST)
    public String addChennelToSubscriber(Model model,
            FavoriteChennel favoriteChennel) {
        System.out.println(favoriteChennel);
        favoriteChennelDAO.insert(favoriteChennel);
        
        return "redirect:/?subscriberId=" + favoriteChennel.getIdSubscriber();
    }


    @RequestMapping(value = "favorite_chennel/delete",
            method = RequestMethod.POST)
    public String deleteChennelToSubscriber(Model model,
            FavoriteChennel favoriteChennel) {
        favoriteChennelDAO.delete(favoriteChennel);

        return "redirect:/?subscriberId=" + favoriteChennel.getIdSubscriber();
    }


    @RequestMapping(value = "chennel/add", method = RequestMethod.POST)
    public String addChennel(Model model, Chennel chennel) {
        chennelDAO.insert(chennel);

        return "redirect:/";
    }


    @RequestMapping(value = "chennel/update", method = RequestMethod.POST)
    public String updateChennel(Model model, Chennel chennel) {
        chennelDAO.update(chennel);

        return "redirect:/";
    }


    @RequestMapping(value = "chennel/delete", method = RequestMethod.POST)
    public String deleteChennel(Model model, Chennel chennel) {
        chennelDAO.delete(chennel);

        return "redirect:/";
    }
}
