package com.guangzhaohui.lrps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichenhui
 */
@SpringBootApplication
@EnableJpaRepositories
@RestController
public class LrpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LrpsApplication.class, args);
    }

}
