package eric.personservice;

import eric.personservice.Models.PersonRequest;
import eric.personservice.Services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PersonServiceApplicationTests {
    @Autowired
            PersonService personService;

    @Test
    void addPerson(){
        assertThat (personService.addPerson(PersonRequest.builder()
                .firstName("Eric")
                .lastName("Allen")
                .build())).isTrue();
    }

    @Test
    void deletePersonFails(){
        assertThat(personService.deletePerson(999)).isFalse();
    }

    @Test
    void updateNonExsistentPerson(){
        assertThat(personService.updatePerson(999, PersonRequest.builder()
                .firstName("bob")
                .lastName("bob")
                .build())).isFalse();
    }

}
