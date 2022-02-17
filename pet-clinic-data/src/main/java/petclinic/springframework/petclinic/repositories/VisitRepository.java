package petclinic.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import petclinic.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
