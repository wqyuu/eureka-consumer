package cn.wqy.eureka.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class HabitRemoteHystrix implements HabitConsumerService {





    @Override
    public int addHabit(String habitName, String habitDesc, String habitImportance, String habitTerm) {
        return 0;
    }

    @Override
    public int updateHabit(String habitName, String habitDesc, String habitImportance, String habitTerm, String habitId) {
        return 0;
    }

    @Override
    public int deleteHabit(String habitId) {
        return 0;
    }

    @Override
    public List queryHabit(String habitName, String habitDesc, String habitImportance, String habitTerm) {
        return null;
    }

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello~~~";
    }
}
