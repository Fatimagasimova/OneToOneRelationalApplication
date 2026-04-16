package az.fatia.onetoonerelationalapplication.controller;

import az.fatia.onetoonerelationalapplication.dto.PersonDto;
import az.fatia.onetoonerelationalapplication.entity.Person;
import az.fatia.onetoonerelationalapplication.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person newPerson) {
        personService.createPerson(newPerson);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        personService.updatePerson(id, newPerson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}