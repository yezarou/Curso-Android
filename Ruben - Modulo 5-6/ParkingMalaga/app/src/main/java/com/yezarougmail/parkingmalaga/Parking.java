package com.yezarougmail.parkingmalaga;

import java.io.Serializable;

public class Parking implements Serializable {
    int _id;
    String _nombre;
    String _direccion;
    double _latitude;
    double _longitude;
    int _capacidad;
    String _fechaAct;
    int _libres;

    public Parking(int id, String nombre){
        _id = id;
        _nombre = nombre;
    }

    public int getId() {
        return _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public String getDir() {
        return _direccion;
    }

    public void setDir(String _direccion) {
        this._direccion = _direccion;
    }

    public double getLatitude() {
        return _latitude;
    }

    public void setLatitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public void setLongitude(double _longitude) {
        this._longitude = _longitude;
    }

    public int getCapacidad() {
        return _capacidad;
    }

    public void setCapacidad(int _capacidad) {
        this._capacidad = _capacidad;
    }

    public String getFechaAct() {
        return _fechaAct;
    }

    public void setFechaAct(String _fechaAct) {
        this._fechaAct = _fechaAct;
    }

    public int getLibres() {
        return _libres;
    }

    public void setLibres(int _libres) {
        this._libres = _libres;
    }
}
