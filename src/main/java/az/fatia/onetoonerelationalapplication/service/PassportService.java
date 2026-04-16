package az.fatia.onetoonerelationalapplication.service;

import az.fatia.onetoonerelationalapplication.dto.PassportDto;
import az.fatia.onetoonerelationalapplication.dto.PersonDto;
import az.fatia.onetoonerelationalapplication.entity.Passport;
import az.fatia.onetoonerelationalapplication.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PassportService {

    public ResponseEntity<String> createPassport(PassportDto newPassportDto);

    public PassportDto getPassport(Long id);

    public List<PassportDto> getAllPassports();

    public ResponseEntity<String> updatePassport(Long id, Passport newPassport);

    public ResponseEntity<String> deletePassport(Long id);


}
