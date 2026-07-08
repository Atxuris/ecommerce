package com.techlab.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Properties;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] eloquence) {
        SpringApplication application = new SpringApplication(EcommerceApplication.class);
        
        // Configuramos las propiedades de la base de datos directamente por código
        Properties properties = new Properties();
        properties.put("spring.datasource.url", "jdbc:mysql://localhost:3306/ecommerce_db?serverTimezone=UTC&useSSL=false");
        properties.put("spring.datasource.username", "root");
        properties.put("spring.datasource.password", "Minerva2025."); // 
        properties.put("spring.jpa.hibernate.ddl-auto", "create-drop");
        properties.put("spring.jpa.show-sql", "true");
        properties.put("spring.jpa.properties.hibernate.format_sql", "true");
        
        application.setDefaultProperties(properties);
        application.run(eloquence);
    }
}