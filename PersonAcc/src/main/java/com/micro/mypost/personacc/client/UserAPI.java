package com.micro.mypost.personacc.client;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "UserClient", url = "${integration.user-gate}")
public interface UserAPI {

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{nickname}")
    ResponseEntity<UserDTO> getUser(@PathVariable("nickname") String nickname);


    @Data
    @Accessors(chain = true)
    class UserDTO {
        private String nickname;
        private String email;
    }
}
