package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
