package learn.onlinelearningplatform.Entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(
        name = "resourse_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Resource extends BaseEntity {
    private String name;
    private Long size;
    private String url;
}

