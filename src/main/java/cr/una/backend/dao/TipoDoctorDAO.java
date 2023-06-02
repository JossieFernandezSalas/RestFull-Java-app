/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.TipoDoctor;
import java.util.List;

/**
 * TipoDoctor DAO Interface
 */
public interface TipoDoctorDAO {

    /**
     * Encuentra el TipoDoctor que hace match con el id del API externo
     * @param codigoMedico del TipoDoctor a buscar
     * @return el TipoDoctor encontrado
     * @throws DAOException DAO Exception
     */
    public List<TipoDoctor> buscaPorCodigo (String codigoMedico) throws DAOException;

    /**
     * Carga todos los TipoDoctores del API externo
     * @return una lista de TipoDoctores
     * @throws DAOException DAO Exception
     */
    public List<TipoDoctor> cargaTipoDoctores() throws DAOException;

}
