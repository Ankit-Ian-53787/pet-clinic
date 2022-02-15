package petclinic.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import petclinic.springframework.petclinic.model.Specialty;
import petclinic.springframework.petclinic.model.Vet;
import petclinic.springframework.petclinic.services.SpecialtyService;
import petclinic.springframework.petclinic.services.VetServices;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetServices {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
   super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
    super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId()==null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
