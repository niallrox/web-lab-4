package controller.mapper;

import controller.dto.PointDto;
import entity.Point;

public class PointMapper {

    public Point fromDto(PointDto point){
        return Point.builder()
                .x(point.getX())
                .y(point.getY())
                .r(point.getR())
                .build();
    }
}
