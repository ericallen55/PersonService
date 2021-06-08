package eric.personservice.Daos;

import eric.personservice.Models.PersonResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDao {
    private List<PersonResponse> people = new ArrayList<>();

    public PersonDao(){
        people.add(0, PersonResponse.builder()
                .id(0)
                .firstName("Eric")
                .lastName("Allen")
                .age(45)
                .build());
    }




    public PersonResponse getPersonById(Integer id){
        return people.get(id);
    }
}
