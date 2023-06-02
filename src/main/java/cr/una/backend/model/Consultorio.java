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
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consultorio")
/**
 * Entidad Consultorio
 */
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultorio")
    private int idConsultorio;
    @Column(name = "nombre")
    private String nombre;

    /*@JsonBackReference(value = "citas")
    @OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Cita> citas;*/

    @Column(name = "telefono")
    private int telefono;
    @Column(name = "dias")
    private String dias;
    @Column(name = "hora")
    private String hora;
    @Column(name = "codigo")
    private int codigo;

    /**
     * Constructor default
     */
    public Consultorio() {
    }

    /**
     * Constructor con parametros
     * @param idConsultorio del consultorio
     * @param nombre del consultorio
     * @param telefono del consultorio
     * @param dias del consultorio
     * @param hora del consultorio
     * @param codigo del consultorio
     */
    public Consultorio(int idConsultorio, String nombre, int telefono, String dias, String hora, int codigo) {
        this.idConsultorio = idConsultorio;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dias = dias;
        this.hora = hora;
        this.codigo = codigo;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "Consultorio{" +
                "id_consultorio=" + idConsultorio +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", dias='" + dias + '\'' +
                ", hora='" + hora + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    /**
     * Retorna el idConsultorio
     * @return el idConsultorio
     */
    public int getIdConsultorio() {
        return idConsultorio;
    }

    /**
     * Actualiza el idConsultorio
     * @param idConsultorio del consultorio
     */
    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    /**
     * Retorna el nombre del consultorio
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre del consultorio
     * @param nombre del consultorio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el telefono
     * @return telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Actualiza el telefono del consultorio
     * @param telefono del consultorio
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna los dias del consultorio
     * @return dias
     */
    public String getDias() {
        return dias;
    }

    /**
     * Actualiza los dias del consultorio
     * @param dias del consultorio
     */
    public void setDias(String dias) {
        this.dias = dias;
    }

    /**
     * Retorna la hora del consultorio
     * @return hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Actualiza la hora del consultorio
     * @param hora del consultorio
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Retorna el codigo del consultorio
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Atualiza el codigo del consultorio
     * @param codigo del consultorio
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
