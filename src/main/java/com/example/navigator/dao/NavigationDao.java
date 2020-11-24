package com.example.navigator.dao;

import com.example.navigator.domain.Navigation;
import com.example.navigator.entity.TreeNode;
import com.example.navigator.mapper.NavigationMapper;
import com.example.navigator.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class NavigationDao{

    public static String diverName="com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    public static String userName="root";
    public static String password="root";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(diverName);//加载
        //指定用户名和密码
        Connection conn = DriverManager.getConnection(url, userName,password);
        return conn;
    }

//    @Resource private NavigationMapper navigationMapper;


    public Navigation creat(Navigation request) throws SQLException, ClassNotFoundException {
        if(StringUtils.isBlank(request.getUUID()))
            request.setUUID(UUIDUtil.generateUUID());

        Connection conn = NavigationDao.getConnection();

        String sql = "insert into navigation values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,request.getUUID());
        ps.setString(2, request.getParentUUID());
        ps.setString(3,request.getNodeType().toString());
        ps.setString(4,request.getName());
        int res = ps.executeUpdate();
//        return navigationMapper.selectByPrimaryKey(request.getUUID());
        return new Navigation(request.getParentUUID(),request.getNodeType(),request.getName(),request.getUUID());
    }


}
