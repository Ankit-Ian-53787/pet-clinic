package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
