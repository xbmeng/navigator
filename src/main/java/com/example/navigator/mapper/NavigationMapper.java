package com.example.navigator.mapper;

import com.example.navigator.domain.Navigation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface NavigationMapper {

    @Select(
            "select * from navigation where uuid = #{uuid}"
    )
    Navigation selectByPrimaryKey(@Param("uuid")String uuid);

}
