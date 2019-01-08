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
 *

 * Created by wqy on 2019/01/08
 */
@FeignClient(value = "eureka-provider", fallback = HelloRemoteHystrix.class)
public interface StudentConsumerService {

    /**
     * 查询所有的学生信息
     *
     * @param sname
     * @param age
     * @return
     */
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    String getStudentList(@RequestParam(value = "sname") String sname, @RequestParam(value = "age") Integer age);

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
