package petclinic.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import petclinic.springframework.petclinic.model.Vet;
import petclinic.springframework.petclinic.services.VetServices;

import java.util.Set;

@Controller
public class VetController {

    private final VetServices vetServices;

    public VetController(VetServices vetServices) {
        this.vetServices = vetServices;
    }


    @RequestMapping({"/vets.html","/vets","/vets/index","/vets/index.html"})
public String listVets(Model model){
      model.addAttribute("vets",vetServices.findAll());
        return "vets/index";
}

@GetMapping("/api/vets")
public @ResponseBody Set<Vet> getVetsJson(){

        return vetServices.findAll();
}
}
