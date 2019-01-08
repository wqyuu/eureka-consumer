package cn.wqy.eureka.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>

 * Created by wqy on 2019/01/08
 */
@FeignClient(value = "eureka-provider", fallback = NodeRemoteHystrix.class)
//@Service
public interface NodeConsumerService {

    /**
     * 创建计划节点
     *
     * @return
     */
    @RequestMapping(value = "/node/add", method = RequestMethod.POST)
    int addNode(@RequestParam(value = "node_name",required = false) String nodeName,
                       @RequestParam(value = "habitId",required = false) String habitId,
                       @RequestParam(value = "parentId",required = false) String parentId);

    /**
     * 更新节点
     * @param nodeName
     * @param habitId
     * @param nodeId
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/node/update", method = RequestMethod.POST)
    int updateNode(
            @RequestParam(value = "node_name",required = false) String nodeName,
            @RequestParam(value = "habitId",required = false) String habitId,
            @RequestParam(value = "nodeId",required = false) String nodeId,
            @RequestParam(value = "parentId",required = false) String parentId);

    /**
     * 删除节点
     * @param nodeId
     * @return
     */
    @RequestMapping(value = "/node/delete", method = RequestMethod.GET)
    int deleteNode(@RequestParam(value = "nodeId",required = false) String nodeId);

    /**
     * 查询节点
     * @param nodeName
     * @param habitId
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/node/query", method = RequestMethod.GET)
    List queryNode(
            @RequestParam(value = "node_name",required = false) String nodeName,
            @RequestParam(value = "habitId",required = false) String habitId,
            @RequestParam(value = "parentId",required = false) String parentId);
}
