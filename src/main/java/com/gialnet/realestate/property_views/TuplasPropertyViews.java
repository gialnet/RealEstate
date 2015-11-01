/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.property_views;

/**
 *
 * @author antonio
 */
public class TuplasPropertyViews {
    private final int id;
    private final String descripcion;
    

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    public static class Builder {
        private final int id;
        private String descripcion;

        public Builder(int id) {
            this.id = id;
        }
            
        public Builder Descripcion(final String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public TuplasPropertyViews build() {
            
            return new TuplasPropertyViews(this);
        }
    }
    
    private TuplasPropertyViews(Builder builder) {
        this.id = builder.id;
        this.descripcion= builder.descripcion;
    }
    
}
