package petclinic.springframework.petclinic.services;

import petclinic.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastNAme(String lastName);
}
