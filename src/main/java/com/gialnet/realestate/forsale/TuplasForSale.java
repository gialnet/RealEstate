/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gialnet.realestate.forsale;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Usuario
 */
public class TuplasForSale {
    private final int id;
    private final int owner;
    private final int id_customers_type;
    private final String tipo_vivienda;
    private final int num_bedrooms;
    private final int num_kitchens;
    private final int num_bathrooms;
    private final int num_toilets;
    private final int num_saloons;
    private final int garage;
    private final int terrace;
    private final String views;
    private final String zona;
    private final BigDecimal price;
    private final int meters;
    private final String year_built;
    private final String reformed;
    private final String photos;
    private final String keys;
    private final int geopos;
    private final String direccion;
    private final String objeto;
    private final String poblacion;
    private final String pais_ISO3166;
    private final int rol;
    private final String carpeta_digitalizacion;
    private final String tipo;
    private final int id_delegacion;
    private final int id_departamento;
    private final String remarks;
    private final byte[] nota_simple;
    private final String estado;
    private final String LocalePrice;
    private final String other_features;
    private final String urbanization;

    public int getId() {
        return id;
    }
    
    public int getOwner() {
        return owner;
    }

    public int getId_customers_type() {
        return id_customers_type;
    }

    public String getTipo_vivienda() {
        return tipo_vivienda;
    }

    public int getNum_bedrooms() {
        return num_bedrooms;
    }

    public int getNum_kitchens() {
        return num_kitchens;
    }

    public int getNum_bathroom() {
        return num_bathrooms;
    }

    public int getNum_toilets() {
        return num_toilets;
    }

    public int getNum_saloons() {
        return num_saloons;
    }

    public int getGarage() {
        return garage;
    }

    public int getTerrace() {
        return terrace;
    }

    public String getViews() {
        return views;
    }

