package com.dragonlin.hanashopapi.handlers;

import com.dragonlin.hanashopapi.dtos.response.ResponseWrapperDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashMap;
import java.util.TreeMap;

@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof ResponseWrapperDTO) return body;
        if(body instanceof String && ((String)body).contains("openapi")) return body;
        if(body instanceof TreeMap) return body;
        if(body instanceof LinkedHashMap) return body;
        ResponseWrapperDTO responseDTO= new ResponseWrapperDTO();
        responseDTO.setData(body);
        responseDTO.setStatus(true);
        responseDTO.setMessage(null);
        return responseDTO;
    }
}
