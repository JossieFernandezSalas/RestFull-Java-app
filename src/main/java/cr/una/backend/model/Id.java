/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package cr.una.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modelo Id
 */
public class Id {

    @JsonProperty("$oid")
    private String $oid;

    /**
     *Constructor Default
     */
    public Id() {
    }

    /**
     * Constructor con parametros
     * @param $oid id general
     */
    public Id(String $oid) {
        this.$oid = $oid;
    }

    /**
     *Retorna el ID
     * @return $oid
     */
    public String get$oid() {
        return $oid;
    }

    /**
     *Actualiza el ID
     * @param $oid id general
     */
    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

    /**
     * Muestra las propiedades
     * @return  cadena con las propiedades concatenadas
     */
    @Override
    public String toString() {
        return "Id{" + "$oid=" + $oid + '}';
    }
}
