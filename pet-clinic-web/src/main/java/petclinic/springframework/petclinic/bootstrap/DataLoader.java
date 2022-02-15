package petclinic.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinic.springframework.petclinic.model.*;
import petclinic.springframework.petclinic.services.OwnerService;
import petclinic.springframework.petclinic.services.PetTypeService;
import petclinic.springframework.petclinic.services.SpecialtyService;
import petclinic.springframework.petclinic.services.VetServices;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
private  final OwnerService ownerService;
private final VetServices vetServices;
private final PetTypeService petTypeService;
private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetServices vetServices, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count==0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Miachel");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Berkley");
        owner1.setCity("Miami");
        owner1.setTelephone("123456");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenae");
        owner2.setAddress("345 Brooklyn");
        owner2.setCity("New Jersey");
        owner2.setTelephone("123654");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Mochiko");
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(savedSurgery);

        vetServices.save(vet2);

        System.out.println("Loaded Vets");
    }
}
