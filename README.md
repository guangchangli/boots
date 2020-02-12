# boots

1. #### pom

   ```
    <relativePath /> <!-- lookup parent from repository -->
    默认值为../pom.xml
    查找顺序：relativePath元素中的地址–本地仓库–远程仓库
    设定一个空值将始终从仓库中获取，不从本地路径获取
   ```

2. Error assembling WAR: webxml attribute is required

   ```
   		        <!-- 没有web.xml文件的情况下构建WAR
   		        使用maven-war-plugin3.0，解决了web.xml不存在无法构建war的问题
               <plugin>
                   <artifactId>maven-war-plugin</artifactId>
                   <version>3.0.0</version>
               </plugin>
               -->
               继续使用maven-war-plugin2.6，添加设置failOnMissingWebXml=false
               <plugin>
                   <artifactId>maven-war-plugin</artifactId>
                   <version>2.6</version>
                   <configuration>
                       <!--如果想在没有web.xml文件的情况下构建WAR，请设置为false。-->
                       <failOnMissingWebXml>false</failOnMissingWebXml>
                   </configuration>
               </plugin>
   ```

   关于springboot 中发布 使用  war 移除 内嵌 tomcat  前后端分离+ swagger 

   ```
   				<dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
               <!-- 移除嵌入式tomcat插件，或者scope = provided
               <exclusions>
                   <exclusion>
                       <groupId>org.springframework.boot</groupId>
                       <artifactId>spring-boot-starter-tomcat</artifactId>
                   </exclusion>
               </exclusions>
               -->
           </dependency>
   
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-tomcat</artifactId>
               <scope>provided</scope>
           </dependency>
   
           <!--<dependency>
               <groupId>javax.servlet</groupId>
               <artifactId>javax.servlet-api</artifactId>
               <scope>provided</scope>
           </dependency>-->
   ```

   