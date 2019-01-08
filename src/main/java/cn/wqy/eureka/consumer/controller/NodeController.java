package cn.wqy.eureka.consumer.controller;

import cn.wqy.eureka.consumer.service.NodeConsumerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/node")//swagger2 只认  @RequestMapping 注解！ 不认@RestController  注解
@Api(value = "eureka-consumer-node", description = "计划节点crud接口")
public class NodeController {

    @Autowired
    private NodeConsumerService nodeService;

    /**
     * 新增节点
     */
    @PostMapping(value = "/add")
    public int addNode(@ApiParam(value = "节点名称") @RequestParam(value = "node_name",required = false) String nodeName,
                        @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
                        @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId){

        return nodeService.addNode(nodeName,habitId,parentId);
    }

    @PostMapping(value = "/update")
    public int updateNode(
            @ApiParam(value = "节点名称") @RequestParam(value = "node_name",required = false) String nodeName,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId,
            @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId){

        return nodeService.updateNode(nodeName,habitId,nodeId,parentId);
    }

    @GetMapping(value = "/delete")
    public int deleteNode(
            @ApiParam(value = "节点ID") @RequestParam(value = "nodeId",required = false) String nodeId){
        return nodeService.deleteNode(nodeId);
    }

    @RequestMapping(value = "/query")
    @ApiOperation(value = "node query")
    public List queryNode(
            @ApiParam(value = "节点名称") @RequestParam(value = "node_name",required = false) String nodeName,
            @ApiParam(value = "计划ID") @RequestParam(value = "habitId",required = false) String habitId,
            @ApiParam(value = "父节点ID") @RequestParam(value = "parentId",required = false) String parentId,
            Map<String,Object> params){

        return nodeService.queryNode(nodeName,habitId,parentId);
    }
}
