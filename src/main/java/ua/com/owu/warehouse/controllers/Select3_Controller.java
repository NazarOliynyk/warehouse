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

public class Select3_Controller {
    @Autowired
    CommodityDAO commodityDAO;

    @GetMapping("/select3")
    public String callPage(Model model){
        List<Commodity> allItems = commodityDAO.findAll();
        List<Commodity> last4 = new ArrayList<>();

        for (int i = 0; i < allItems.size(); i++) {
             if (i>=(allItems.size()-4)){
                 last4.add(allItems.get(i));
             }
        }

        model.addAttribute("commodities", last4);

        return "select3";
    }
}
