/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.controller;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Doctor;
import cr.una.backend.model.TipoDoctor;
import cr.una.backend.service.DoctorService;
import cr.una.backend.service.DoctorServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/api/doctores")
/**
 * Webservice del Doctor
 */
public class DoctorController {

    private static final Logger logger = LogManager.getLogger(DoctorController.class);
    private DoctorService doctorService = new DoctorServiceImpl();

    /**
     * Carga los doctores de la base de datos
     * @return la lista de doctores de la base de datos
     */
    @GetMapping()
    @ResponseBody
    public List<Doctor> cargaDoctores() {
        List<Doctor> doctores = null;
        try {
            doctores = doctorService.cargarDoctores();
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return doctores;
    }

    /**
     * Carga los tipo de doctores del API externo
     * @return la lista de tipo de doctores del API externa
     */
    @GetMapping("/tipodoctor")
    @ResponseBody
    public List<TipoDoctor> cargaTipoDoctores() {
        List<TipoDoctor> tipodoctores = null;
        try {
            tipodoctores = doctorService.cargarTipoDoctores();
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return tipodoctores;
    }

    /**
     * Busca un doctor por su codigo
     * @param codigo del doctor a buscar
     * @return el doctor encontrado
     */
    @GetMapping("/{codigo}")
    @ResponseBody
    public Doctor buscaPorCodigoDoctor(@PathVariable int codigo){
        Doctor doctor = null;
        try{
            doctor = doctorService.buscaPorCodigoDoctor(codigo);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return doctor;
    }

    /**
     * Busca un tipo de doctor por su codigo medico
     * @param codigomedico del tipo de doctor a buscar
     * @return el tipo doctor que haga match con el codigo
     */
    @GetMapping("/tipodoctor/{codigomedico}")
    @ResponseBody
    public List<TipoDoctor> buscaPorCodigoTipoDoctor(@PathVariable String codigomedico){
        List<TipoDoctor> tipoDoctor = null;
        try{
            tipoDoctor = doctorService.buscaPorCodigoTipoDoctor(codigomedico);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return tipoDoctor;
    }

    /**
     * Guarda un doctor nuevo en la base de datos
     * @param doctor que se desea guardar
     * @return el doctor guardado
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Doctor guardar(@RequestBody Doctor doctor){
        Doctor doctorAux = null;
        try{
            doctorAux = doctorService.guardar(doctor);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return doctorAux;
    }

    /**
     * Borra un doctor en la base de datos
     * @param idDoctor del doctor a buscar
     * @return true si el doctor se borro satisfactoriamente
     */
    @DeleteMapping("{id_doctor}")
    @ResponseBody
    public boolean borrar(@PathVariable int idDoctor){
        boolean flag = false;
        try{
            flag = doctorService.borrar(idDoctor);
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
     * Actualiza un doctor de la base de datos
     * @param doctor a actualizar
     * @return el doctor actualizado
     */
    @PutMapping()
    @ResponseBody
    public Doctor actualizar(@RequestBody Doctor doctor){
        Doctor doctorAux = null;
        try{
            doctorAux = doctorService.actualizar(doctor);
        }catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return doctorAux;
    }
}
