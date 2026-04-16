package az.fatia.onetoonerelationalapplication.dto;

import lombok.Data;

@Data
public class PersonDto {
    private String name;
    private String country;
    private PassportDto passport;
}
