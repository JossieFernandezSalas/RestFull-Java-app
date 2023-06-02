/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Consultorio;
import cr.una.backend.model.Paciente;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementacion Consultorio DAO
 */
public class ConsultorioDAOImpl implements ConsultorioDAO{

    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     * @throws DAOException DAO Exception
     */
    public ConsultorioDAOImpl() throws DAOException {
    }

    /**
     * Encuentra el Consultorio que hace match con el codigo
     * @param codigo del Consultorio a buscar
     * @return el Consultorio encontrada
     * @throws DAOException DAO Exception
     */
    @Override
    public Consultorio buscaPorId(int codigo) throws DAOException {
        Consultorio consultorio;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Consultorio> query = builder.createQuery(Consultorio.class);
        Root<Consultorio> root = query.from(Consultorio.class);
        query.select(root).where(builder.equal(root.get("codigo"), codigo));
        Query q=session.createQuery(query);
        consultorio= (Consultorio) q.getSingleResult();

        return consultorio;
    }

    /**
     * Guarda un nuevo Consultorio en la base de datos
     * @param consultorio a guardar
     * @return el Consultorio guardado
     * @throws DAOException DAO Exception
     */
    @Override
    public Consultorio guardar(Consultorio consultorio) throws DAOException {
        session.beginTransaction();
        session.save(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }

    /**
     * Actualiza un Consultorio en la base de datos
     * @param consultorio a actualizar
     * @return el Consultorio actualizado
     * @throws DAOException DAO Exception
     */
    @Override
    public Consultorio actualizar(Consultorio consultorio) throws DAOException {
        session.beginTransaction();
        session.update(consultorio);
        session.getTransaction().commit();

        return consultorio;
    }

    /**
     * Carga todos los consultorios de la base de datos
     * @return una lista de consultorios
     * @throws DAOException DAO Exception
     */
    @Override
    public List<Consultorio> cargarDatos() throws DAOException {
        List<Consultorio> consultorioList;

        consultorioList = session.createQuery("FROM Consultorio", Consultorio.class).list();

        return consultorioList;
    }

    /**
     * Borra un Consultorio de la base de datos
     * @param idConsultorio es la identificacion del Consultorio
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    @Override
    public boolean borrar(int idConsultorio) throws DAOException {
        boolean isDeleted;
        Consultorio consultorio;

        session.beginTransaction();
        consultorio = session.get(Consultorio.class, idConsultorio);
        session.delete(consultorio);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}
