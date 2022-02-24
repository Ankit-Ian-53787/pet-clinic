package petclinic.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import petclinic.springframework.petclinic.model.Owner;
import petclinic.springframework.petclinic.services.OwnerService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    public static final String VIEWS_OWNERS_CREATE_OR_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }



    @RequestMapping("/find")
        public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
        }

        @GetMapping
        public String processFindForm(Owner owner, BindingResult result,Model model){

        if(owner.getLastName()==null){
            owner.setLastName("");
        }

        //find owners by lastName
            List<Owner> results = this.ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
        if(results.isEmpty()){
            //no owners found
            result.rejectValue("lastName","notFound","notFound");
            return "owners/findOwners";
        }else if (results.size()==1){
            // 1 owner found
            owner = results.iterator().next();
            return "redirect:/owners/"+ owner.getId();
        }else {
            //multiple owners found
            model.addAttribute("selections",results);
            return "owners/ownersList";
        }
        }

        @GetMapping("/{ownerId}")
        public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){

        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
                return  mav;
        }

        @GetMapping("/new")
        public String initCreationForm(Model model){
        Owner owner = new Owner();
        model.addAttribute("owner",owner);
        return VIEWS_OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
        }

       @PostMapping("/new")
        public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
        }else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
        }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId,Model model){
        Owner owner =ownerService.findById(ownerId);
        model.addAttribute(owner);
        return VIEWS_OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,@PathVariable("ownerId")  Long ownerId){
        if(result.hasErrors()){
            return VIEWS_OWNERS_CREATE_OR_UPDATE_OWNER_FORM;
        }else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

}
