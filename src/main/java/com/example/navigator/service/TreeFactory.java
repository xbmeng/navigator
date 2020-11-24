package com.example.navigator.service;

import com.example.navigator.common.entity.NodeType;
import com.example.navigator.entity.TreeNode;
import com.example.navigator.util.UUIDUtil;
import com.google.common.util.concurrent.Striped;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class TreeFactory {
    private static final Map<String, TreeNode> treeNodeMap = new ConcurrentHashMap<>();
//    private static final Map<String, List<String>> treesMap = new ConcurrentHashMap<>();
//    List<String> path;
    private static final Striped<Lock> lockStriped = Striped.lazyWeakLock(10);

    static
    {
        treeNodeMap.put("-",new TreeNode(UUIDUtil.generateUUID(),"parent", NodeType.DIR,new ArrayList<>(),new ArrayList<>()));
    }
    public static TreeNode getTreeNode(String uuid)
    {
        return treeNodeMap.get(uuid);
    }

    public static void putTreeNode(TreeNode node) {
        treeNodeMap.put(node.getUuid(), node);
    }

    public static void getTree()
    {
        System.out.println(treeNodeMap.values());
    }

//    public static void creatTree(TreeNode treeNode) throws Exception {
//        if(treeNode.getUuidPath().size() != 1)
//        {
//            treeNode.getUuidPath().clear();
//            List<String> path = new ArrayList<>();
//            path.add(treeNode.getUuid());
//            treeNode.setUuidPath(path);
//        }
//        List<String> treeNodeList = treesMap.get(treeNode.getUuid());
//        if(treeNodeList == null)
//        {
//            treeNodeList = new ArrayList<>();
//        }
//        Lock lock = lockStriped.get(treeNode.getUuid());
//        if(lock.tryLock()){
//            try {
//                if(treeNodeList.contains(treeNode.getUuid()))
//                    return;
//                treeNodeList.add(treeNode.getUuid());
//            }finally {
//                lock.unlock();
//            }
//        }else
//            throw new Exception();
//        treesMap.put(,treeNodeList);
//
//    }

    static void deleteTreeNode(String uuid) {
        treeNodeMap.remove(uuid);
    }
}
