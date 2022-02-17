package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
