var ioc = {
    dataSource: {
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            create: "init",
            depose: 'close'
        },
        fields: {
            url: "jdbc:mysql://localhost:3306/nutz",
            username: "root",
            password: "root",
            testWhileIdle: true, // 非常重要,预防mysql的8小时timeout问题
            validationQuery: "select 1", // Oracle的话需要改一下
            maxWait: 15000, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程,
            maxActive: 100
        }
    },
    dao: {
        type: "org.nutz.dao.impl.NutDao",
        args: [{refer: "dataSource"}]
    }

    // $aop: {
    //     type: 'org.throwable.aop.config.AnthorJsonAopConfiguration'
    // }
};
