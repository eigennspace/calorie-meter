package islami.harist.caloriemeter.handler;

import islami.harist.caloriemeter.model.base.BaseDto;
import islami.harist.caloriemeter.model.base.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleResourceNotFoundExceptio(BaseException e){
        BaseDto baseDto = new BaseDto();

        baseDto.setErrorMessage(Collections.singletonList(e.getMessage()));
        baseDto.setPayload(null);

        return new ResponseEntity<>(baseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleArgumentTypeMismatc(MethodArgumentTypeMismatchException e){
        BaseDto baseDto = new BaseDto();

        baseDto.setErrorMessage(Collections.singletonList(e.getMessage()));
        baseDto.setPayload(null);

        return new ResponseEntity<>(baseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleArgumentNotValidExceptio(MethodArgumentNotValidException e){
        List<String> errors = e.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());

        BaseDto baseDto = new BaseDto();

        baseDto.setErrorMessage(errors);
        baseDto.setPayload(null);

        return new ResponseEntity<>(baseDto, HttpStatus.BAD_REQUEST);
    }
}