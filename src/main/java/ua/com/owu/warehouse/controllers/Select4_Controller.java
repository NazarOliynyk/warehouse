package ua.com.owu.warehouse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.com.owu.warehouse.dao.CommodityDAO;
import ua.com.owu.warehouse.models.Commodity;

import java.util.*;


@Controller

public class Select4_Controller {
    @Autowired
    CommodityDAO commodityDAO;

    @GetMapping("/select4")
    public String callPage(Model model){
        List<Commodity> allItems = commodityDAO.findAll();

        Comparator<Commodity> nameComp = new CommodityNameComparator();
        Collections.sort(allItems, nameComp);
        model.addAttribute("commodities", allItems);

        return "select4";
    }
}

class CommodityNameComparator implements Comparator<Commodity>{
    @Override
    public int compare(Commodity a, Commodity b) {
        return a.getName().compareTo(b.getName());
    }
}
