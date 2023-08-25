package com.mycomp.reactive.web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mycomp.reactive.*"})
@EntityScan(basePackages = {"com.mycomp.reactive.*"})
public class ModuleConfig {
}
