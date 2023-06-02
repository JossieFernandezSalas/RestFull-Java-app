/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="paciente")
/**
 *Entidad Paciente
 */
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private int idPaciente;
    @Column(name = "codigo")
    private int codigo;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Telefono> telefono;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Direccion> direccion;

    //@JsonBackReference(value = "citas")
    //@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL , orphanRemoval = true)
    //private List<Cita> citas;

    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Column(name = "enfermedades")
    private String enfermedades;
    @Column(name = "observaciones")
    private String observaciones;

    /**
     * Constructor Default
     */
    public Paciente() {
    }

    /**
     * Constructor con parametros
     * @param idPaciente del paciente
     * @param codigo del paciente
     * @param telefono del paciente
     * @param nombre del paciente
     * @param direccion del paciente
     * @param fechaNacimiento del paciente
     * @param enfermedades del paciente
     * @param observaciones del paciente
     */
    public Paciente(int idPaciente, int codigo, List<Telefono> telefono, String nombre, List<Direccion> direccion,
                    String fechaNacimiento, String enfermedades, String observaciones) {
        this.idPaciente = idPaciente;
        this.codigo = codigo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.observaciones = observaciones;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "Paciente{" +
                "id_paciente=" + idPaciente +
                ", codigo=" + codigo +
                ", telefono=" + telefono +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", enfermedades='" + enfermedades + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }

    /**
     * Retorna el idPaciente
     * @return idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * Actualiza el idPaciente del paciente
     * @param idPaciente del paciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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
     * @param codigo del paciente
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna el telefono
     * @return telefono
     */
    public List<Telefono> getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el telefono
     * @param telefono del paciente
     */
    public void setTelefono(List<Telefono> telefono) {
        this.telefono = telefono;
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
     * @param nombre del paciente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el direccion
     * @return direccion
     */
    public List<Direccion> getDireccion() {
        return direccion;
    }

    /**
     * Actualiza el direccion
     * @param direccion del paciente
     */
    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna la fechaNacimiento
     * @return fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Actualiza la fechaNacimiento
     * @param fechaNacimiento del paciente
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Retorna las enfermedades
     * @return enfermedades
     */
    public String getEnfermedades() {
        return enfermedades;
    }

    /**
     * Actualiza las enfermedades
     * @param enfermedades del paciente
     */
    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    /**
     * Retorna las observaciones
     * @return observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Actualiza las observaciones
     * @param observaciones del paciente
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
