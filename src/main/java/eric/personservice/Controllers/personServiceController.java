package eric.personservice.Controllers;

import eric.personservice.Models.PersonResponse;
import eric.personservice.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personServiceController {
    @Autowired
    PersonService personService;

    @GetMapping("personById/{id}")
    PersonResponse getAllPeople(@PathVariable("id") Integer id){
        return personService.getPersonById(id);
    }


    //get query param
    //post
    //put
    //delete
}
