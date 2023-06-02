/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.controller;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Paciente;
import cr.una.backend.service.PacienteService;
import cr.una.backend.service.PacienteServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/api/pacientes")
/**
 * Webservice del Paciente
 */
public class PacienteController {
    private static final Logger logger = LogManager.getLogger(PacienteController.class);
    private PacienteService pacienteService = new PacienteServiceImpl();

    /**
     * Carga los pacientes de la base de datos
     * @return la lista de pacientes de la base de datos
     */
    @GetMapping()
    @ResponseBody
    public List<Paciente> cargaDatos() {
        List<Paciente> pacientes = null;
        try {
            pacientes = pacienteService.cargarDatos();
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return pacientes;
    }

    /**
     * Busca un paciente por su codigo
     * @param codigo del paciente a buscar
     * @return el paciente encontrado
     */
    @GetMapping("/{codigo}")
    @ResponseBody
    public Paciente buscaPorId(@PathVariable int codigo){
        Paciente paciente = null;
        try{
            paciente = pacienteService.buscaPorId(codigo);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return paciente;
    }

    /**
     * Guarda un paciente nuevo en la base de datos
     * @param paciente a guardar
     * @return el paciente guardado
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Paciente guardar(@RequestBody Paciente paciente){
        Paciente pacienteAux = null;
        try{
            pacienteAux = pacienteService.guardar(paciente);
        } catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return pacienteAux;
    }

    /**
     * Borra un paciente en la base de datos
     * @param idPaciente del paciente que se desea borrar
     * @return true si el paciente se borro satisfactoriamente
     */
    @DeleteMapping("{id_paciente}")
    @ResponseBody
    public boolean borrar(@PathVariable int idPaciente){
        boolean flag = false;
        try{
            flag = pacienteService.borrar(idPaciente);
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
     * Actualiza un paciente de la base de datos
     * @param paciente a actualizar
     * @return el paciente actualizado
     */
    @PutMapping()
    @ResponseBody
    public Paciente actualizar(@RequestBody Paciente paciente){
        Paciente pacienteAux = null;
        try{
            pacienteAux = pacienteService.actualizar(paciente);
        }catch (DAOException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            logger.error(e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return pacienteAux;
    }


}