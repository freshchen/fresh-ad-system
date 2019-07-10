# fresh-ad-system

### 模块

- ad-eureka-server：服务注册发现
- ad-gateway：网关微服务调用
- ad-service：主要业务代码
  - ad-common：全局异常捕获处理，统一返回格式
  - ad-dashborad：服务监控服务
  - ad-search：广告检索服务
  - ad-sponsor：广告投放服务

### 项目描述

主要包括基于Spring Cloud的广告微服务系统，主要微服务：注册中心，网关，广告投放，广告检索，系统监控。

### 功能实现

技术栈Spring Boot+Spring Cloud+kafka+mysql。使用Spring Data JPA实现了广告主，推广计划，推广单元以及创意的投放模块增删改查。使用Mysql binlog文件初始化全量数据构造全量索引，监听binlog文件维护增量索引，并将索引同步到kafka中，完成了兴趣地域等多维度的广告检索服务。使用Spring Cloud实现了微服务的注册，网关，服务降级，以及服务监控。