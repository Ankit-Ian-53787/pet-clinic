package petclinic.springframework.petclinic.services;

import petclinic.springframework.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastNAme(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
