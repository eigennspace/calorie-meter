package islami.harist.caloriemeter.model;

import islami.harist.caloriemeter.model.base.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Food extends BaseDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "amount")
    private Integer amount;

    @Column(length = 50, nullable = false, name = "unit_weight")
    private String unitWeight;
}