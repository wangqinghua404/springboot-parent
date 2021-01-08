package com.wqh.neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.*;

/**
 * @ClassName RelationShip
 * @Author wqh
 * @Date 2021/1/8 10:33
 * @Description TODO
 * @Version 1.0
 */
@RelationshipEntity(type = "relationShip")
@Data
@Builder
public class RelationShip {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @StartNode
    private Node parent;

    @EndNode
    private Node child;
}
