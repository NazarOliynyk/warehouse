package ua.com.owu.warehouse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.warehouse.dao.CommodityDAO;
import ua.com.owu.warehouse.models.Commodity;

@Controller
public class MainController {

    @Autowired
    CommodityDAO commodityDAO;
    @GetMapping("/")
    public String callPage(Model model){
        model.addAttribute("commodities", commodityDAO.findAll());
        System.out.println("@GetMapping()");
        return "index";
    }
    // pressing submit saves a new commodity
    @PostMapping("/saveUser")
    public String save(
            @RequestParam("name") String name, Model model,
            @RequestParam("description") String description,
            @RequestParam("price") double price
    ){
        Commodity commodity = new Commodity();
        commodity.setName(name);
        commodity.setDescription(description);
        commodity.setPrice(price);
        commodityDAO.save(commodity);
        model.addAttribute("name", name);
        model.addAttribute("description", description);
        model.addAttribute("price", price);
        return "result";
    }

}
