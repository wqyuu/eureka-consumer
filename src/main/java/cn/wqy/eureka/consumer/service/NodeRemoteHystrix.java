package cn.wqy.eureka.consumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class NodeRemoteHystrix implements NodeConsumerService {


    @Override
    public int addNode(String nodeName, String habitId, String parentId) {
        return 0;
    }

    @Override
    public int updateNode(String nodeName, String habitId, String nodeId, String parentId) {
        return 0;
    }

    @Override
    public int deleteNode(String nodeId) {
        return 0;
    }

    @Override
    public List queryNode(String nodeName, String habitId, String parentId) {
        return null;
    }
}
