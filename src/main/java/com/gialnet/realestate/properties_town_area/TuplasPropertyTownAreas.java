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
    private final int id_town;
    private final String descripcion;    

    public int getId() {
        return id;
    }

    public int getId_town() {
        return id_town;
    }

    
    public String getDescripcion() {
        return descripcion;
    }
    
    
    public static class Builder {
        private final int id;
        private int id_town=1;
        private String descripcion="";
        

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

        public TuplasPropertyTownAreas build() {
            
            return new TuplasPropertyTownAreas(this);
        }
    }
    
    private TuplasPropertyTownAreas(Builder builder) {
        
        this.id = builder.id;
        this.id_town=builder.id_town;
        this.descripcion= builder.descripcion;
        
    }
    
}
