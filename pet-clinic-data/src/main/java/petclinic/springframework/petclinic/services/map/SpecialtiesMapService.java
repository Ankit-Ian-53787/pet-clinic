package petclinic.springframework.petclinic.services.map;

import org.springframework.stereotype.Service;
import petclinic.springframework.petclinic.model.Specialty;
import petclinic.springframework.petclinic.services.SpecialtiesService;

import java.util.Set;

@Service
public class SpecialtiesMapService extends AbstractMapService<Specialty,Long> implements SpecialtiesService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
   super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
    super.delete(object);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }
}
