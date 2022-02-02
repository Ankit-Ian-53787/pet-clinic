package petclinic.springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import petclinic.springframework.petclinic.model.Owner;
import petclinic.springframework.petclinic.model.Vet;
import petclinic.springframework.petclinic.services.OwnerService;
import petclinic.springframework.petclinic.services.VetServices;

@Component
public class DataLoader implements CommandLineRunner {
private  final OwnerService ownerService;
private final VetServices vetServices;

    public DataLoader(OwnerService ownerService, VetServices vetServices) {
        this.ownerService = ownerService;
        this.vetServices = vetServices;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Miachel");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenae");

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
