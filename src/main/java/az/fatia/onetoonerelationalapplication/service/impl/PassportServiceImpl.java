package az.fatia.onetoonerelationalapplication.service.impl;

import az.fatia.onetoonerelationalapplication.dto.PassportDto;
import az.fatia.onetoonerelationalapplication.entity.Passport;
import az.fatia.onetoonerelationalapplication.entity.Person;
import az.fatia.onetoonerelationalapplication.repository.PassportRepository;
import az.fatia.onetoonerelationalapplication.repository.PersonRepository;
import az.fatia.onetoonerelationalapplication.service.PassportService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<String> createPassport(PassportDto newPassportDto) {
        Person person = personRepository.findById(newPassportDto.getPersonId()).orElseThrow(() ->
                new EntityNotFoundException("Person with id " + newPassportDto.getPersonId() + " not found"));

        Passport passport = modelMapper.map(newPassportDto, Passport.class);
        passport.setId(null);
        passport.setPerson(person);
        Passport savedPassport = passportRepository.save(passport);
        return ResponseEntity.ok("Passport has been saved with id " + savedPassport.getId());
    }

    @Override
    public PassportDto getPassport(Long id) {
        Passport passport = get(id);
        return modelMapper.map(passport, PassportDto.class);
    }

    @Override
    public List<PassportDto> getAllPassports() {
        return passportRepository.findAll().stream().map(p ->
                modelMapper.map(p, PassportDto.class)).toList();
    }

    @Override
    public ResponseEntity<String> updatePassport(Long id, Passport newPassport) {
        Passport passport = get(id);
        passport.setPin(newPassport.getPin());
        Passport saved = passportRepository.save(passport);

        return ResponseEntity.ok("Passport has been updated with id " + saved.getId());
    }

    @Override
    public ResponseEntity<String> deletePassport(Long id) {
        Passport passport = get(id);
        if (passport.getPerson() != null) {
            passport.getPerson().setPassport(null);
            passport.setPerson(null);
        }

        passportRepository.delete(passport);
        return ResponseEntity.ok("Passport has been deleted with id " + id);
    }

    private Passport get(Long id) {
        Passport p = passportRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Passport with id " + id + " not found"));
        return p;
    }
}
