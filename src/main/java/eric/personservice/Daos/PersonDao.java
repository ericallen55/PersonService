package eric.personservice.Daos;

import eric.personservice.Models.PersonRequest;
import eric.personservice.Models.PersonResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

        people.add(0, PersonResponse.builder()
                .id(1)
                .firstName("Holly")
                .lastName("Allen")
                .age(47)
                .build());

    }




    public PersonResponse getPersonById(Integer id){
        return people.get(id);
    }
    public List<PersonResponse> getPeople(){
        return people;
    }
    public List<PersonResponse> queryPeople(String type, String value){
        switch (type){
            case "firstName":
                return people.stream().filter(p -> p.getFirstName().equals(value)).collect(Collectors.toList());
            case "lastName":
                return people.stream().filter(p -> p.getLastName().equals(value)).collect(Collectors.toList());
            case "age":
                return people.stream().filter(p -> p.getAge().toString().equals(value)).collect(Collectors.toList());
        }
        return null;
    }

    public PersonResponse addPerson(PersonRequest personRequest){
        people.add(people.size(), PersonResponse.builder()
                .id(people.size())
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .age(personRequest.getAge())
                .build());

        return people.get(people.size() -1);
    }
}
