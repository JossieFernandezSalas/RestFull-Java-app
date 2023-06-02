/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.dao.ConsultorioDAO;
import cr.una.backend.dao.ConsultorioDAOImpl;
import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Consultorio;

import java.util.List;

/**
 * Implementacion del ConsultorioService
 */
public class ConsultorioServiceImpl implements ConsultorioService{
    private ConsultorioDAO consultorioDAO;

    /**
     * Encuentra el Consultorio que hace match con el codigo
     * @param codigo del Consultorio a buscar
     * @return el consultorio a buscar
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Consultorio buscaPorId(int codigo) throws DAOException, ServiceException {
        Consultorio consultorio = null;
        consultorioDAO = new ConsultorioDAOImpl();
        consultorio = consultorioDAO.buscaPorId(codigo);
        return consultorio;
    }

    /**
     * Guarda un nuevo Consultorio en la base de datos
     * @param consultorio a guardar
     * @return el consultorio guardado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Consultorio guardar(Consultorio consultorio) throws DAOException, ServiceException {
        Consultorio consultorioAux = null;
        consultorioDAO = new ConsultorioDAOImpl();
        consultorioAux = consultorioDAO.guardar(consultorio);
        return consultorioAux;
    }

    /**
     * Actualiza un Consultorio en la base de datos
     * @param consultorio a actualizar
     * @return el consultorio actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Consultorio actualizar(Consultorio consultorio) throws DAOException, ServiceException {
        Consultorio consultorioAux = null;
        consultorioDAO = new ConsultorioDAOImpl();
        consultorioAux = consultorioDAO.actualizar(consultorio);
        return consultorioAux;
    }

    /**
     * Carga todos los consultorios de la base de datos
     * @return una lista de Consultorio
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public List<Consultorio> cargarDatos() throws DAOException, ServiceException {
        List<Consultorio> consultorioList = null;
        consultorioDAO = new ConsultorioDAOImpl();
        consultorioList = consultorioDAO.cargarDatos();
        return consultorioList;
    }

    /**
     * Borra un Consultorio de la base de datos
     * @param idConsultorio del consultorio a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public boolean borrar(int idConsultorio) throws DAOException, ServiceException {
        boolean consultorio = false;
        consultorioDAO = new ConsultorioDAOImpl();
        consultorio = consultorioDAO.borrar(idConsultorio);
        return consultorio;
    }
}
