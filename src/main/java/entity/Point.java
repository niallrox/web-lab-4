package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Point {
    @Id
    private Long id;
    private String userId;
    private Double x;
    private Double y;
    private Double r;
    private Boolean result;
}
