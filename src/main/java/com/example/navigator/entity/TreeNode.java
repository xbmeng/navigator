package com.example.navigator.entity;

import com.example.navigator.common.entity.NodeType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

@Data
public class TreeNode {
    private String uuid;
    private String name;
    private NodeType nodeType;
    List<String> uuidPath;
    List<String> children;
    private StampedLock structureLock = new StampedLock(); // 锁parentUUID、uuidPath、children

    public TreeNode()
    {
        init();
    }
    public TreeNode(String uuid)
    {
        this.uuid = uuid;
        init();
    }
    public TreeNode(String uuid,String name,NodeType nodeType,List<String> uuidPath,List<String> children)
    {
        this.uuid = uuid;
        this.name = name;
        this.nodeType = nodeType;
        this.uuidPath = uuidPath;
        this.children = children;
    }

    private void init()
    {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (uuidPath == null) {
            uuidPath = new ArrayList<>();
        }
    }

    public StampedLock getStructureLock() {
        if (null == structureLock) {
            structureLock = new StampedLock();
        }
        return structureLock;
    }

    public void addChild(TreeNode treeNode) {
        init();
        long stamp = getStructureLock().writeLock();
        try {
            children.add(treeNode.getUuid());
        } finally {
            structureLock.unlockWrite(stamp);
        }
    }


}
