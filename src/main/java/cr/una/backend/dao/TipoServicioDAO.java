/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.TipoServicio;

import java.util.List;

/**
 * TipoServicio DAO Interface
 */
public interface TipoServicioDAO {

    /**
     * Encuentra el TipoServicio que hace match con el codigoMedico
     * @param id del TipoServicio a buscar
     * @return el TipoServicio encontrado
     * @throws DAOException DAO Exception
     */
    public TipoServicio buscaPorId (String id) throws DAOException;

    /**
     * Carga todos los TipoServicio de la API externa
     * @return una lista de TipoServicio
     * @throws DAOException DAO Exception
     */
    public List<TipoServicio> cargarDatos() throws DAOException;

}
