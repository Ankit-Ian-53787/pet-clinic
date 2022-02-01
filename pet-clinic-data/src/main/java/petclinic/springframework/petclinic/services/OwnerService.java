package petclinic.springframework.petclinic.services;

import petclinic.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastNAme(String lastName);
}
