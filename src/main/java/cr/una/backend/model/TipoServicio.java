/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class TipoServicio {

    @JsonProperty("_id")
    private Id id;
    @JsonProperty("servicio")
    private String servicio;
    @JsonProperty("costo-porcentual")
    private double costoPorcentual;
    @JsonProperty("costo")
    private double costo;
    @JsonProperty("codigo-medico")
    private String codigoMedico;

    public TipoServicio() {
    }

    /**
     * Constructor con parametros
     * @param id del tipo de doctor
     * @param servicio tipo de doctor
     * @param costoPorcentual tipo de doctor
     * @param costo tipo de doctor
     * @param codigoMedico tipo de doctor
     */
    public TipoServicio(Id id, String servicio, double costoPorcentual, double costo, String codigoMedico) {
        this.id = id;
        this.servicio = servicio;
        this.costoPorcentual = costoPorcentual;
        this.costo = costo;
        this.codigoMedico = codigoMedico;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "TipoServicio{" +
                "id=" + id +
                ", servicio='" + servicio + '\'' +
                ", costoPorcentual=" + costoPorcentual +
                ", costo=" + costo +
                ", codigoMedico='" + codigoMedico + '\'' +
                '}';
    }

    /**
     * Retorna el id
     * @return id
     */
    public Id getId() {
        return id;
    }

    /**
     * Actualiza el id
     * @param id tipo de doctor
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * Retorna el servicio
     * @return servicio
     */
    public String getServicio() {
        return servicio;
    }

    /**
     * Actualiza el servicio
     * @param servicio tipo de doctor
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     * Retorna el costoPorcentual
     * @return costoPorcentual
     */
    public double getCostoPorcentual() {
        return costoPorcentual;
    }

    /**
     * Actualiza el costoPorcentual
     * @param costoPorcentual tipo de doctor
     */
    public void setCostoPorcentual(double costoPorcentual) {
        this.costoPorcentual = costoPorcentual;
    }

    /**
     * Retorna el costo
     * @return costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Actualiza el costo
     * @param costo tipo de doctor
     */
    public void setCosto(double costo) {
        this.costo = costo;
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
     * @param codigoMedico tipo de doctor
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

}
