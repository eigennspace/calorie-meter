package islami.harist.caloriemeter.service;

import islami.harist.caloriemeter.constant.CalorieMeterConstant;
import islami.harist.caloriemeter.dto.weightmapper.CreateNewConverterRequestDto;
import islami.harist.caloriemeter.dto.weightmapper.CreateNewConverterResponseDto;
import islami.harist.caloriemeter.model.WeightMapper;
import islami.harist.caloriemeter.model.base.BaseResponse;
import islami.harist.caloriemeter.repository.WeightMapperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class WeightMapperService {

    @Autowired
    private WeightMapperRepository weightMapperRepository;

    public ResponseEntity<CreateNewConverterResponseDto> createNewConverter(CreateNewConverterRequestDto param){
       var weightMapper = new WeightMapper();

       weightMapper.setAmount(param.getAmount());
       weightMapper.setUnitWeight(param.getUnitWeight());
       weightMapper.setAmountConvert(param.getAmountConvert());
       weightMapper.setCreatedBy(CalorieMeterConstant.CREATED_BY_SYSTEM);
       weightMapper.setCreatedDate(new Date());
       weightMapper.setIsDeleted(Boolean.FALSE);
       weightMapperRepository.save(weightMapper);

       CreateNewConverterResponseDto createNewConverterResponseDto = CreateNewConverterResponseDto.builder()
                .id(weightMapper.getId())
                .fromWeight(weightMapper.getAmount() + " " + weightMapper.getUnitWeight())
                .finalWeight(weightMapper.getAmountConvert() + CalorieMeterConstant.DEFAULT_UNIT_WEIGHT)
                .build();

       BaseResponse<CreateNewConverterResponseDto> x = new BaseResponse<>();
       return x.generateResponse(createNewConverterResponseDto, CalorieMeterConstant.SUCCESS_CREATED, HttpStatus.CREATED);
    }
}