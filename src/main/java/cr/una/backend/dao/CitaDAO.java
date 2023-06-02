/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Cita;


import java.util.List;

/**
 * Cita DAO Interface
 */
public interface CitaDAO {

    /**
     * Encuentra la Cita que hace match con el codigo
     * @param codigo de la Cita a buscar
     * @return la Cita encontrada
     * @throws DAOException DAO Exception
     */
    public Cita buscaPorId (int codigo) throws DAOException;

    /**
     * Guarda una nueva Cia en la base de datos
     * @param cita a guardar
     * @return la Cita actualizado
     * @throws DAOException DAO Exception
     */
    public Cita guardar(Cita cita) throws DAOException;

    /**
     * Actualiza una Cita en la base de datos
     * @param cita a actualizar
     * @return la Entidad del Cita actualizado
     * @throws DAOException DAO Exception
     */
    public Cita actualizar(Cita cita) throws DAOException;

    /**
     * Carga todas los citas de la base de datos
     * @return una lista de Citas
     * @throws DAOException DAO Exception
     */
    public List<Cita> cargarDatos() throws DAOException;

    /**
     * Borra una Cita de la base de datos
     * @param idCita de la Cita borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    public boolean borrar(int idCita) throws DAOException;
}
