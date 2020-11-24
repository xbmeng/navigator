package com.example.navigator.domain;

import com.alibaba.fastjson.JSON;
import com.example.navigator.common.entity.NodeType;
import com.example.navigator.entity.TreeNode;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "navigation")
@Entity
public class Navigation {
    private String parentUUID;
    private NodeType nodeType;
    private String name;
    private String UUID;


    public Navigation(String parentUUID,NodeType nodeType,String name,String UUID)
    {
        this.parentUUID = parentUUID;
        this.nodeType = nodeType;
        this.name = name;
        this.UUID = UUID;
    }

    @Basic
    @Column(name = "uuid")
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    @Basic
    @Column(name = "parent_uuid")
    public String getParentUUID() {
        return parentUUID;
    }

    public void setParentUUID(String parentUUID) {
        this.parentUUID = parentUUID;
    }

    @Basic
    @Column(name = "node_type")
    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
