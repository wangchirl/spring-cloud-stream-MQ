### windows下 spring cloud stream 处理多种MQ的案例

#### rabbitMQ
1. 下载安装rabbitMQ
    - 下载erlang并安装，配置环境变量
    - rabbitmq-plugins.bat enable rabbitmq_management
    - rabbitmq-server.bat
    - http://localhost:15672/  账号/密码：guest/guest
2. springboot项目开发
    - @EnableBinding 开启绑定
    - RabbitMQSink 消费者通道
    - RabbitMQSource 提供者通道
    - Consumer 消费者处理类
    - Provider 提供者处理类
3. yml文件配置
    ```yaml
    server:
      port: 8080
      servlet:
        context-path: /rabbitmq
    spring:
      cloud:
        stream:
          bindings:
            input: # 自定义 - RocketMQSink
              destination: default.messages # exchange
              binder: local_rabbit
            output: # 自定义 - RocketMQSource
              destination: default.messages # exchange
              binder: local_rabbit
          binders:
            local_rabbit:
              type: rabbit # 指定MQ类型
              environment:
                spring:
                  rabbitmq:
                    host: localhost # rabbitMQ服务地址
                    port: 5672 # rabbitMQ服务端口
                    username: guest # rabbitMQ用户名称
                    password: guest # rabbitMQ用户密码
    ```

#### kafka
1. 下载安装Kafka
    - 下载 zoopeeker并启动
        - zkServer.cmd
        - zkCli.cmd 
    - 启动Kafka服务
        - kafka-server-start.bat ..\..\config\server.properties
2. springboot项目开发
    - @EnableBinding 开启绑定
    - KafkaSink 消费者通道
    - KafkaSource 提供者通道
    - Consumer 消费者处理类
    - Provider 提供者处理类
3. yml文配置
    ```yaml
    server:
      port: 8080
      servlet:
        context-path: /kafka
    spring:
      cloud:
        stream:
          kafka:
            binder:
              brokers: localhost:9092 #Kafka的消息中间件服务器
              zk-nodes: localhost:2181 #Zookeeper的节点，如果集群，后面加,号分隔
              auto-create-topics: true  #如果设置为false,就不会自动创建Topic 有可能你Topic还没创建就直接调用了
          bindings:
            output:      #这里用KafkaSource.class中定义的
              destination: kafka-topic    #消息发往的目的地 topic
              content-type: application/json    #消息发送的格式，接收端不用指定格式，但是发送端要，一般都是json
            input: # 这里用KafkaSink.class 中定义的
              destination: kafka-topic # topic
              content-type: application/json
    ```

#### rocketMQ
1. 下载rocketMQ安装启动
    - 配置 ROCKETMQ_HOME
    - 启动nameServer ： mqnamesrv,cmd
    - 启动broker ：start mqbroker.cmd -n 127.0.0.1:9876 autoCreateTopicEnable=true
2. springboot项目开发
    - @EnableBinding 开启绑定
    - RocketMQSink 消费者通道
    - RocketMQSource 提供者通道
    - Consumer 消费者处理类
    - Provider 提供者处理类
3. yml文件配置
    ```yaml
    server:
      port: 8080
      servlet:
        context-path: /rocketmq
    spring:
      cloud:
        stream:
          rocketmq:
            binder:
              name-server: localhost:9876 # brocker服务器地址
          bindings:
            output: # 可以自定义-RocketMQSource
              destination: rocketmq-topic # topic
              content-type: application/json # 数据格式
            input: # 可以自定义-RocketMQSink
              destination: rocketmq-topic # topic
              content-type: application/json # 数据格式
              group: test-group # 必须指定group
    ```