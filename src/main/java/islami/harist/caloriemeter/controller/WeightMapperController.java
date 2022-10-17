package islami.harist.caloriemeter.controller;

import islami.harist.caloriemeter.dto.weightmapper.CreateNewConverterRequestDto;
import islami.harist.caloriemeter.dto.weightmapper.CreateNewConverterResponseDto;
import islami.harist.caloriemeter.service.WeightMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/weight-mapper")
public class WeightMapperController {

    @Autowired
    private WeightMapperService weightMapperService;

    @PostMapping("/create")
    public ResponseEntity<CreateNewConverterResponseDto> createNewConverter(@Valid @RequestBody CreateNewConverterRequestDto param){
        return weightMapperService.createNewConverter(param);
    }
}