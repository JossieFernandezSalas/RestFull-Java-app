/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Doctor;
import cr.una.backend.model.TipoDoctor;

import java.util.List;

/**
 * Doctor Service
 * Maneja la logica para Doctor
 */
public interface DoctorService {

    /**
     * Encuentra el doctor que hace match con el codigo
     * @param codigo del doctor a buscar
     * @return el doctor encontrado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Doctor buscaPorCodigoDoctor(int codigo) throws DAOException, ServiceException;

    /**
     * Encuentra el tipoDoctor que hace match con el codigo
     * @param codigo del TipoDoctor
     * @return el TipoDoctor encontrado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public List<TipoDoctor> buscaPorCodigoTipoDoctor(String codigo) throws DAOException, ServiceException;

    /**
     * Guarda un nuevo Doctor en la base de datos
     * @param doctor a guardar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Doctor guardar(Doctor doctor) throws DAOException, ServiceException;

    /**
     * Actualiza un doctor en la base de datos
     * @param doctor a actualizar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public Doctor actualizar(Doctor doctor) throws DAOException, ServiceException;

    /**
     * Carga todos los doctores de la base de datos
     * @return una lista de doctores
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    public List<Doctor> cargarDoctores() throws DAOException, ServiceException;


    /**
     * Carga todos los TipoDoctor de la base de datos
     * @return una lista de TipoDoctores
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     * */
    public List<TipoDoctor> cargarTipoDoctores() throws DAOException, ServiceException;

    /**
     * Borra un doctor de la base de datos
     * @param idDoctor del doctor a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service 
     */
    public boolean borrar(int idDoctor) throws DAOException, ServiceException;
}
