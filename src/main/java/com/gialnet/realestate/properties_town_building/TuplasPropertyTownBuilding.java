/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.properties_town_building;

/**
 *
 * @author antonio
 */
public class TuplasPropertyTownBuilding {
    private final int id;
    private final int id_town;
    private final String descripcion;
    private final int geopos;

    public int getId() {
        return id;
    }

    public int getId_town() {
        return id_town;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public int getGeopos() {
        return geopos;
    }
    
    
    public static class Builder {
        private final int id;
        private int id_town=1;
        private String descripcion="";
        private int geopos;

        public Builder(int id) {
            this.id = id;
        }
         
        public Builder Id_town(final int id_town) {
            this.id_town=id_town;
            return this;
        }
        public Builder Descripcion(final String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        public Builder Geopos (final int geopos) {
            this.geopos=geopos;
            return this;
        }

        public TuplasPropertyTownBuilding build() {
            
            return new TuplasPropertyTownBuilding(this);
        }
    }
    
    private TuplasPropertyTownBuilding(Builder builder) {
        
        this.id = builder.id;
        this.id_town=builder.id_town;
        this.descripcion= builder.descripcion;
        this.geopos=builder.geopos;
        
    }
    
}
