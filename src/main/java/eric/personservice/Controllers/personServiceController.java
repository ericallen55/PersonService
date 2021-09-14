package eric.personservice.Controllers;

import eric.personservice.Models.PersonRequest;
import eric.personservice.Models.PersonResponse;
import eric.personservice.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class personServiceController {
    @Autowired
    PersonService personService;

    @GetMapping("personById/{id}")
    PersonResponse getPersonById(@PathVariable("id") Integer id){
        return personService.getPersonById(id);
    }

    @GetMapping("people")
    List<PersonResponse> getPeople(){
        return personService.getPeople();
    }

    @GetMapping("queryPeople")
    List<PersonResponse> queryPeople(@RequestParam("type") String type, @RequestParam("value") String value){
        return personService.queryPeople(type, value);
    }

    @PostMapping(path = "addPerson", consumes = "application/json", produces = "application/json")
    PersonResponse addPerson(@RequestBody PersonRequest person) {
        return personService.addPerson(person);
    }

    @PutMapping(path = "updatePerson/{id}")
    PersonResponse updatePerson(@PathVariable("id") Integer id, @RequestBody PersonRequest personRequest){
        return personService.updatePerson(id, personRequest);
    }
    //delete
}
