package com.micro.mypost.personacc.client;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        return switch (response.status()) {
            case 400 -> new RuntimeException("Bad Request");
            case 404 -> new RuntimeException("Not Found");
            default -> new Exception("Uncrowned Error");
        };
    }

}
