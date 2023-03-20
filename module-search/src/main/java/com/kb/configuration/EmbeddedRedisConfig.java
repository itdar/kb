package com.kb.configuration;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import redis.embedded.RedisServer;

@Slf4j
@Profile("local")
@Configuration
public class EmbeddedRedisConfig {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void redisServer() throws IOException {
        int redisPort = this.redisPort;

        if (isArmMac()) {
            redisServer = new RedisServer(Objects.requireNonNull(getRedisFileForArcMac()),
                redisPort);
        }
        if (!isArmMac()) {
            redisServer = new RedisServer(redisPort);
        }

        redisServer.start();
    }

    private boolean isArmMac() {
        return Objects.equals(System.getProperty("os.arch"), "aarch64") &&
            Objects.equals(System.getProperty("os.name"), "Mac OS X");
    }

    private File getRedisFileForArcMac() throws IOException {
        return new ClassPathResource("binary/redis/redis-server-6.0.10-mac-arm64").getFile();
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }

}
