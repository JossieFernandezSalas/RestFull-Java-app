/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name = "direccion")
/**
 * Modelo Direccion
 */
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int idDireccion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "informacion")
    private String informacion;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    /**
     * Constructor Default
     */
    public Direccion() {
    }

    /**
     * Constructor con parametros
     * @param idDireccion de la direccion
     * @param tipo de la direccion
     * @param informacion de la direccion
     * @param paciente de la direccion
     */
    public Direccion(int idDireccion, String tipo, String informacion, Paciente paciente) {
        this.idDireccion = idDireccion;
        this.tipo = tipo;
        this.informacion = informacion;
        this.paciente = paciente;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "Direccion{" +
                "id_direccion=" + idDireccion +
                ", tipo='" + tipo + '\'' +
                ", informacion='" + informacion + '\'' +
                '}';
    }

    /**
     * Retorna el idDireccion del consultorio
     * @return idDireccion
     */
    public int getIddireccion() {
        return idDireccion;
    }

    /**
     * Actualiza el idDreccion
     * @param idDireccion de la direccion
     */
    public void setId_direccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    /**
     * Retorna el tipo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Actualiza el tipo
     * @param tipo de la direccion
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna la informacion
     * @return informacion
     */
    public String getInformacion() {
        return informacion;
    }

    /**
     * Actualiza la informacion
     * @param informacion de la direccion
     */
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    /**
     * Retorna el paciente
     * @return paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Actualiza el paciente
     * @param paciente de la direccion
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
