package cn.wqy.eureka.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务类
 * </p>

 * Created by wqy on 2019/01/08
 */
@FeignClient(value = "eureka-provider", fallback = UserRemoteHystrix.class)
public interface UserConsumerService {

    /**
     * 注册用户
     *
     * @return
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    int addUser( @RequestParam(value = "userName",required = false) String userName,
                           @RequestParam(value = "loginId",required = false) String loginId,
                           @RequestParam(value = "pwd",required = false) String pwd,
                           @RequestParam(value = "signature",required = false) String signature);

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
