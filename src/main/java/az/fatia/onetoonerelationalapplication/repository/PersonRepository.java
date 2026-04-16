package az.fatia.onetoonerelationalapplication.repository;

import az.fatia.onetoonerelationalapplication.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
