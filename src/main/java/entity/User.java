package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    private String login;
    private String password;
}
