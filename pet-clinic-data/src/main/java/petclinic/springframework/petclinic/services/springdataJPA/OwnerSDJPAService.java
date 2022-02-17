package petclinic.springframework.petclinic.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import petclinic.springframework.petclinic.model.Owner;
import petclinic.springframework.petclinic.repositories.OwnerRepository;
import petclinic.springframework.petclinic.repositories.PetRepository;
import petclinic.springframework.petclinic.repositories.PetTypeRepository;
import petclinic.springframework.petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
       ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastNAme(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
