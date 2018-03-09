package com.fondation;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * <p>
 *                          Application de tests pour la partie outils
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@SpringBootApplication
public class FondationToolsTestApp {

    // Constantes
    private static final Logger log = LoggerFactory.getLogger(FondationToolsTestApp.class);
    
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(FondationToolsTestApp.class);
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "External: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
        
    }
    
}
