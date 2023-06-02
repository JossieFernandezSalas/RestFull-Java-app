/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Cita;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementacion Cita DAO
 */
public class CitaDAOImpl implements CitaDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();


    /**
     * Constructor default
     * @throws DAOException Excepcion customizada DAO
     */
    public CitaDAOImpl() throws DAOException {
    }

    /**
     * Encuentra la Cita que hace match con el codigo
     * @param codigo de la Cita a buscar
     * @return la Cita encontrada
     * @throws DAOException Exception  customizada DAO
     */
    public Cita buscaPorId (int codigo) throws DAOException{
        Cita cita;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cita> query = builder.createQuery(Cita.class);
        Root<Cita> root = query.from(Cita.class);
        query.select(root).where(builder.equal(root.get("codigo"), codigo));
        Query q=session.createQuery(query);
        cita = (Cita) q.getSingleResult();

        return cita;
    }

    /**
     * Guarda una nueva Cia en la base de datos
     * @param cita a guardar
     * @return la Cita actualizado
     * @throws DAOException  Exception Excepcion customizada DAO
     */
    public Cita guardar(Cita cita) throws DAOException{
        session.beginTransaction();
        session.save(cita);
        session.getTransaction().commit();

        return cita;
    }

    /**
     * Actualiza una Cita en la base de datos
     * @param cita a actualizar
     * @return la Entidad del Cita actualizado
     * @throws DAOException  Exception customizada DAO
     */
    public Cita actualizar(Cita cita) throws DAOException{
        session.beginTransaction();
        session.update(cita);
        session.getTransaction().commit();

        return cita;
    }

    /**
     * Carga todas los citas de la base de datos
     * @return una lista de Citas
     * @throws DAOException  Exception customizada DAO
     */
    public List<Cita> cargarDatos() throws DAOException{
        List<Cita> citaList;

        citaList = session.createQuery("FROM Cita", Cita.class).list();

        return citaList;
    }

    /**
     * Borra una Cita de la base de datos
     * @param idCita de la Cita borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException  Exception customizada DAO
     */
    public boolean borrar(int idCita) throws DAOException{
        boolean isDeleted;
        Cita cita;

        session.beginTransaction();
        cita = session.get(Cita.class, idCita);
        session.delete(cita);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
