package petclinic.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinic.springframework.petclinic.model.Owner;
import petclinic.springframework.petclinic.model.Pet;
import petclinic.springframework.petclinic.model.PetType;
import petclinic.springframework.petclinic.model.Vet;
import petclinic.springframework.petclinic.services.OwnerService;
import petclinic.springframework.petclinic.services.PetTypeService;
import petclinic.springframework.petclinic.services.VetServices;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
private  final OwnerService ownerService;
private final VetServices vetServices;
private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetServices vetServices, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetServices = vetServices;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

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

        vetServices.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetServices.save(vet2);

        System.out.println("Loaded Vets");
    }
}
