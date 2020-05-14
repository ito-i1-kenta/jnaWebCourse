package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class NickName {

    private String nickName;

    private NickName(String value) {
        this.nickName = value;
    }

    public static NickName of(String value) {
        return Optional.ofNullable(value).map(NickName::new).orElse(null);
    }

}
