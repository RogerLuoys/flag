# flag主应用
flag是一个帮助用户一步步实现自己flag的业务系统。\
主要功能有：\
1、flag自我管理流程，包含flag中的细分日常任务管理\
2、flag分享及展示流程，包含查看flag实现细节及将自己的自我管理经验分享给其它用户\
3、flag见证流程，可以让自己最信任人监督自己或与最亲密的人共同成长，同时进一步拉近双方距离\
4、积分流程，flag完成总要给自己点奖励\
5、联系人功能，附加功能

#子模块简介
flag-stater 程序启动模块，main方法入口\
flag-service service层，简单参数处理和restful接口定义\
flag-manage manage层，主要业务逻辑\
flag-dao 持久层，直接对接数据库\
flag-api 对外提供的jar包

#代码格式
1、service层接口名用query**、new**、remove**、modify**格式取名\
2、dao层接口名用select**、create**、delete**、update**格式取名\
3、除了flag_bind等关联表，其它表查询不要join，可以冗余