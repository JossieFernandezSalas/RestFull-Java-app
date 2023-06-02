/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table(name = "cita")
/**
 * Entidad Cita
 */
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    @Column(name = "codigo")
    private int codigo;
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "confirmacion")
    private boolean confirmacion;

    @Column(name = "costo_final")
    private double costoFinal;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_consultorio")
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    private String tipoServicio;

    /**
     * Constructor default
     */
    public Cita() {
    }

    /**
     * Constructor con parametros
     * @param idCita de la cita
     * @param codigo de la cita
     * @param fecha de la cita
     * @param hora de la cita
     * @param confirmacion de la cita
     * @param costoFinal de la cita
     * @param paciente de la cita
     * @param consultorio de la cita
     * @param doctor de la cita
     * @param tipoServicio de la cita
     */
    public Cita(int idCita, int codigo, Date fecha, String hora, boolean confirmacion, double costoFinal,
                Paciente paciente, Consultorio consultorio, Doctor doctor, String tipoServicio) {
        this.idCita = idCita;
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.confirmacion = confirmacion;
        this.costoFinal = costoFinal;
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.tipoServicio = tipoServicio;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "Cita{" +
                "id_cita=" + idCita +
                ", codigo=" + codigo +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", confirmacion=" + confirmacion +
                ", costoFinal=" + costoFinal +
                ", paciente=" + paciente +
                ", consultorio=" + consultorio +
                ", doctor=" + doctor +
                ", tipoServicio=" + tipoServicio +
                '}';
    }

    /**
     * Retorna el idCita
     * @return idCita
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * Actualiza el idCita
     * @param idCita identificacion de la cita
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
     * @param codigo de la cita
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna la fecha
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Actualiza la fecha
     * @param fecha de la cita
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna la hora
     * @return hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Actualiza la hora
     * @param hora de la cita
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Retorna la contfirmacion
     * @return true si esta confirmado
     */
    public boolean isConfirmacion() {
        return confirmacion;
    }

    /**
     * Actualiza la confirmacion
     * @param confirmacion estado de la cita
     */
    public void setConfirmacion(boolean confirmacion) {
        this.confirmacion = confirmacion;
    }

    /**
     * Retorna el costoFinal
     * @return costoFinal
     */
    public double getCostoFinal() {
        return costoFinal;
    }

    /**
     * Actualiza el costoFinal
     * @param costoFinal de la cita
     */
    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
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
     * @param paciente de la cita
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna el consultorio
     * @return consultorio
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }

    /**
     * Actualiza el consultorio
     * @param consultorio de la cita
     */
    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    /**
     * Retorna el doctor
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Actualiza el doctor
     * @param doctor de la cita
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Retorna el tipoServicio
     * @return tipoServicio
     */
    public String getTipoServicio() {
        return tipoServicio;
    }

    /**
     * Actualiza el tipoServicio
     * @param tipoServicio de la cita
     */
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
