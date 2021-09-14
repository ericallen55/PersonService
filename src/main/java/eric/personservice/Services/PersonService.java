package eric.personservice.Services;

import eric.personservice.Daos.PersonDao;
import eric.personservice.Models.PersonRequest;
import eric.personservice.Models.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {
    @Autowired
    PersonDao personDao;

    public PersonResponse getPersonById(Integer id){
        return personDao.getPersonById(id);
    }
    public List<PersonResponse> getPeople() { return  personDao.getPeople(); }
    public List<PersonResponse> queryPeople(String type, String value){ return personDao.queryPeople(type, value);}
    public Boolean addPerson(PersonRequest personRequest){
        return personDao.addPerson(personRequest);
    }
    public Boolean deletePerson(Integer id){ return personDao.deletePerson(id); }
    public Boolean updatePerson(Integer id, PersonRequest personRequest){
        return personDao.updatePerson(id, personRequest);
    }
}
