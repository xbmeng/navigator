package com.example.navigator.util;

import com.alibaba.fastjson.JSON;
import com.example.navigator.common.entity.NodeType;
import com.example.navigator.domain.Navigation;
import com.example.navigator.entity.TreeNode;
import com.example.navigator.service.TreeFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class NavigationConvertToTreeNode {
    public static TreeNode convertToTreeNode(Navigation navigation)
    {
        TreeNode treeNode;
        //if(navigation.getNodeType() == NodeType.DIR)
        treeNode = JSON.parseObject(JSON.toJSONString(navigation),TreeNode.class);
        TreeNode parent = TreeFactory.getTreeNode(navigation.getParentUUID());

        List<String> nodePath;
        if(parent != null)
        {
            nodePath = new ArrayList<>(Arrays.asList(new String[parent.getUuidPath().size()]));
            Collections.copy(nodePath,parent.getUuidPath());
        }else
            nodePath = new ArrayList<>();
        nodePath.add(treeNode.getUuid());
        treeNode.setUuidPath(nodePath);
        TreeFactory.putTreeNode(treeNode);
//        if(parent == null)
//            TreeFactory.creatTree(treeNode);
//        else
            parent.addChild(treeNode);

        return treeNode;
    }
}
