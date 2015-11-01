/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.properties_town_area;

/**
 *
 * @author antonio
 */
public class TuplasPropertyTownAreas {
    private final int id;
    private final String descripcion;
    private final String pais_ISO3166;
    private final String codpost;

    public String getPais_ISO3166() {
        return pais_ISO3166;
    }

    public String getCodpost() {
        return codpost;
    }
    

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    public static class Builder {
        private final int id;
        private String descripcion;
        private String pais_ISO3166="ES";
        private String codpost="18690";

        public Builder(int id) {
            this.id = id;
        }
            
        public Builder Descripcion(final String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        public Builder Pais_ISO3166(final String pais_ISO3166) {
            this.pais_ISO3166 = pais_ISO3166;
            return this;
        }
        public Builder Codpost(final String codpost) {
            this.codpost = codpost;
            return this;
        }

        public TuplasPropertyTownAreas build() {
            
            return new TuplasPropertyTownAreas(this);
        }
    }
    
    private TuplasPropertyTownAreas(Builder builder) {
        this.id = builder.id;
        this.descripcion= builder.descripcion;
        this.pais_ISO3166=builder.pais_ISO3166;
        this.codpost=builder.codpost;
    }
    
}
