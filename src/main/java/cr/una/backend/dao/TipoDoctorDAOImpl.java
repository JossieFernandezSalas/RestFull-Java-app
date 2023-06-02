/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.TipoDoctor;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * Implementacion TipoDoctor DAO
 */
public class TipoDoctorDAOImpl implements  TipoDoctorDAO{

    private static final String REST_URI = "https://api.mlab.com/api/1/databases/colegio-medicos-cr/collections/tipomedicos?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    /**
     * Default constructor
     * @throws DAOException DAO Exception
     */
    public TipoDoctorDAOImpl() throws DAOException {
    }

    /**
     * Encuentra el TipoDoctor que hace match con el id del API externo
     * @param codigo del TipoDoctor a buscar
     * @return el TipoDoctor encontrado
     * @throws DAOException DAO Exception
     */
    @Override
    public List<TipoDoctor> buscaPorCodigo(String codigo) throws DAOException {
        List<TipoDoctor> tipoDoctorList = null;
        String query = "{\"codigo-medico\": \"" + codigo + "\"}";
        String URL = REST_URI + "&q={query}";
        RestTemplate restTemplate = new RestTemplate();
        tipoDoctorList = Arrays.asList(restTemplate.getForObject(URL, TipoDoctor[].class, query));

        return tipoDoctorList;
    }

    /**
     * Carga todos los TipoDoctores del API externo
     * @return una lista de TipoDoctores
     * @throws DAOException DAO Exception
     */
    @Override
    public List<TipoDoctor> cargaTipoDoctores() throws DAOException {

        List<TipoDoctor> tipoDoctorList = null;
        RestTemplate restTemplate = new RestTemplate();
        tipoDoctorList = Arrays.asList(restTemplate.getForObject(REST_URI, TipoDoctor[].class));

        return tipoDoctorList;
    }
}
