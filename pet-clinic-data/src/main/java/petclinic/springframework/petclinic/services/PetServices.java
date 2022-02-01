package petclinic.springframework.petclinic.services;



import petclinic.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetServices {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
