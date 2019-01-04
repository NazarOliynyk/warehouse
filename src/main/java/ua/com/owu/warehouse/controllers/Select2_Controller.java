package ua.com.owu.warehouse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.com.owu.warehouse.dao.CommodityDAO;
import ua.com.owu.warehouse.models.Commodity;

import java.util.ArrayList;
import java.util.List;

@Controller

public class Select2_Controller {
    @Autowired
    CommodityDAO commodityDAO;

    @GetMapping("/select2")
    public String callPage(Model model){
        List<Commodity> allItems = commodityDAO.findAll();
        List<Commodity> below3 = new ArrayList<>();
        for (Commodity allItem : allItems) {
            if(allItem.getPrice()>5){
                below3.add(allItem);
            }
        }
        model.addAttribute("commodities", below3);

        return "select2";
    }
}
