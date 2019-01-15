package cn.wqy.eureka.consumer.controller;

import cn.wqy.eureka.consumer.service.UserConsumerService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * Created by wqy on 2019/01/08
 */
@Controller
@RequestMapping("/user")
@Api(value = "eureka-consumer-user", description = "用户注册接口")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserConsumerService userService;


    @ResponseBody
    @GetMapping("/consumer/add")
    public String list(
            @ApiParam(value = "昵称") @RequestParam(value = "userName",required = false) String userName,
            @ApiParam(value = "账号") @RequestParam(value = "loginId",required = false) String loginId,
            @ApiParam(value = "密码") @RequestParam(value = "pwd",required = false) String pwd,
            @ApiParam(value = "个性签名") @RequestParam(value = "signature",required = false) String signature,
            //PlanUser planUser,
            ModelMap modelMap) {
        String json = null;
        try {

            //PlanUser planUser=new PlanUser();
            //todo
            //planUser.se
            int rs=userService.addUser(userName,loginId,pwd,signature);
            if(rs>0){
                modelMap.put("ren_code", "0");
                modelMap.put("ren_msg", "添加成功");
                modelMap.put("username:", userName);
                json = JSON.toJSONString(modelMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("ren_code", "0");
            modelMap.put("ren_msg", "添加失败===>" + e);
            LOGGER.error("添加失败===>" + e);
            json = JSON.toJSONString(modelMap);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return userService.hello(name);
    }

    @RequestMapping("/register")
    public String register(){
        return "/addUser";
    }
}
