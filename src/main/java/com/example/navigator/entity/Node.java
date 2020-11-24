package com.example.navigator.entity;

import com.example.navigator.common.entity.NodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private String uuid;
    private String name;
    private NodeType nodeType;

}
