package eric.personservice.Services;

import eric.personservice.Daos.PersonDao;
import eric.personservice.Models.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    @Autowired
    PersonDao personDao;

    public PersonResponse getPersonById(Integer id){
        return personDao.getPersonById(id);
    }
}
