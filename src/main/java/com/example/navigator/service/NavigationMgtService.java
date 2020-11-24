package com.example.navigator.service;

import com.example.navigator.common.entity.NodeType;
import com.example.navigator.dao.NavigationDao;
import com.example.navigator.domain.Navigation;
import com.example.navigator.entity.CreateRequest;
import com.example.navigator.entity.NodeWithPath;
import com.example.navigator.entity.TreeNode;
import com.alibaba.fastjson.JSON;
import com.example.navigator.util.NavigationConvertToTreeNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class NavigationMgtService {
    @Resource
    private NavigationDao navigationDao;
    @Resource
    NavigationConvertToTreeNode navigationConvertToTreeNode;

    public TreeNode create(CreateRequest request, boolean autoRename) throws SQLException, ClassNotFoundException {
        Navigation navigationRequest = JSON.parseObject(JSON.toJSONString(request), Navigation.class);

        Navigation navigation = navigationDao.creat(navigationRequest);

        TreeNode treeNode = NavigationConvertToTreeNode.convertToTreeNode(navigation);
        TreeFactory.getTree();
        return treeNode;

    }
}
