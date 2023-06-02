/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.controller;

import cr.una.backend.exception.DAOException;
import cr.una.backend.exception.ServiceException;
import cr.una.backend.model.Consultorio;
import cr.una.backend.service.ConsultorioService;
import cr.una.backend.service.ConsultorioServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/api/consultorios")
/**
 * Webservice del Consultorio
 */
public class ConsultorioController {
    private static final Logger logger = LogManager.getLogger(ConsultorioController.class);
    private ConsultorioService consultorioService = new ConsultorioServiceImpl();

    /**
     * Carga los consultorios de la base de datos
     * @return la lista de consultorios de la base de datos
     */
    @GetMapping()
    @ResponseBody
    public List<Consultorio> cargaDatos() {
        List<Consultorio> consultorios = null;
        try {
            consultorios = consultorioService.cargarDatos();
        } catch (DAOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return consultorios;
    }

    /**
     * Busca un consultorio por su codigo
     * @param codigo del consultorio a buscar
     * @return el consultorio encontrado
     */
    @GetMapping("/{codigo}")
    @ResponseBody
    public Consultorio buscaPorId(@PathVariable int codigo){
        Consultorio consultorio = null;
        try{
            consultorio = consultorioService.buscaPorId(codigo);
        } catch (DAOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return consultorio;
    }

    /**
     * Guarda un consultorio nuevo en la base de datos
     * @param consultorio a guardar
     * @return el consultorio guardado
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Consultorio guardar(@RequestBody Consultorio consultorio){
        Consultorio consultorioeAux = null;
        try{
            consultorioeAux = consultorioService.guardar(consultorio);
        } catch (DAOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return consultorioeAux;
    }

    /**
     * Borra un consultorio en la base de datos
     * @param idConsultorio del consultorio a borrar
     * @return true si el consultorio se borro satisfactoriamente
     */
    @DeleteMapping("{idConsultorio}")
    @ResponseBody
    public boolean borrar(@PathVariable int idConsultorio){
        boolean flag = false;
        try{
            flag = consultorioService.borrar(idConsultorio);
        } catch (DAOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return flag;
    }

    /**
     * Actualiza un consultorio de la base de datos
     * @param consultorio a actualizar
     * @return el consultorio actualizado
     */
    @PutMapping()
    @ResponseBody
    public Consultorio actualizar(@RequestBody Consultorio consultorio){
        Consultorio consultorioAux = null;
        try{
            consultorioAux = consultorioService.actualizar(consultorio);
        }catch (DAOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", e);
        } catch (ServiceException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", e);
        }
        return consultorioAux;
    }
}
