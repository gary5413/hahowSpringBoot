package com.example.hahowspringboot.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectMapperController {
    @GetMapping("/convert")
    public String convert() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
//      測試 不設定name 會出現null 去 User 新增註解
        user.setName("Gary");
        ObjectMapper objectMapper = new ObjectMapper();
//        User > json字串
        String jsonResult = objectMapper.writeValueAsString(user);
        System.out.println("json的值為" + jsonResult);
//        json字串 > User
        String json = "{\"id\":3,\"name\":\"ALuMi\",\"contact_email\":\"garylee@ispan.com.tw\"}";
        User userResult=objectMapper.readValue(json,User.class);
        System.out.println("User的id值為:"+userResult.getId());
        System.out.println("User的name值為:"+userResult.getName());
        System.out.println("User的email為:"+userResult.getEmail());
        return "conver success";
    }
}
