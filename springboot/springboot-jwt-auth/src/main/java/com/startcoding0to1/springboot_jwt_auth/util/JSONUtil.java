package com.startcoding0to1.springboot_jwt_auth.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JSONUtil {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public Map<String, Object>  fromJson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Map.class);
    }

}
