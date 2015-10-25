/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.forsale;

import java.math.BigDecimal;

/**
 *
 * @author antonio
 */
public class BeanProperty implements java.io.Serializable {
    private int id;
    private int owner;
    private int id_customers_type;
    private String tipo_vivienda;
    private int num_bedrooms;
    private int num_kitchens;
    private int num_bathrooms;
    private int num_toilets;
    private int num_saloons;
    private int garage;
    private int terrace;
    private String views;
    private String zona;
    private BigDecimal price;
    private int meters;
    private String year_built;
    private String reformed;
    private String photos;
    private String keys;
    private int geopos;
    private String direccion;
    private String objeto;
    private String poblacion;
    private String pais_ISO3166;
    private int rol;
    private String carpeta_digitalizacion;
    private String tipo;
    private int id_delegacion;
    private int id_departamento;
    private String remarks;
    private byte[] nota_simple;
    private String estado;
    private String LocalePrice;
    private String other_features;
    private String urbanization;

    public BeanProperty() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getId_customers_type() {
        return id_customers_type;
    }

    public void setId_customers_type(int id_customers_type) {
        this.id_customers_type = id_customers_type;
    }

    public String getTipo_vivienda() {
        return tipo_vivienda;
    }

    public void setTipo_vivienda(String tipo_vivienda) {
        this.tipo_vivienda = tipo_vivienda;
    }

    public int getNum_bedrooms() {
        return num_bedrooms;
    }

    public void setNum_bedrooms(int num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public int getNum_kitchens() {
        return num_kitchens;
    }

    public void setNum_kitchens(int num_kitchens) {
        this.num_kitchens = num_kitchens;
    }

    public int getNum_bathrooms() {
        return num_bathrooms;
    }

    public void setNum_bathrooms(int num_bathrooms) {
        this.num_bathrooms = num_bathrooms;
    }

    public int getNum_toilets() {
        return num_toilets;
    }

    public void setNum_toilets(int num_toilets) {
        this.num_toilets = num_toilets;
    }

    public int getNum_saloons() {
        return num_saloons;
    }

    public void setNum_saloons(int num_saloons) {
        this.num_saloons = num_saloons;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public int getTerrace() {
        return terrace;
    }

    public void setTerrace(int terrace) {
        this.terrace = terrace;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public String getYear_built() {
        return year_built;
    }

    public void setYear_built(String year_built) {
        this.year_built = year_built;
    }

    public String getReformed() {
        return reformed;
    }

    public void setReformed(String reformed) {
        this.reformed = reformed;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public int getGeopos() {
        return geopos;
    }

    public void setGeopos(int geopos) {
        this.geopos = geopos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getPais_ISO3166() {
        return pais_ISO3166;
    }

    public void setPais_ISO3166(String pais_ISO3166) {
        this.pais_ISO3166 = pais_ISO3166;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getCarpeta_digitalizacion() {
        return carpeta_digitalizacion;
    }

    public void setCarpeta_digitalizacion(String carpeta_digitalizacion) {
        this.carpeta_digitalizacion = carpeta_digitalizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_delegacion() {
        return id_delegacion;
    }

    public void setId_delegacion(int id_delegacion) {
        this.id_delegacion = id_delegacion;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public byte[] getNota_simple() {
        return nota_simple;
    }

    public void setNota_simple(byte[] nota_simple) {
        this.nota_simple = nota_simple;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLocalePrice() {
        return LocalePrice;
    }

    public void setLocalePrice(String LocalePrice) {
        this.LocalePrice = LocalePrice;
    }

    public String getOther_features() {
        return other_features;
    }

    public void setOther_features(String other_features) {
        this.other_features = other_features;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    
    
    
    
}
