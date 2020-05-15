package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.PrefecturesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrefecturesMapper {

    List<PrefecturesEntity> getPrefecturesList();

}
