1. swagger

   | 注解              | 示例                                                         | 描述                                       |
   | :---------------- | :----------------------------------------------------------- | :----------------------------------------- |
   | @ApiModel         | @ApiModel(value = "用户对象")                                | 描述一个实体对象                           |
   | @ApiModelProperty | @ApiModelProperty(value = "用户ID", required = true, example = "1000") | 描述属性信息，执行描述，是否必须，给出示例 |
   | @Api              | @Api(value = "用户操作 API(v1)", tags = "用户操作接口")      | 用在接口类上，为接口类添加描述             |
   | @ApiOperation     | @ApiOperation(value = "新增用户")                            | 描述类的一个方法或者说一个接口             |
   | @ApiParam         | @ApiParam(value = "用户名", required = true)                 | 描述单个参数                               |