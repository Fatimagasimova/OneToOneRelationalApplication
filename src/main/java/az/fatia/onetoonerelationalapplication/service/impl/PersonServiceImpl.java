package az.fatia.onetoonerelationalapplication.service.impl;

import az.fatia.onetoonerelationalapplication.dto.PersonDto;
import az.fatia.onetoonerelationalapplication.entity.Person;
import az.fatia.onetoonerelationalapplication.enums.Status;
import az.fatia.onetoonerelationalapplication.repository.PersonRepository;
import az.fatia.onetoonerelationalapplication.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> createPerson(Person newPerson) {
        Person person = modelMapper.map(newPerson, Person.class);
        person.setStatus(Status.ACTIVE);
        Person saved = personRepository.save(person);
        return ResponseEntity.ok("Person created with id: " + saved.getId());
    }

    @Override
    public PersonDto getPerson(Long id) {
        return modelMapper.map(get(id), PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(person ->
                modelMapper.map(person, PersonDto.class)).toList();
    }

    @Override
    public ResponseEntity<String> updatePerson(Long id, Person newPerson) {
        Person person = get(id);

        person.setName(newPerson.getName());
        person.setCountry(newPerson.getCountry());
        person.setEmail(newPerson.getEmail());
        person.setStatus(Status.ACTIVE);

        Person saved = personRepository.save(person);
        return ResponseEntity.ok("Person updated with id: " + saved.getId());
    }

    @Override
    public ResponseEntity<String> deletePerson(Long id) {
        Person person = get(id);
        person.setStatus(Status.INACTIVE);
        personRepository.save(person);
        return ResponseEntity.ok("Person deleted with id: " + person.getId());
    }

    private Person get(Long id) {
        Person p = personRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Person with id " + id + " not found"));
        return p;
    }
}
