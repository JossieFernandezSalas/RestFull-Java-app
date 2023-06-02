/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.controller;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Cita;
import cr.una.backend.model.TipoServicio;
import cr.una.backend.service.CitaService;
import cr.una.backend.service.CitaServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/api/citas")
/**
 * Webservice de Cita
 */
public class CitaController {

    private static final Logger logger = LogManager.getLogger(DoctorController.class);
    private CitaService citaService = new CitaServiceImpl();

    /**
     * Constructor default
     * @throws DAOException DAO Exception customizada DAO

     */
    public CitaController() throws DAOException {
    }

    /**
     * Carga las citas de la base de datos
     * @return la lista de citas de la base de datos
     */
    @GetMapping()
    @ResponseBody
    public List<Cita> cargaCitas() {
        List<Cita> citas = null;
        try {
            citas = citaService.cargarCitas();
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return citas;
    }

    /**
     * Carga todos los TipoServicios del API externo
     * @return la lista de TipoServicios del API externa
     */
    @GetMapping("/tiposervicio")
    @ResponseBody
    public List<TipoServicio> cargaTipoServicios() {
        List<TipoServicio> tipoServicios = null;
        try {
            tipoServicios = citaService.cargarTiposServicio();
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return tipoServicios;
    }

    /**
     * Busca una Cita por su codigo
     * @param codigo de la Cita a buscar
     * @return la Cita que haga match con el codigo
     */
    @GetMapping("/{codigo}")
    @ResponseBody
    public Cita buscaPorCodigoDoctor(@PathVariable int codigo){
        Cita cita = null;
        try{
            cita = citaService.buscaPorCodigoCita(codigo);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return cita;
    }

    /**
     * Busca un TipoServicio por el id
     * @param id del TipoServicio a buscar
     * @return el TipoServicio que haga match con el servicio
     */
    @GetMapping("/tiposervicio/{id}")
    @ResponseBody
    public TipoServicio buscaPorServicio(@PathVariable String id){
        TipoServicio tipoServicio = null;
        try{
            tipoServicio = citaService.buscaPorIdServicio(id);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return tipoServicio;
    }



    /**
     * Guarda una Cita nueva en la base de datos
     * @param cita a guardar
     * @return la Cita guardada
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Cita guardar(@RequestBody Cita cita){
        Cita citaAux = null;
        try{
            citaAux = citaService.guardar(cita);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return citaAux;
    }

    /**
     * Borra una Cita en la base de datos
     * @param  idCita de la Cita a borrar
     * @return true si la Cita se borro satisfactoriamente
     */
    @DeleteMapping("{idCita}")
    @ResponseBody
    public boolean borrar(@PathVariable int idCita){
        boolean flag = false;
        try{
            flag = citaService.borrar(idCita);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return flag;
    }

    /**
     * Actualiza una Cita de la base de datos
     * @param cita que se desea actualizar
     * @return la cita actualizada
     */
    @PutMapping()
    @ResponseBody
    public Cita actualizar(@RequestBody Cita cita){
        Cita citaAux = null;
        try{
            citaAux = citaService.actualizar(cita);
        }catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return citaAux;
    }

    /**
     * Calcula el precio final de una cita
     * @param cita sobre la que se calcula el costo final
     * @return el calculo del costo final
     */
    @PutMapping("costofinal")
    @ResponseBody
    public Cita precioFinal(@RequestBody Cita cita){
        Cita citaAux;
        try{
            citaAux = citaService.costoFinal(cita);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return citaAux;
    }

    /**
     * Cambia el estado de confirmacion de una Cita a true
     * @param cita a la cual se le cambia su estado
     * @return la cita con su estado de confirmacion actualizado
     */
    @PutMapping("confirmacion")
    @ResponseBody
    public Cita confirmaCita(@RequestBody Cita cita){
        Cita citaAux;
        try{
            citaAux = citaService.confirmaCita(cita);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return citaAux;
    }
}
