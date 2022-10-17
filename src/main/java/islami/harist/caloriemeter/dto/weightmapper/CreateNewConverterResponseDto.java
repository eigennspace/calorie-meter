package islami.harist.caloriemeter.dto.weightmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewConverterResponseDto {

    @JsonProperty("key")
    private Long id;

    @JsonProperty("from_weight")
    private String fromWeight;

    @JsonProperty("final_weight")
    private String finalWeight;
}