/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Paciente;

import java.util.List;

/**
 * Paciente DAO interface
 */
public interface PacienteDAO {

    /**
     * Encuentra el paciente que hace match con el id
     * @param codigo del paciente a buscar
     * @return el paciente encontrado
     * @throws DAOException DAO Exception
     */
    public Paciente buscaPorId (int codigo) throws DAOException;

    /**
     * Guarda un nuevo Paciente en la base de datos
     * @param paciente a guardar
     * @return el paciente guardado
     * @throws DAOException DAO Exception
     */
    public Paciente guardar(Paciente paciente) throws DAOException;

    /**
     * Actualiza un paciente en la base de datos
     * @param paciente a actualizar
     * @return el paciente actualizado
     * @throws DAOException DAO Exception
     */
    public Paciente actualizar(Paciente paciente) throws DAOException;

    /**
     * Carga todos los pacientes de la base de datos
     * @return una lista de pacientes
     * @throws DAOException DAO Exception
     */
    public List<Paciente> cargarDatos() throws DAOException;

    /**
     * Borra un paciente de la base de datos
     * @param idPaciente del paciente a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    public boolean borrar(int idPaciente) throws DAOException;
}
