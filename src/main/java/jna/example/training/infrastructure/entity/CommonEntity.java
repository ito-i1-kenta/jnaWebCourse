package jna.example.training.infrastructure.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommonEntity {
    protected LocalDateTime createAt;
    protected LocalDateTime updateAt;

    public void insertData() {
        updateData();
        this.createAt = this.updateAt;
    }

    public void updateData() {
        this.updateAt = LocalDateTime.now();
    }
}
