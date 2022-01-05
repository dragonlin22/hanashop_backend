package com.dragonlin.hanashopapi.handlers;

import com.dragonlin.hanashopapi.dtos.response.ResponseWrapperDTO;
import com.google.gson.Gson;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;

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
        String requestPath=((ServletServerHttpRequest) request).getServletRequest().getRequestURL().toString();
        if(body instanceof ResponseWrapperDTO) return body;
        if(!requestPath.contains("/v1")){
            return body;
        }
        if(requestPath.contains("/swagger-resources")){
            return body;
        }
        if (body instanceof UiConfiguration) return body;
        if (body instanceof SecurityConfiguration) return body;
        if (body instanceof String){
            if(((String) body).contains("swagger-resources"))return body;
            try{
                new Gson().fromJson((String)body,ResponseWrapperDTO.class);
                return body;
            }catch (Exception e){ }
        }
        if(body instanceof TreeMap) return body;
        if(body instanceof LinkedHashMap) return body;
        ResponseWrapperDTO responseDTO= new ResponseWrapperDTO();
        responseDTO.setData(body);
        responseDTO.setStatus(true);
        responseDTO.setMessage(null);
        return responseDTO;
    }
}
