package az.fatia.onetoonerelationalapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PassportDto {

    private String pin;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long personId;
}
