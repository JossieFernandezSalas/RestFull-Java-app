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
@Table(name = "telefono")
/**
 * Modelo Telefono
 */
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefono")
    private int idTelefono;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "numero")
    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    /**
     * Constructor Default
     */
    public Telefono() {
    }

    /**
     * Constructor con parametros
     * @param idTelefono del telefono
     * @param tipo del telefono
     * @param numero del telefono
     * @param paciente del telefono
     */
    public Telefono(int idTelefono, String tipo, int numero, Paciente paciente) {
        this.idTelefono = idTelefono;
        this.tipo = tipo;
        this.numero = numero;
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "idTelefono=" + idTelefono +
                ", tipo='" + tipo + '\'' +
                ", numero=" + numero +
        //        ", paciente=" + paciente +
                '}';
    }

    /**
     * Retorna el idTelefono
     * @return idTelefono
     */
    public int getIdTelefono() {
        return idTelefono;
    }

    /**
     * Actualiza el idTelefono
     * @param idTelefono del telefono
     */
    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
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
     * @param tipo del telefono
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el numero
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Actualiza el numero
     * @param numero del telefono
     */
    public void setNumero(int numero) {
        this.numero = numero;
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
     * @param paciente del telefono
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
