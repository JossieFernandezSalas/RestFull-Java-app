/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Consultorio;

import java.util.List;

/**
 * Consultorio DAO interface
 */
public interface ConsultorioDAO {

    /**
     * Encuentra el Consultorio que hace match con el codigo
     * @param codigo del Consultorio a buscar
     * @return el Consultorio encontrada
     * @throws DAOException DAO Exception
     */
    public Consultorio buscaPorId (int codigo) throws DAOException;

    /**
     * Guarda un nuevo Consultorio en la base de datos
     * @param consultorio a guardar
     * @return el Consultorio guardado
     * @throws DAOException DAO Exception
     */
    public Consultorio guardar(Consultorio consultorio) throws DAOException;

    /**
     * Actualiza un Consultorio en la base de datos
     * @param consultorio a actualizar
     * @return el Consultorio actualizado
     * @throws DAOException DAO Exception
     */
    public Consultorio actualizar(Consultorio consultorio) throws DAOException;

    /**
     * Carga todos los consultorios de la base de datos
     * @return una lista de consultorios
     * @throws DAOException DAO Exception
     */
    public List<Consultorio> cargarDatos() throws DAOException;

    /**
     * Borra un Consultorio de la base de datos
     * @param idConsultorio es la identificacion del Consultorio
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    public boolean borrar(int idConsultorio) throws DAOException;
}
