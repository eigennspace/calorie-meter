package islami.harist.caloriemeter.model.base;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

public class BaseResponse<C> {
    public ResponseEntity<C> generateResponse(C data, String errorStatus, HttpStatus httpStatus){

        BaseDto payload = new BaseDto();
        payload.setPayload(data);
        payload.setErrorMessage(Collections.singletonList(errorStatus));

        return new ResponseEntity<C>((C) payload, httpStatus);
    }

}