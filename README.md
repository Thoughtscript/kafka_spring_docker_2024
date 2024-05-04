# spring_docker_2024

[![](https://img.shields.io/badge/bitnami-kafka-red.svg)](https://hub.docker.com/r/bitnami/kafka) [![](https://img.shields.io/badge/Java-22-blue.svg)](https://hub.docker.com/_/maven) [![](https://img.shields.io/badge/Spring-Webflux-green.svg)](https://docs.spring.io/spring-framework/reference/web/webflux.html)

Run the following from the root dir:

```bash
docker-compose up
```

Upon running that command you should see:

```bash
consumer_1  | 2024-05-03T23:57:07.747Z  INFO 60 --- [or-http-epoll-2] i.t.s.c.ReactiveRestController           : webclient message
producer_1  | 2024-05-03T23:57:07.749Z  INFO 60 --- [or-http-epoll-3] i.t.publisher.webclient.WebClient        : WebClient message sent!
producer_1  | 2024-05-03T23:57:12.335Z  INFO 60 --- [pool-5-thread-1] i.t.p.kafka.EmbeddedComponentClient      : Kafka message sent!
consumer_1  | 2024-05-03T23:57:12.338Z  INFO 60 --- [ntainer#0-0-C-1] i.t.s.kafka.EmbeddedComponentReceiver    : hello1
consumer_1  | 2024-05-03T23:57:12.338Z  INFO 60 --- [ntainer#0-0-C-1] i.t.s.kafka.EmbeddedComponentReceiver    : hello2
consumer_1  | 2024-05-03T23:57:12.338Z  INFO 60 --- [ntainer#0-0-C-1] i.t.s.kafka.EmbeddedComponentReceiver    : hello3
consumer_1  | 2024-05-03T23:57:12.339Z  INFO 60 --- [ntainer#0-0-C-1] i.t.s.kafka.EmbeddedComponentReceiver    : hello4
consumer_1  | 2024-05-03T23:57:12.752Z  INFO 60 --- [or-http-epoll-2] i.t.s.c.ReactiveRestController           : webclient message
producer_1  | 2024-05-03T23:57:12.753Z  INFO 60 --- [or-http-epoll-3] i.t.publisher.webclient.WebClient        : WebClient message sent!
```

The **Producer** app will repeatedly loop through and send a bunch of HTTP Webflux and Kafka messages to the `test` topic. The **Consumer** app will consume both kinds of messages using the simply wonderful (concise) `EmbeddedComponentClient` approach (great functionalitiy provided by the Spring Kafka libraries) and a `ReactiveRestController`!

> Note: the whole cluster may take a few seconds to stabilize on app initialization, eventually you should just see a loop of messages like hte above.

## Kafka Notes

Trying out:

1. Kafka without Zookeeper! Using KRraft.
2. Addressing [Scenario 5](https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/#scenario-5) without doing the recommended ways (great article and super helpful - not sure exactly what's changed since 2020 but I got this working with two changes: `networks` in [docker-compose.yml](docker-compose.yml) and `spring.kafka.bootstrap-servers` using the Docker-managed DNS `kafka:9092` in [application.properties](src/main/resources/application.properties)).
3. Containerizing, simplifying, and updating my 2022 examples from: [java-reactive-pubsub
](https://github.com/Thoughtscript/java-reactive-pubsub).


## Resources and Links

1. https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/#scenario-5
2. https://www.baeldung.com/java-kafka-bootstrap-server