package az.fatia.onetoonerelationalapplication.repository;

import az.fatia.onetoonerelationalapplication.entity.Passport;
import az.fatia.onetoonerelationalapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
