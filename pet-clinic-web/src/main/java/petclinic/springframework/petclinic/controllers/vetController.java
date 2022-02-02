package petclinic.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import petclinic.springframework.petclinic.services.VetServices;

@Controller
@RequestMapping("/vets")
public class vetController {

    private final VetServices vetServices;

    public vetController(VetServices vetServices) {
        this.vetServices = vetServices;
    }


    @RequestMapping({"","/","/index","/index.html"})
public String listVets(Model model){
      model.addAttribute("vets",vetServices.findAll());
        return "vets/index";
}
}
