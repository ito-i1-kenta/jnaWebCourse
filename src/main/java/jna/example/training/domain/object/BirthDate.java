package jna.example.training.domain.object;

import lombok.Value;

import java.time.LocalDate;
import java.util.Optional;

@Value
public class BirthDate {

    private LocalDate birthDate;

    private BirthDate(String value) {
        this.birthDate = LocalDate.parse(value);
    }

    public static BirthDate of(String value) {
        return Optional.ofNullable(value).map(BirthDate::new).orElse(null);
    }

}
