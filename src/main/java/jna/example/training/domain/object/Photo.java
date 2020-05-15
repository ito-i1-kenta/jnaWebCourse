package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class Photo {

    private String photo;

    private Photo(String value) {
        this.photo = value;
    }

    public static Photo of(String value) {
        return Optional.ofNullable(value).map(Photo::new).orElse(null);
    }

}
