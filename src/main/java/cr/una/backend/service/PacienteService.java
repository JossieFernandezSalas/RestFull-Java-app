/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Paciente;

import java.util.List;

/**
 * Paciente Service
 * Maneja la logica para Paciente
 */
public interface PacienteService {

    /**
     * Encuentra el paciente que hace match con el codigo
     * @param codigo de la identidad del paciente
     * @return la Entidad Paciente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Paciente buscaPorId (int codigo) throws DAOException, ServiceException;

    /**
     * Guarda un nuevo Paciente en la base de datos
     * @param paciente a guardar
     * @return el paciente guardado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Paciente guardar(Paciente paciente) throws DAOException, ServiceException;

    /**
     * Actualiza un paciente en la base de datos
     * @param paciente a actualizar
     * @return el paciente actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Paciente actualizar(Paciente paciente) throws DAOException, ServiceException;

    /**
     * Carga todos los pacientes de la base de datos
     * @return una lista de pacientes
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public List<Paciente> cargarDatos() throws DAOException, ServiceException;

    /**
     * Borra un paciente de la base de datos
     * @param idPaciente del paciente
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public boolean borrar(int idPaciente) throws DAOException, ServiceException;
}
