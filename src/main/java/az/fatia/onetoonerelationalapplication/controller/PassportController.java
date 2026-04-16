package az.fatia.onetoonerelationalapplication.controller;

import az.fatia.onetoonerelationalapplication.dto.PassportDto;
import az.fatia.onetoonerelationalapplication.entity.Passport;
import az.fatia.onetoonerelationalapplication.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/passport")
public class PassportController {

    private final PassportService passportService;

    @PostMapping
    public ResponseEntity<String> createPassport(@RequestBody PassportDto passportDto) {
        passportService.createPassport(passportDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<PassportDto> getAllPassports() {
        return passportService.getAllPassports();
    }

    @GetMapping("/{id}")
    public PassportDto getPassportById(@PathVariable Long id) {
        return passportService.getPassport(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassport(@PathVariable Long id, @RequestBody Passport newPassport) {
        passportService.updatePassport(id, newPassport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassport(@PathVariable Long id) {
        passportService.deletePassport(id);
        return ResponseEntity.ok().build();
    }
}