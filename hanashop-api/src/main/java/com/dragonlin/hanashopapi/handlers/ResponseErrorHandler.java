package com.dragonlin.hanashopapi.handlers;
import com.dragonlin.hanashopapi.dtos.response.ResponseWrapperDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;
@RestControllerAdvice
public class ResponseErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final List<FieldError> fieldErrors=ex.getBindingResult().getFieldErrors();
        ResponseWrapperDTO responseWrapperDTO= new ResponseWrapperDTO();
        responseWrapperDTO.setStatus(false);
        responseWrapperDTO.setMessage(fieldErrors.get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(responseWrapperDTO);
    }
}
