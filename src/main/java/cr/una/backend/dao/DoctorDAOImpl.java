/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Doctor;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementacion Doctor DAO
 */
public class DoctorDAOImpl implements DoctorDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     * @throws DAOException DAO Exception
     */
    public DoctorDAOImpl() throws DAOException {
    }

    /**
     * Encuentra el doctor que hace match con el id
     * @param codigo a buscar
     * @return el doctor encontrado
     * @throws DAOException DAO Exception
     */
    @Override
    public Doctor buscaPorCodigo(int codigo) throws DAOException {
        Doctor doctor;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);
        query.select(root).where(builder.equal(root.get("codigo"), codigo));
        Query q=session.createQuery(query);
        doctor = (Doctor) q.getSingleResult();

        return doctor;
    }

    /**
     * Guarda un nuevo Doctor en la base de datos
     * @param doctor en la Entidad del Doctor
     * @return el paciente actualizado
     * @throws DAOException DAO Exception
     */
    @Override
    public Doctor guardar(Doctor doctor) throws DAOException {
        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();

        return doctor;
    }

    /**
     * Actualiza un doctor en la base de datos
     * @param doctor a actualizar
     * @return el doctor actualizado
     * @throws DAOException DAO Exception
     */
    @Override
    public Doctor actualizar(Doctor doctor) throws DAOException {
        session.beginTransaction();
        session.update(doctor);
        session.flush();
        session.getTransaction().commit();

        return doctor;
    }

    /**
     * Carga todos los doctores de la base de datos
     * @return una lista de doctores
     * @throws DAOException DAO Exception
     */
    @Override
    public List<Doctor> cargaDoctores() throws DAOException {
        List<Doctor> doctorList;

        doctorList = session.createQuery("FROM Doctor", Doctor.class).list();

        return doctorList;
    }

    /**
     * Borra un doctor de la base de datos
     * @param idDoctor del doctor a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    @Override
    public boolean borrar(int idDoctor) throws DAOException {
        boolean isDeleted;
        Doctor doctorAux;

        session.beginTransaction();
        doctorAux = session.get(Doctor.class, idDoctor);
        session.delete(doctorAux);
        isDeleted = true;
        session.getTransaction().commit();
        session.close();

        return isDeleted;
    }
}
