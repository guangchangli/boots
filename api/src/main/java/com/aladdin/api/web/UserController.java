package com.aladdin.api.web;

import com.aladdin.api.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgc
 * @create 2020-02-13
 **/
@RestController
@RequestMapping("/user")
@Api(value = "用户接口",tags = "user")
public class UserController {

    @RequestMapping("/list")
    @ApiOperation(value = "用户列表")
    public String userList(@ApiParam(value = "用户姓名",required = false) String name){
        User user = new User();
        User build = User.builder().id(1).name("123").address("1231231").build();
        User build1 = User.builder().id(2).name("222").address("1231231").build();
        User build2 = User.builder().id(3).name("333").address("123123").build();
        List<User> users = new ArrayList<>();
        users.add(build);
        users.add(build1);
        users.add(build2);

        return "user list";
    }
}
