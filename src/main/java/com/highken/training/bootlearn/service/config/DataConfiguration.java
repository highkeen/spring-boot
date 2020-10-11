package com.highken.training.bootlearn.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "boot.learn.config")
@Data
@Configuration
public class DataConfiguration {

	private int initStudentCount;
}
