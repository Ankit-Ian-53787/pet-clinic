package petclinic.springframework.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import petclinic.springframework.petclinic.model.Owner;
import petclinic.springframework.petclinic.model.Pet;
import petclinic.springframework.petclinic.services.OwnerService;
import petclinic.springframework.petclinic.services.PetServices;
import petclinic.springframework.petclinic.services.PetTypeService;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetServices petService;

    public OwnerMapService(PetTypeService petTypeService, PetServices petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object.getPets()!=null){
            object.getPets().forEach(pet -> {
                if(pet.getPetType()!=null){
                  if(pet.getPetType().getId()==null){
                      pet.setPetType(petTypeService.save(pet.getPetType()));
                  }
                }else
                    throw new RuntimeException("Pet type is required");
                if(pet.getId()==null){
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
            return super.save(object);
        }else
            return  null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastNAme(String lastName) {

        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }
}