    public String getZona() {
        return zona;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMeters() {
        return meters;
    }

    public String getPhotos() {
        return photos;
    }
    
    public String getYear_built() {
        return year_built;
    }
    
    public String getReformed() {
        return reformed;
    }

    public String getKeys() {
        return keys;
    }
    
    public int getGeopos() {
        return geopos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getObjeto() {
        return objeto;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public String getPais_ISO3166() {
        return pais_ISO3166;
    }

    public int getRol() {
        return rol;
    }

    public String getCarpeta_digitalizacion() {
        return carpeta_digitalizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId_delegacion() {
        return id_delegacion;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public String getRemarks() {
        return remarks;
    }

    public byte[] getNota_simple() {
        return nota_simple;
    }

    public String getEstado() {
        return estado;
    }
    
    public String getLocalePrice() {
        return LocalePrice;
    }
    
    public String getOther_features() {
        return other_features;
    }
    
    public String getUrbanization() {
        return urbanization;
    }
    
    public static class Builder {
        private final int id;
        private int owner=0;
        private int id_customers_type=1;
        private String tipo_vivienda="Apartamento";
        private int num_bedrooms=1;
        private int num_kitchens=1;
        private int num_bathrooms=1;
        private int num_toilets=0;
        private int num_saloons=1;
        private int garage=0;
        private int terrace=0;
        private String views="No";
        private String zona="";
        private BigDecimal price = new BigDecimal(0);;
        private int meters=0;
        private String year_built="";
        private String reformed="";
        private String photos="";
        private String keys="No";
        private int geopos=0;
        private String direccion="";
        private String objeto="";
        private String poblacion="Almuñécar";
        private String pais_ISO3166="ES";
        private int rol=0;
        private String carpeta_digitalizacion="";
        private String tipo="US";
        private int id_delegacion=0;
        private int id_departamento=0;
        private String remarks="";
        private byte[] nota_simple;
        private String estado="En venta";
        private String LocalePrice="";
        private String other_features;
        private String urbanization;
        
        public Builder(final int id) {
            this.id = id;
        }
        
         public Builder Owner(final int owner) {
            this.owner = owner;
            return this;
        }
         public Builder Id_customers_type(final int id_customers_type) {
            this.id_customers_type = id_customers_type;
            return this;
        }
         public Builder Tipo_vivienda(final String tipo_vivienda) {
            this.tipo_vivienda = tipo_vivienda;
            return this;
        }
         public Builder Num_bedrooms(final int num_bedrooms) {
            this.num_bedrooms = num_bedrooms;
            return this;
        }
         public Builder Num_kitchens(final int num_kitchens) {
            this.num_kitchens = num_kitchens;
            return this;
        }
         public Builder Num_bathrooms(final int num_bathrooms) {
            this.num_bathrooms = num_bathrooms;
            return this;
        }
         public Builder Num_toilets(final int num_toilets) {
            this.num_toilets = num_toilets;
            return this;
        }
         public Builder Num_saloons(final int num_saloons) {
            this.num_saloons = num_saloons;
            return this;
        }
         public Builder Garage(final int garage) {
            this.garage = garage;
            return this;
        }
         public Builder Terrace(final int terrace) {
            this.terrace = terrace;
            return this;
        }
         public Builder Views(final String views) {
            this.views = views;
            return this;
        }
         public Builder Zona(final String zona) {
            this.zona = zona;
            return this;
        }
          public Builder Price(final BigDecimal price) {
            this.price = price;
            return this;
        }
          public Builder Meters(final int meters) {
            this.meters = meters;
            return this;
        }
          public Builder Photos(final String photos) {
            this.photos = photos;
            return this;
        }
          public Builder Year_built(final String year_built) {
            this.year_built = year_built;
            return this;
        }
          public Builder Reformed(final String reformed) {
            this.reformed = reformed;
            return this;
        }
          public Builder Keys(final String keys) {
            this.keys = keys;
            return this;
        }
          public Builder Geopos(final int geopos) {
            this.geopos = geopos;
            return this;
        }
          public Builder Direccion(final String direccion) {
            this.direccion = direccion;
            return this;
        }
          public Builder Objeto(final String objeto) {
            this.objeto = objeto;
            return this;
        }
          public Builder Poblacion(final String poblacion) {
            this.poblacion = poblacion;
            return this;
        }
          public Builder Pais_ISO3166(final String pais_ISO3166) {
            this.pais_ISO3166 = pais_ISO3166;
            return this;
        }
           public Builder Rol(final int rol) {
            this.rol = rol;
            return this;
        }
           public Builder Carpeta_digitalizacion(final String carpeta_digitalizacion) {
            this.carpeta_digitalizacion = carpeta_digitalizacion;
            return this;
        }
           public Builder Tipo(final String tipo) {
            this.tipo = tipo;
            return this;
        }
           public Builder Id_delegacion(final int id_delegacion) {
            this.id_delegacion = id_delegacion;
            return this;
        }
           public Builder Id_departamento(final int id_departamento) {
            this.id_departamento = id_departamento;
            return this;
        }
           public Builder Remarks(final String remarks) {
            this.remarks = remarks;
            return this;
        }
           public Builder Nota_simple(final byte[] nota_simple) {
            this.nota_simple = nota_simple;
            return this;
        }
           public Builder Estado(final String estado) {
            this.estado = estado;
            return this;
        }
           public Builder Other_features(final String other_features) {
            this.other_features = other_features;
            return this;
        }
           public Builder Urbanization(final String urbanization) {
            this.urbanization = urbanization;
            return this;
        }
           public TuplasForSale build() {
            return new TuplasForSale(this);
        }
            public TuplasForSale build(Locale formato) {
            return new TuplasForSale(this, formato);
        }
    }
    
    
    private TuplasForSale (Builder builder)
    {
        this.id=builder.id;
        this.owner=builder.owner;
        this.id_customers_type=builder.id_customers_type;
        this.tipo_vivienda=builder.tipo_vivienda;
        this.num_bedrooms=builder.num_bedrooms;
        this.num_kitchens=builder.num_kitchens;
        this.num_bathrooms=builder.num_bathrooms;
        this.num_toilets=builder.num_toilets;
        this.num_saloons=builder.num_saloons;
        this.garage=builder.garage;
        this.terrace=builder.terrace;
        this.views=builder.views;
        this.zona=builder.zona;
        this.price=builder.price;
        this.meters=builder.meters;
        this.year_built=builder.year_built;
        this.reformed=builder.reformed;
        this.photos=builder.photos;
        this.keys=builder.keys;
        this.geopos=builder.geopos;
        this.direccion=builder.direccion;
        this.objeto=builder.objeto;
        this.poblacion=builder.poblacion;
        this.pais_ISO3166=builder.pais_ISO3166;
        this.rol=builder.rol;
        this.carpeta_digitalizacion=builder.carpeta_digitalizacion;
        this.tipo=builder.tipo;
        this.id_delegacion=builder.id_delegacion;
        this.id_departamento=builder.id_departamento;
        this.remarks=builder.remarks;
        this.nota_simple=builder.nota_simple;
        this.estado=builder.estado;
        this.LocalePrice=builder.LocalePrice;
        this.other_features=builder.other_features;
        this.urbanization=builder.urbanization;
        
    }
    
    private TuplasForSale (Builder builder, Locale formato)
    {
        this.id=builder.id;
        this.owner=builder.owner;
        this.id_customers_type=builder.id_customers_type;
        this.tipo_vivienda=builder.tipo_vivienda;
        this.num_bedrooms=builder.num_bedrooms;
        this.num_kitchens=builder.num_kitchens;
        this.num_bathrooms=builder.num_bathrooms;
        this.num_toilets=builder.num_toilets;
        this.num_saloons=builder.num_saloons;
        this.garage=builder.garage;
        this.terrace=builder.terrace;
        this.views=builder.views;
        this.zona=builder.zona;
        this.price=builder.price;
        this.meters=builder.meters;
        this.year_built=builder.year_built;
        this.reformed=builder.reformed;
        this.photos=builder.photos;
        this.keys=builder.keys;
        this.geopos=builder.geopos;
        this.direccion=builder.direccion;
        this.objeto=builder.objeto;
        this.poblacion=builder.poblacion;
        this.pais_ISO3166=builder.pais_ISO3166;
        this.rol=builder.rol;
        this.carpeta_digitalizacion=builder.carpeta_digitalizacion;
        this.tipo=builder.tipo;
        this.id_delegacion=builder.id_delegacion;
        this.id_departamento=builder.id_departamento;
        this.remarks=builder.remarks;
        this.nota_simple=builder.nota_simple;
        this.estado=builder.estado;
        NumberFormat format = NumberFormat.getCurrencyInstance(formato);
        format.setMaximumFractionDigits(0);
        this.LocalePrice=format.format(price);
        this.other_features=builder.other_features;
        this.urbanization=builder.urbanization;
        
    }
}
