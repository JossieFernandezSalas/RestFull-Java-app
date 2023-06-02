/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.List;

@Entity
@Table(name = "doctor")
/**
 * Entidad Doctor
 */
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private int idDoctor;
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "premium")
    private boolean premium;
    @Column(name = "codigoMedico")
    private String codigoMedico;

    /*@JsonBackReference(value = "citas")
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Cita> citas;*/

    /**
     * Constructor Default
     */
    public Doctor() {
    }

    /**
     * Constructor con parametros
     * @param idDoctor del doctor
     * @param codigo del doctor
     * @param nombre del doctor
     * @param premium del doctor
     * @param codigoMedico del doctor
     */
    public Doctor(int idDoctor, int codigo, String nombre, boolean premium, String codigoMedico) {
        this.idDoctor = idDoctor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.premium = premium;
        this.codigoMedico = codigoMedico;
    }

    /**
     * Retorna el idDoctor
     * @return idDoctor
     */
    public int getIdDoctor() {
        return idDoctor;
    }

    /**
     * Actualiza el idDoctor
     * @param idDoctor del doctor
     */
    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    /**
     * Retorna el codigo
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Actualiza el codigo
     * @param codigo del doctor
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre
     * @param nombre del doctor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna true es premium
     * @return premium
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Actualiza el estado premium
     * @param premium estado del doctor
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * Retorna el codigoMedico
     * @return codigoMedico
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }

    /**
     * Actualiza el codigoMedico
     * @param codigoMedico del doctor
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
}
