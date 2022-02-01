package petclinic.springframework.petclinic.services;



import petclinic.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetServices {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
