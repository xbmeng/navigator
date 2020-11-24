package com.example.navigator.controller;


import com.example.navigator.common.utils.Page;
import com.example.navigator.config.SwaggerConfig;
import com.example.navigator.entity.CreateRequest;
import com.example.navigator.entity.NodeWithPath;
import com.example.navigator.entity.TreeNode;
import com.example.navigator.service.NavigationMgtService;
import com.example.navigator.service.NavigationQueryService;
import com.example.navigator.util.NameUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "目录功能")
@RestController
@RequestMapping(value = SwaggerConfig.API_V1 + "/test")
public class NavigatorController {

//    @Resource private NavigationQueryService navigationQueryService;
    @Resource private NavigationMgtService navigationMgtService;

//    @ApiOperation(value = "获取下级列表")
//    @PostMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void getChildren(HttpServletRequest httpServletRequest, @RequestBody QueryRequest request)
//    {
//        //TODO
//    }

    @ApiOperation(value = "创建文件夹")
    @PostMapping(value = "/newDir", produces = MediaType.APPLICATION_JSON_VALUE)
    public TreeNode newDir(@RequestBody CreateRequest request) throws Exception {
        request.setName(NameUtil.namingTrimAndConventions(request.getName()));
        return navigationMgtService.create(request, false);
    }



}
