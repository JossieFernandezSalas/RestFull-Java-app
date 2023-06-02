/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */


package cr.una.backend.dao;

import cr.una.backend.exception.DAOException;
import cr.una.backend.model.Paciente;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Implementacion Paciente DAO
 */
public class PacienteDAOImpl implements PacienteDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     * @throws DAOException DAO Exception
     */
    public PacienteDAOImpl() throws DAOException {
    }

    /**
     * Encuentra el paciente que hace match con el id
     * @param codigo del paciente a buscar
     * @return el paciente encontrado
     * @throws DAOException DAO Exception
     */
    @Override
    public Paciente buscaPorId(int codigo) throws DAOException {
        Paciente paciente;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Paciente> query = builder.createQuery(Paciente.class);
        Root<Paciente> root = query.from(Paciente.class);
        query.select(root).where(builder.equal(root.get("codigo"), codigo));
        Query q=session.createQuery(query);
        paciente= (Paciente) q.getSingleResult();


        return paciente;
    }

    /**
     * Guarda un nuevo Paciente en la base de datos
     * @param paciente a guardar
     * @return el paciente guardado
     * @throws DAOException DAO Exception
     */
    @Override
    public Paciente guardar(Paciente paciente) throws DAOException {
        session.beginTransaction();
        session.save(paciente);
        session.getTransaction().commit();

        return paciente;
    }

    /**
     * Actualiza un paciente en la base de datos
     * @param paciente a actualizar
     * @return el paciente actualizado
     * @throws DAOException DAO Exception
     */
    @Override
    public Paciente actualizar(Paciente paciente) throws DAOException {
        session.beginTransaction();
        session.update(paciente);
        session.flush();
        session.getTransaction().commit();

        return paciente;
    }

    /**
     * Carga todos los pacientes de la base de datos
     * @return una lista de pacientes
     * @throws DAOException DAO Exception
     */
    @Override
    public List<Paciente> cargarDatos() throws DAOException {
        List<Paciente> pacienteList;

        pacienteList = session.createQuery("FROM Paciente", Paciente.class).list();

        return pacienteList;
    }

    /**
     * Borra un paciente de la base de datos
     * @param idPaciente del paciente a borrar
     * @return true si se borra satisfactoriamente
     * @throws DAOException DAO Exception
     */
    @Override
    public boolean borrar(int idPaciente) throws DAOException {
        boolean isDeleted;
        Paciente pacienteAux;

        session.beginTransaction();
        pacienteAux = session.get(Paciente.class, idPaciente);
        session.delete(pacienteAux);
        isDeleted = true;
        session.getTransaction().commit();
        session.close();

        return isDeleted;
    }
}
