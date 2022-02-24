package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
