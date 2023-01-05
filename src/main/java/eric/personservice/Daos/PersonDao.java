package eric.personservice.Daos;

import eric.personservice.Models.PersonRequest;
import eric.personservice.Models.PersonResponse;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class PersonDao {
    Map<Integer, PersonResponse> personResponses = new HashMap<>();
    private Integer primaryKey = 0;

    public PersonResponse getPersonById(Integer id) {
        return personResponses.get(id);
    }

    public List<PersonResponse> getPeople() {
        return new ArrayList<>(personResponses.values());
    }

    public List<PersonResponse> queryPeople(String type, String value) {
                    switch (type) {
                case "firstname":
                    return personResponses.entrySet()
                            .stream().filter(response -> response.getValue().getFirstName().equals(value))
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toList());
                case "lastname":
                    break;
                default:
                    return null;
            }
        return null;
    }

    public Boolean addPerson(PersonRequest personRequest) {
        personResponses.put(primaryKey,
                PersonResponse.builder()
                        .id(primaryKey)
                        .firstName(personRequest.getFirstName())
                        .lastName(personRequest.getLastName())
                        .build());
        primaryKey++;
        return true;
    }

    public Boolean deletePerson(Integer id) {
        if (personResponses.containsKey(id)) {
            personResponses.remove(id);
            return true;
        }
        return false;
    }

    public Boolean updatePerson(Integer id, PersonRequest personRequest) {
        if (personResponses.containsKey(id)) {
            personResponses.remove(id, PersonResponse.builder()
                    .firstName(personRequest.getFirstName())
                    .lastName(personRequest.getLastName())
                    .build());
            return true;
        }
        return false;
    }
}
//    public PersonResponse getPersonById(Integer id) {
//        try {
//            PreparedStatement preparedStatement = DBCPDataSource.getConnection().prepareStatement("SELECT * from Distributor WHERE DistributorId = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (!resultSet.next()) {
//                return null;
//            }
//            return PersonResponse.builder()
//                    .id(resultSet.getInt("DistributorId"))
//                    .firstName(resultSet.getString("FirstName"))
//                    .lastName(resultSet.getString("LastName"))
//                    .build();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<PersonResponse> getPeople() {
//        List<PersonResponse> peopleResponse = new ArrayList();
//        try {
//            ResultSet resultSet = DBCPDataSource.getConnection().createStatement().executeQuery("select * from Distributor");
//            while (resultSet.next()) {
//                peopleResponse.add(PersonResponse.builder()
//                        .id(resultSet.getInt("DistributorId"))
//                        .firstName(resultSet.getString("FirstName"))
//                        .lastName(resultSet.getString("LastName"))
//                        .build());
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return peopleResponse;
//    }
//
//    public List<PersonResponse> queryPeople(String type, String value) {
//        try {
//            PreparedStatement preparedStatement;
//            switch (type) {
//                case "FirstName":
//                    preparedStatement = DBCPDataSource.getConnection().prepareStatement("SELECT * from Distributor WHERE FirstName = ?");
//                    break;
//                case "LastName":
//                    preparedStatement = DBCPDataSource.getConnection().prepareStatement("SELECT * from Distributor WHERE LastName = ?");
//                    break;
//                default:
//                    return null;
//            }
//            preparedStatement.setString(1, value);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<PersonResponse> people = new ArrayList<>();
//            while (resultSet.next()) {
//                people.add(PersonResponse.builder()
//                        .id(resultSet.getInt("DistributorId"))
//                        .firstName(resultSet.getString("FirstName"))
//                        .lastName(resultSet.getString("LastName"))
//                        .build());
//            }
//            return people;
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }
//
//    public Boolean addPerson(PersonRequest personRequest) {
//        try {
//            PreparedStatement preparedStatement = DBCPDataSource.getConnection()
//                    .prepareStatement("INSERT INTO Distributor (FirstName,LastName) VALUES (?,?)");
//
//            preparedStatement.setString(1, personRequest.getFirstName());
//            preparedStatement.setString(2, personRequest.getLastName());
//
//            preparedStatement.executeUpdate();
//            return true;
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }
//
//    public Boolean deletePerson(Integer id) {
//        try {
//            PreparedStatement preparedStatement = DBCPDataSource.getConnection()
//                    .prepareStatement("DELETE FROM Distributor WHERE DistributorId = ?");
//            preparedStatement.setInt(1, id);
//            int success = preparedStatement.executeUpdate();
//            if (success > 0)
//                return true;
//            else
//                return false;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }
//
//    public Boolean updatePerson(Integer id, PersonRequest personRequest) {
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = DBCPDataSource.getConnection()
//                    .prepareStatement("UPDATE Distributor SET FirstName = ?, LastName = ? WHERE DistributorId=?");
//            preparedStatement.setString(1, personRequest.getFirstName());
//            preparedStatement.setString(2, personRequest.getLastName());
//            preparedStatement.setInt(3, id);
//            int success = preparedStatement.executeUpdate();
//            if (success > 0)
//                return true;
//            else
//                return false;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }
//}
