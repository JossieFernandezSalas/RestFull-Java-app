/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.service;

import cr.una.backend.dao.*;
import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.*;

import java.util.List;

/**
 * Implementacion del CitaService
 */
public class CitaServiceImpl implements CitaService{
    CitaDAO citaDAO;
    TipoServicioDAO tipoServicioDAO;
    TipoDoctorDAO tipoDoctorDAO = new TipoDoctorDAOImpl();

    /**
     * Constructor default
     * @throws DAOException DAO Exception customizada DAO
     */
    public CitaServiceImpl() throws DAOException {
    }


    /**
     * Cambia el estado de una cita
     * @param cita sobre la que se actualiza el estado de confirmacion
     * @return la cita con el estado actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita confirmaCita(Cita cita)throws DAOException, ServiceException{
        cita.setConfirmacion(true);
        Cita citaAux = null;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.actualizar(cita);
        return citaAux;
    }

    /**
     * Calcula el costo final de una cita
     * @param cita sobre la que se calcula el costo final
     * @return la cita con calculo del costo final
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita costoFinal(Cita cita)throws DAOException, ServiceException{
        double total = 0;
        double porcentaje = 0;
        double subCosto = 0;
        TipoServicio tipoServicio = null;
        TipoDoctor tipoDoctor = null;
        List<TipoServicio> servicios = this.cargarTiposServicio();
        List<TipoDoctor> doctores = tipoDoctorDAO.cargaTipoDoctores();

        for(int i = 0; i < servicios.size(); i++){
            if(cita.getTipoServicio().equals(servicios.get(i).getId().get$oid()))
                tipoServicio = servicios.get(i);
        }

        for(int i = 0; i < doctores.size(); i++){
            if(cita.getDoctor().getCodigoMedico().equals(doctores.get(i).getCodigoMedico()))
                 tipoDoctor = doctores.get(i);
        }

        if(tipoServicio.getCosto() != 0.0){
            if(cita.getDoctor().isPremium())
                total = tipoServicio.getCosto() + (tipoServicio.getCosto() * 0.10);
            else
                total = tipoServicio.getCosto();
        }else
            {
                boolean flag = cita.getDoctor().isPremium();
            porcentaje = tipoServicio.getCostoPorcentual() / 100;
            if(tipoDoctor.getCodigoMedico().equals("G-1")){
                if(flag){
                    subCosto =  tipoDoctor.getSalario() * porcentaje;
                    total = subCosto + (subCosto * 0.10);
                }else{
                    subCosto =  tipoDoctor.getSalario() * porcentaje;
                    total = subCosto;
                }
            }
            if(tipoDoctor.getCodigoMedico().equals("G-2")){
                if(flag){
                    subCosto =  tipoDoctor.getSalario() * porcentaje;
                    total = subCosto + (subCosto * 0.10);
                }else{
                    subCosto =  tipoDoctor.getSalario() * porcentaje;
                    total = subCosto + (subCosto * 0.10);
                }
            }
        }
        cita.setCostoFinal(total);
        Cita citaAux = null;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.actualizar(cita);
        return citaAux;
    }

    /**
     * Encuentra el TipoServicio que hace match con el id
     * @param id de la Cita
     * @return el TipoServicio encontrado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public TipoServicio buscaPorIdServicio (String id) throws DAOException, ServiceException{
        TipoServicio tipoServicio = null;
        tipoServicioDAO = new TipoServicioDAOImpl();
        tipoServicio = tipoServicioDAO.buscaPorId(id);
        return tipoServicio;
    }

    /**
     * Carga todos los TipoServicio de la API externa
     * @return una lista de TipoServicio
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public List<TipoServicio> cargarTiposServicio() throws DAOException, ServiceException{
        List<TipoServicio> tipoServicio = null;
        tipoServicioDAO = new TipoServicioDAOImpl();
        tipoServicio = tipoServicioDAO.cargarDatos();
        return tipoServicio;
    }

    /**
     * Guarda una nueva Cita en la base de datos
     * @param cita a guardar
     * @return la Cita actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita guardar(Cita cita) throws DAOException, ServiceException{
        Cita citaAux = null;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.guardar(cita);
        return citaAux;
    }

    /**
     * Actualiza una Cita en la base de datos
     * @param cita a actualizar
     * @return la cita actualizado
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita actualizar(Cita cita) throws DAOException, ServiceException{
        Cita citaAux = null;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.actualizar(cita);
        return citaAux;
    }

    /**
     * Carga todas los citas de la base de datos
     * @return una lista de Cita
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public List<Cita> cargarCitas() throws DAOException, ServiceException{
        List<Cita> citaList = null;
        citaDAO = new CitaDAOImpl();
        citaList = citaDAO.cargarDatos();
        return citaList;
    }

    /**
     * Encuentra la Cita que hace match con el codigo
     * @param codigo de la cita a buscar
     * @return la cita encontrada
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public Cita buscaPorCodigoCita (int codigo) throws DAOException, ServiceException{
        Cita citaAux = null;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.buscaPorId(codigo);
        return citaAux;
    }

    /**
     * Borra una Cita de la base de datos
     * @param idCita de la cita a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception customizada DAO
     * @throws ServiceException Exception customizada Service
     */
    public boolean borrar(int idCita) throws DAOException, ServiceException{
        boolean citaAux = false;
        citaDAO = new CitaDAOImpl();
        citaAux = citaDAO.borrar(idCita);
        return citaAux;
    }
}
