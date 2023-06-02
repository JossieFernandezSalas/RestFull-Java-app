/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Cita;
import cr.una.backend.model.TipoServicio;

import java.util.List;

/**
 * Cita Service
 * Maneja la logica para Cita
 */
public interface CitaService {

    /**
     * Calcula el costo final de una cita
     * @param cita sobre la que se calcula el costo final
     * @return la cita con calculo del costo final
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita costoFinal(Cita cita)throws DAOException, ServiceException;

    /**
     * Cambia el estado de una cita
     * @param cita sobre la que se actualiza el estado de confirmacion
     * @return la cita con el estado actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita confirmaCita(Cita cita)throws DAOException, ServiceException;

    /**
     * Encuentra el TipoServicio que hace match con el id
     * @param id de la Cita
     * @return el TipoServicio encontrado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public TipoServicio buscaPorIdServicio (String id) throws DAOException, ServiceException;

    /**
     * Carga todos los TipoServicio de la API externa
     * @return una lista de TipoServicio
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public List<TipoServicio> cargarTiposServicio() throws DAOException, ServiceException;

    /**
     * Guarda una nueva Cita en la base de datos
     * @param cita a guardar
     * @return la Cita actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita guardar(Cita cita) throws DAOException, ServiceException;

    /**
     * Actualiza una Cita en la base de datos
     * @param cita a actualizar
     * @return la cita actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita actualizar(Cita cita) throws DAOException, ServiceException;

    /**
     * Carga todas los citas de la base de datos
     * @return una lista de Cita
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public List<Cita> cargarCitas() throws DAOException, ServiceException;

    /**
     * Encuentra la Cita que hace match con el codigo
     * @param codigo de la cita a buscar
     * @return la cita encontrada
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita buscaPorCodigoCita (int codigo) throws DAOException, ServiceException;

    /**
     * Borra una Cita de la base de datos
     * @param idCita de la cita a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public boolean borrar(int idCita) throws DAOException, ServiceException;


}
