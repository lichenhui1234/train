package com.guangzhaohui.lrps;

import com.guangzhaohui.lrps.entity.MuscleEntity;
import com.guangzhaohui.lrps.service.MuscleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichenhui
 */
@SpringBootApplication
@EnableJpaRepositories
@RestController
public class LrpsApplication {
    private final MuscleService muscleService;

    public LrpsApplication(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping("/muscle/insert")
    public MuscleEntity insertMuscle(MuscleEntity entity) {
        return muscleService.insert(entity);
    }

    public static void main(String[] args) {
        SpringApplication.run(LrpsApplication.class, args);
    }

}
