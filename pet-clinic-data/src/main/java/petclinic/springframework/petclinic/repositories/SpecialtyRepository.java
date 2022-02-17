package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
