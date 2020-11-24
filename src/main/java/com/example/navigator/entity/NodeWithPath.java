package com.example.navigator.entity;

import lombok.Data;

import java.util.List;

@Data
public class NodeWithPath extends Node{
    private List<Node> path;
}
