package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
