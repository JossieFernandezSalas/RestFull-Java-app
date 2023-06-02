/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.exception;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Manejo de excepciones para DAO
 */
public class DAOException extends Exception{
    private static final Logger logger = LogManager.getLogger(DAOException.class);

    /**
     * Excepcion dao customizada
     * @param message mensage mensaje error
     */
    public DAOException(String message) {
        super(message);
        logger.error("Error importante - Capa DAO");
    }

    /**
     * Excepcion dao customizada
     * @param message mensaje error
     * @param cause causa error
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
        logger.error("Error importante - Capa DAO", cause);
    }

}
