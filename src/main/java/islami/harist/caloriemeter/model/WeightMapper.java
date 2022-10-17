package islami.harist.caloriemeter.model;

import islami.harist.caloriemeter.model.base.BaseDomain;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WeightMapper extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 8534353749839746223L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(length = 50, name = "unit_weight")
    private String unitWeight;

    @Column(name = "amount_convert")
    private Integer amountConvert;
}