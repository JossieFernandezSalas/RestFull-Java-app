/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.dao.PacienteDAO;
import cr.una.backend.dao.PacienteDAOImpl;
import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Paciente;

import java.util.List;

/**
 * Implementacion del PacienteService
 */
public class PacienteServiceImpl implements PacienteService{
    private PacienteDAO pacienteDAO;

    /**
     * Encuentra el paciente que hace match con el codigo
     * @param codigo de la identidad del paciente
     * @return la Entidad Paciente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Paciente buscaPorId(int codigo) throws DAOException, ServiceException {
        Paciente paciente = null;
        pacienteDAO = new PacienteDAOImpl();
        paciente = pacienteDAO.buscaPorId(codigo);
        return paciente;
    }

    /**
     * Guarda un nuevo Paciente en la base de datos
     * @param paciente a guardar
     * @return el paciente guardado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Paciente guardar(Paciente paciente) throws DAOException, ServiceException {
        Paciente pacienteAux = null;
        pacienteDAO = new PacienteDAOImpl();
        pacienteAux = pacienteDAO.guardar(paciente);
        return pacienteAux;
    }

    /**
     * Actualiza un paciente en la base de datos
     * @param paciente a actualizar
     * @return el paciente actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Paciente actualizar(Paciente paciente) throws DAOException, ServiceException {
        Paciente pacienteAux = null;
        pacienteDAO = new PacienteDAOImpl();
        pacienteAux = pacienteDAO.actualizar(paciente);
        return pacienteAux;
    }

    /**
     * Carga todos los pacientes de la base de datos
     * @return una lista de pacientes
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public List<Paciente> cargarDatos() throws DAOException, ServiceException {
        List<Paciente> pacienteList = null;
        pacienteDAO = new PacienteDAOImpl();
        pacienteList = pacienteDAO.cargarDatos();
        return pacienteList;
    }

    /**
     * Borra un paciente de la base de datos
     * @param idPaciente del paciente
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public boolean borrar(int idPaciente) throws DAOException, ServiceException {
        boolean pacienteAux = false;
        pacienteDAO = new PacienteDAOImpl();
        pacienteAux = pacienteDAO.borrar(idPaciente);
        return pacienteAux;
    }
}
