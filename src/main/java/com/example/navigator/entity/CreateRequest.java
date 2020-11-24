package com.example.navigator.entity;

import com.example.navigator.common.entity.NodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequest {

    private String parentUUID;
    private String uuid;
    private String name;
    private NodeType nodeType;
}
