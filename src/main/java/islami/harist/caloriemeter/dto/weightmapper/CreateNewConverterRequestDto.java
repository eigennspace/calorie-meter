package islami.harist.caloriemeter.dto.weightmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewConverterRequestDto {

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("unit_weight")
    private String unitWeight;

    @JsonProperty("amount_convert")
    @NotBlank(message = "to loong")
    private Integer amountConvert;
}