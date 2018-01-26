package com.gm;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * <p>
 *                      Classe principale
 * </p> 
 *
 * @author Cyril Chevalier
 * @since 0.0.1
 */
@SpringBootApplication
public class GmApp {

    // Constantes
    private static final Logger log = LoggerFactory.getLogger(GmApp.class);
    
    
    // ------------------------------ Méthodes statiques publiques ------------------------------------
    /**
     * Méthode principale
     * @param args
     * @throws UnknownHostException 
     * @since 0.0.1
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(GmApp.class);
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
