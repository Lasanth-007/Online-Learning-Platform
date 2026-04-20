package learn.onlinelearningplatform.Entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VIDEO")
@SuperBuilder
public class Video extends Resource{

    private int seconds;
    private String resolution;

}
