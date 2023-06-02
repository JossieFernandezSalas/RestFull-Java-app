/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Modelo TipoDoctor
 */
public class TipoDoctor {
    @JsonProperty("_id")
    private Id id;
    @JsonProperty("salario")
    private double salario;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("codigo-medico")
    private String codigoMedico;
    @JsonProperty("tipo")
    private String tipo;

    /**
     * Constructor Default
     */
    public TipoDoctor() {
    }

    /**
     *
     * @param id del tipo de doctor
     * @param salario del tipo de doctor
     * @param moneda del tipo de doctor
     * @param tipo del tipo de doctor
     * @param codigoMedico del tipo de doctor
     */
    public TipoDoctor(Id id, double salario, String moneda, String tipo, String codigoMedico) {
        this.id = id;
        this.salario = salario;
        this.moneda = moneda;
        this.codigoMedico = codigoMedico;
        this.tipo = tipo;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "TipoDoctor{" +
                "id=" + id +
                "tipo=" + tipo +
                ", salario=" + salario +
                ", moneda='" + moneda + '\'' +
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
     * @param id del tipo de doctor
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     * Retorna el salario
     * @return salario
     */
    public double getSalario() {
        return salario;
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
     * @param tipo del tipo de doctor
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Actualiza el salario
     * @param salario del tipo de doctor
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Retorna la moneda
     * @return moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Actualiza la moneda
     * @param moneda del tipo de doctor
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Retorna el codigoMedico
     * @return codigoMedico
     */
    public String getCodigoMedico() {
        return codigoMedico;
    }

    /**
     * Actualiza el codigo del medico
     * @param codigoMedico del tipo de doctor
     */
    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
}
