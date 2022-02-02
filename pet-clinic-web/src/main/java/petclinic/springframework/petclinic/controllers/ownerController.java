package petclinic.springframework.petclinic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
public class ownerController {

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}
