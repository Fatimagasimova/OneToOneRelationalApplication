package az.fatia.onetoonerelationalapplication.service;

import az.fatia.onetoonerelationalapplication.dto.PersonDto;
import az.fatia.onetoonerelationalapplication.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    public ResponseEntity<String> createPerson(Person newPerson);

    public PersonDto getPerson(Long id);

    public List<PersonDto> getAllPersons();

    public ResponseEntity<String> updatePerson(Long id, Person newPerson);

    public ResponseEntity<String> deletePerson(Long id);


}
