package com.wqh.neo4j.controller;

import com.wqh.neo4j.entity.*;
import com.wqh.neo4j.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName Neo4JController
 * @Author wqh
 * @Date 2021/1/7 16:01
 * @Description TODO
 * @Version 1.0
 */
@RestController
@Slf4j
public class Neo4JController {

    @Resource
    private NodeReporistory nodeReporistory;
    @Resource
    private RelationShipReporistory relationShipReporistory;

    @GetMapping(value = "/save")
    public void test3() {
        Node parentNode1 = Node.builder().name("1").build();
        Node childNode1 = Node.builder().name("1.1").build();
        Node childNode2 = Node.builder().name("1.2").build();
        Node childNode3 = Node.builder().name("1.1.1").build();
        List nodes = new ArrayList(Arrays.asList(parentNode1, childNode1, childNode2, childNode3));
        RelationShip relationShip1 = RelationShip.builder().parent(parentNode1).name("子节点").child(childNode1).build();
        RelationShip relationShip2 = RelationShip.builder().parent(parentNode1).name("子节点").child(childNode2).build();
        RelationShip relationShip3 = RelationShip.builder().parent(childNode1).name("子节点").child(childNode3).build();
        List relationShips = new ArrayList(Arrays.asList(relationShip1, relationShip2, relationShip3));
        nodeReporistory.saveAll(nodes);
        relationShipReporistory.saveAll(relationShips);
    }

    @GetMapping("selectAll")
    public Map selectAll() {
        Map<String, Object> resultMap = new HashMap<>();
//        Iterable<Node> nodesIterator = nodeReporistory.findAll();
//
//        List<Node> nodeList = Lists.newArrayList(nodesIterator);
//        resultMap.put("nodes", nodeList);
//
//        Iterator<Node> nodeIterator = nodesIterator.iterator();
//        while (nodeIterator.hasNext()) {
//            Node node = nodeIterator.next();
//        }
//        Iterable<RelationShip> relationShips = relationShipReporistory.findAll();
//
//        List<RelationShip> relationShipsList = Lists.newArrayList(relationShips);
//        resultMap.put("relationShips", relationShipsList);
//
//        Iterator<RelationShip> relationShipIterator = relationShips.iterator();
//        while (relationShipIterator.hasNext()) {
//            RelationShip relationShip = relationShipIterator.next();
//        }

        List<Node> nodeList = nodeReporistory.findAll();
        resultMap.put("nodes", nodeList);
        List<RelationShip> relationShips = relationShipReporistory.findAll();
        resultMap.put("relationShips", relationShips);
        return resultMap;
    }

    @GetMapping("deleteAll")
    public void deleteAll() {
        nodeReporistory.deleteAll();
        relationShipReporistory.deleteAll();
    }


}

