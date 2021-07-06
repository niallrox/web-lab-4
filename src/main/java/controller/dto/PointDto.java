package controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PointDto {
    private double x;
    private double y;
    private double r;
}
