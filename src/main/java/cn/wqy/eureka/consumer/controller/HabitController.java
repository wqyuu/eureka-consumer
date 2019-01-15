package cn.wqy.eureka.consumer.controller;

import cn.wqy.eureka.consumer.service.HabitConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habit")
@Api(value = "eureka-consumer-habit", description = "计划crud接口")
public class HabitController {

    @Autowired
    private HabitConsumerService habitService;

    /**
     * 新增计划
     * @param habitName
     * @return
     */
    @PostMapping(value = "/add")
    public int addHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm
            ){

        return habitService.addHabit(habitName,habitDesc,habitImportance,habitTerm);
    }

    @PostMapping(value = "/update")
    public int updateHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId){


        return habitService.updateHabit(habitName,habitDesc,habitImportance,habitTerm,habitId);
    }

    @GetMapping(value = "/delete")
    public int deleteHabit(
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId){

        return habitService.deleteHabit(habitId);
    }

    @GetMapping(value = "/query")
    public List queryHabit(
            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm){

        return habitService.queryHabit(habitName,habitDesc,habitImportance,habitTerm);
    }

    @GetMapping(value = "/habitHmoe")
    public String HabitHmoe(ModelMap map,
                            @ApiParam(value = "计划名称") @RequestParam(value = "habitName",required = false) String habitName,
                            @ApiParam(value = "描述") @RequestParam(value = "habitDesc",required = false) String habitDesc,
                            @ApiParam(value = "重要程度") @RequestParam(value = "habitImportance",required = false) String habitImportance,
                            @ApiParam(value = "期限") @RequestParam(value = "habitTerm",required = false) String habitTerm){

        List list= habitService.queryHabit(habitName,habitDesc,habitImportance,habitTerm);
        map.put("habitList",list);
        return "/planList";

    }

    @GetMapping(value = "/hmoe")
    public String Home(){
        return "/index";
    }
}
