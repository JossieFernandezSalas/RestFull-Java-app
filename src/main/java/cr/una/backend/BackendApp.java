/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BackendApp {

    private static final Logger logger = LogManager.getLogger(BackendApp.class);

    public static void main(String[] args) {
        logger.info("Inicializando el Backend");
        SpringApplication app = new SpringApplication(BackendApp.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "9999"));
        app.run(args);

    }
}
