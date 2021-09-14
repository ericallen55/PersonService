package eric.personservice.Controllers;

import eric.personservice.Models.PersonRequest;
import eric.personservice.Models.PersonResponse;
import eric.personservice.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity addPerson(@RequestBody PersonRequest person) {
        if(personService.addPerson(person)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("deletePerson/{id}")
    ResponseEntity deletePerson(@PathVariable("id") Integer id){
        if(personService.deletePerson(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping(path = "updatePerson/{id}")
    ResponseEntity updatePerson(@PathVariable("id") Integer id, @RequestBody PersonRequest personRequest){
        if(personService.updatePerson(id, personRequest)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
