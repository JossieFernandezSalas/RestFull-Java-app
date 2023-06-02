/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.TipoServicio;

import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

/**
 * Implementacion TipoServicio DAO
 */
public class TipoServicioDAOImpl implements TipoServicioDAO{
    private static final String REST_URI = "https://api.mlab.com/api/1/databases/colegio-medicos-cr/collections/servicios?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    /**
     * Encuentra el TipoServicio que hace match con el codigoMedico
     * @param id del TipoServicio a buscar
     * @return el TipoServicio encontrado
     * @throws DAOException DAO Exception
     */
    public TipoServicio buscaPorId (String id) throws DAOException{
        TipoServicio tipoServicio= null;
        String query = "{\"_id\": {\"$oid\":\"5ec5793fe7179a6b6363022a\"}}";
        String URL = REST_URI + "&q={query}";
        RestTemplate restTemplate = new RestTemplate();
        tipoServicio = restTemplate.getForObject(URL, TipoServicio.class, query);

        return tipoServicio;
    }
    /**
     * Carga todos los TipoServicio de la API externa
     * @return una lista de TipoServicio
     * @throws DAOException DAO Exception
     */
    public List<TipoServicio> cargarDatos() throws DAOException{

        List<TipoServicio> tipoServicioList = null;
        RestTemplate restTemplate = new RestTemplate();
        tipoServicioList = Arrays.asList(restTemplate.getForObject(REST_URI, TipoServicio[].class));

        return tipoServicioList;
    }

}
