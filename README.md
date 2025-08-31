# RabbitMQ

## 1. docker安装

```shell
docker run \
 -e RABBITMQ_DEFAULT_USER=xqs \
 -e RABBITMQ_DEFAULT_PASS=1 \
 -v rabbitmq-plugins:/plugins \
 --name rabbitmq \
 --hostname rabbitmq \
 -p 15672:15672 \
 -p 5672:5672 \
 -d \
 rabbitmq:3.8-management
```

---

## 2. yaml配置

consumer和producer一样

```yaml
spring:
  rabbitmq:
    addresses: 192.168.133.103
    port: 5672
    virtual-host: /rabbitmq-stu
    username: xqs
    password: 1
```

