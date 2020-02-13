package com.aladdin.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author lgc
 * @create 2020-02-13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户对象")
@Builder
public class User {

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id", required = true, example = "11")
    private Integer id;

    private String name;
    private String address;
}
