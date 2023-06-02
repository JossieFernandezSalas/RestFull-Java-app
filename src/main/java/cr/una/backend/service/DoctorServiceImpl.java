/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.dao.*;
import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Doctor;
import cr.una.backend.model.TipoDoctor;

import java.util.List;

/**
 * Implementacion del DoctorService
 */
public class DoctorServiceImpl implements DoctorService {
    private DoctorDAO doctorDAO;
    private TipoDoctorDAO tipoDoctorDAO;

    /**
     * Encuentra el doctor que hace match con el codigo
     * @param codigo del doctor a buscar
     * @return el doctor encontrado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Doctor buscaPorCodigoDoctor(int codigo) throws DAOException, ServiceException {
        Doctor doctor = null;
        doctorDAO = new DoctorDAOImpl();
        doctor = doctorDAO.buscaPorCodigo(codigo);
        return doctor;
    }

    /**
     * Encuentra el tipoDoctor que hace match con el codigo
     * @param codigo del TipoDoctor
     * @return el TipoDoctor encontrado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public List<TipoDoctor> buscaPorCodigoTipoDoctor(String codigo) throws DAOException, ServiceException{
        List<TipoDoctor> tipoDoctor = null;
        tipoDoctorDAO = new TipoDoctorDAOImpl();
        tipoDoctor = tipoDoctorDAO.buscaPorCodigo(codigo);
        return tipoDoctor;    }

    /**
     * Guarda un nuevo Doctor en la base de datos
     * @param doctor a guardar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Doctor guardar(Doctor doctor) throws DAOException, ServiceException {
        Doctor doctorAux = null;
        doctorDAO = new DoctorDAOImpl();
        doctorAux = doctorDAO.guardar(doctor);
        return doctorAux;
    }

    /**
     * Actualiza un doctor en la base de datos
     * @param doctor a actualizar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Doctor actualizar(Doctor doctor) throws DAOException, ServiceException {
        Doctor doctorAux = null;
        doctorDAO = new DoctorDAOImpl();
        doctorAux = doctorDAO.actualizar(doctor);
        return doctorAux;
    }

    /**
     * Carga todos los doctores de la base de datos
     * @return una lista de doctores
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public List<Doctor> cargarDoctores() throws DAOException, ServiceException {
        List<Doctor> doctorList = null;
        doctorDAO = new DoctorDAOImpl();
        doctorList = doctorDAO.cargaDoctores();
        return doctorList;
    }

    /**
     * Carga todos los TipoDoctor de la base de datos
     * @return una lista de TipoDoctores
     * @throws DAOException DAO Exception
     */
    public List<TipoDoctor> cargarTipoDoctores() throws DAOException, ServiceException{
        List<TipoDoctor> tipoDoctorList = null;
        tipoDoctorDAO = new TipoDoctorDAOImpl();
        tipoDoctorList = tipoDoctorDAO.cargaTipoDoctores();
        return tipoDoctorList;
    }

    /**
     * Borra un doctor de la base de datos
     * @param idDoctor del doctor a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public boolean borrar(int idDoctor) throws DAOException, ServiceException {
        boolean doctorAux = false;
        doctorDAO = new DoctorDAOImpl();
        doctorAux = doctorDAO.borrar(idDoctor);
        return doctorAux;
    }
}
