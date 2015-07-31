package by.example.config;

import by.example.simpleportlet.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(PersistenceConfig.class)
@ComponentScan("by.example.controllers")
public class AppConfig {
}