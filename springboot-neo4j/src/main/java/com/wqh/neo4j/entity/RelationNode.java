package com.wqh.neo4j.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.*;

/**
 * @ClassName RelationNode
 * @Author wqh
 * @Date 2021/1/7 17:10
 * @Description TODO
 * @Version 1.0
 */
@RelationshipEntity(type = "RelationEdge")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Getter
public class RelationNode {
    private @Id
    @GeneratedValue
    Long id;
    private @StartNode
    ParentNode parentNode;
    // 关系名
    private String name;
    private @EndNode
    SonNode sonNode;

    RelationNode(ParentNode parentNode, String name, SonNode sonNode) {
        this.parentNode = parentNode;
        this.name = name;
        this.sonNode = sonNode;

    }
}
