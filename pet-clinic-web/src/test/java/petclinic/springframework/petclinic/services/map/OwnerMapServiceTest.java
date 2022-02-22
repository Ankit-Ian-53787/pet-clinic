package petclinic.springframework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petclinic.springframework.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;



    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
       ownerMapService = new OwnerMapService(new PetTypeMapService(),new PetMapService());

       Owner owner = new Owner();
       owner.setId(ownerId);
       owner.setLastName(lastName);
       ownerMapService.save(owner);

      // ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> owner = ownerMapService.findAll();

        assertEquals(1,owner.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(null,ownerMapService.findById(ownerId));
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
       // Owner owner2 = Owner.builder().id(id).build();
       Owner owner2 = new Owner();
       owner2.setId(id);
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();
        Owner savedOwner = ownerMapService.save(owner);
        //Owner savedOwner = ownerMapService.save(Owner.builder().build());
    assertNotNull(savedOwner);
    assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastNAme() {
        Owner owner = ownerMapService.findByLastNAme(lastName);
        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastNAme("foo");
        assertNull(owner);
    }
}