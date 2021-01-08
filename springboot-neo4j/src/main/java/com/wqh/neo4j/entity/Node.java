package com.wqh.neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.*;

/**
 * @ClassName Node
 * @Author wqh
 * @Date 2021/1/8 10:32
 * @Description TODO
 * @Version 1.0
 */
@NodeEntity(label = "node")
@Data
@Builder
public class Node {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "name")
    private String name;
}
