package learn.onlinelearningplatform.Entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VIDEO")
@Builder
public class Video extends Resource{

    private int seconds;
    private String resolution;

}
