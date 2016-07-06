package com.example.CanaryFitAndroid.detail.data;


import com.example.CanaryFitAndroid.database.I_Data;
import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="product_table")
public class DetailData implements I_Data {
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String label;

    @Column(name = "label")
    private String modalidad;

    @Column(name = "ref")
    private Long ref;

    @Column(name = "zona")
    private String zona;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "distancia")
    private String distancia;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "precio")
    private String precio;

    @Column(name = "mapa")
    private String mapa;

    @Column(name = "enlace")
    private String enlace;

//    @Column(name = "textoBuscar")
//    private String textoBuscar;


    public DetailData() {
        setLabel("");
    }


    public DetailData(String nombre, String modalidad, String zone, String descrip, String distance, String date, String price, String link, String urlMapa) {
        setLabel(nombre);
        setModalidad(modalidad);
        setZona(zone);
        setDescripcion(descrip);
        setDistancia(distance);
        setFecha(date);
        setPrecio(price);
        setEnlace(link);
        setMapa(urlMapa);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long num) {
        id = num;
    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long num) {
        ref = num;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String nombre) {
        label = nombre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    //    public String getTextoBuscar() {
//        return textoBuscar;
//    }
//
//    public void setTextoBuscar(String textoBuscar) {
//        this.textoBuscar = textoBuscar;
//    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DetailData){
            DetailData data = (DetailData) obj;

            if(data.getId() == getId()){   //todo
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
