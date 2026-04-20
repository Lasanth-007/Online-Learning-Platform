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
@DiscriminatorValue("PDF")
@SuperBuilder
public class Pdf extends Resource{
    private String type;
}
