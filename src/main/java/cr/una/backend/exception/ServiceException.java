/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Manejo de excepciones para el service
 */
public class ServiceException extends Exception{

    private static final Logger logger = LogManager.getLogger(ServiceException.class);

    /**
     * Excepcion service customizada
     * @param message mensage mensaje error
     */
    public ServiceException(String message) {
        super(message);
        logger.error("Error importante - Capa Service");
    }

    /**
     * Excepcion service customizada
     * @param message mensage mensaje error
     * @param cause causa mensaje error
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Error importante - Capa Service", cause);
    }
}
