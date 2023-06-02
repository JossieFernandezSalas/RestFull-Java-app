/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Doctor;


import java.util.List;

/**
 * Doctor DAO Interface
 */
public interface DoctorDAO {
    /**
     * Encuentra el doctor que hace match con el id
     * @param codigo a buscar
     * @return el doctor encontrado
     * @throws DAOException DAO Exception
     */
    public Doctor buscaPorCodigo (int codigo) throws DAOException;

    /**
     * Guarda un nuevo Doctor en la base de datos
     * @param doctor a guardar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     */
    public Doctor guardar(Doctor doctor) throws DAOException;

    /**
     * Actualiza un doctor en la base de datos
     * @param doctor a actualizar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     */
    public Doctor actualizar(Doctor doctor) throws DAOException;

    /**
     * Carga todos los doctores de la base de datos
     * @return una lista de doctores
     * @throws DAOException DAO Exception
     */
    public List<Doctor> cargaDoctores() throws DAOException;


    /**
     * Borra un doctor de la base de datos
     * @param idDoctor del doctor a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    public boolean borrar(int idDoctor) throws DAOException;
}
