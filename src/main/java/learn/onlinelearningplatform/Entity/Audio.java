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
@Builder
@DiscriminatorValue("AUDIO")
public class Audio extends Resource{

    private String audioFormat;
}
