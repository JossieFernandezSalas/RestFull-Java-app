/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Consultorio;

import java.util.List;

/**
 * Consultorio Service
 * Maneja la logica para Consultorio
 */
public interface ConsultorioService {
    /**
     * Encuentra el Consultorio que hace match con el codigo
     * @param codigo del Consultorio a buscar
     * @return el consultorio a buscar
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Consultorio buscaPorId (int codigo) throws DAOException, ServiceException;

    /**
     * Guarda un nuevo Consultorio en la base de datos
     * @param consultorio a guardar
     * @return el consultorio guardado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Consultorio guardar(Consultorio consultorio) throws DAOException, ServiceException;

    /**
     * Actualiza un Consultorio en la base de datos
     * @param consultorio a actualizar
     * @return el consultorio actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Consultorio actualizar(Consultorio consultorio) throws DAOException, ServiceException;

    /**
     * Carga todos los consultorios de la base de datos
     * @return una lista de Consultorio
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public List<Consultorio> cargarDatos() throws DAOException, ServiceException;

    /**
     * Borra un Consultorio de la base de datos
     * @param idConsultorio del consultorio a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public boolean borrar(int idConsultorio) throws DAOException, ServiceException;
}
