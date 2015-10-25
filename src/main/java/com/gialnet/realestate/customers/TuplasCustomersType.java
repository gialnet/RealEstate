/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.customers;

/**
 *
 * @author antonio
 */
public class TuplasCustomersType {
    private final int id;
    private final String descripcion;
    private final String cuenta;
    private final String gasto;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getGasto() {
        return gasto;
    }

    
    
    public static class Builder {
        private final int id;
        private String descripcion;
        private String cuenta;
        private String gasto;

        public Builder(int id) {
            this.id = id;
        }
            
        public Builder Descripcion(final String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder Cuenta(final String cuenta) {
            this.cuenta = cuenta;
            return this;
        }
        
        public Builder Gasto(final String gasto) {
            this.gasto = gasto;
            return this;
        }

        public TuplasCustomersType build() {
            
            return new TuplasCustomersType(this);
        }
    }
    
    private TuplasCustomersType(Builder builder) {
        this.id = builder.id;
        this.descripcion= builder.descripcion;
        this.cuenta=builder.cuenta;
        this.gasto=builder.gasto;

    }
    
}
