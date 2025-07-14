package com.cognizant.springresthandson3.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class CustomDateEditorRegistrar {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();

        configurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{
            new PropertyEditorRegistrar() {
                @Override
                public void registerCustomEditors(PropertyEditorRegistry registry) {
                    registry.registerCustomEditor(Date.class,
                        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
                }
            }
        });

        return configurer;
    }
}
