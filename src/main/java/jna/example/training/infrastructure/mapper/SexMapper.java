package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.SexEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SexMapper {

    List<SexEntity> getSexList();

}
