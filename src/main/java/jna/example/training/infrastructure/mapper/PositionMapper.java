package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.PositionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    List<PositionEntity> getPositionList();
}
