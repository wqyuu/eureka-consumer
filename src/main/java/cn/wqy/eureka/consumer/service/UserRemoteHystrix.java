package cn.wqy.eureka.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserRemoteHystrix implements UserConsumerService {




    @Override
    public int addUser(String userName, String loginId, String pwd, String signature) {
        return 0;
    }

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello~~~";
    }
}
