/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alodiga.card.credential.response;

import java.io.Serializable;

/**
 *
 * @author ltoro
 */
public class StatusCardResponse implements Serializable {

    private String codigo;
    private String descripcion;
    private String ticketWS;
    
    private String inicio;
    private String fin;
    private String tiempo;
    
    private String numero;
    private String cuenta;
    
    private String codigoEntidad;
    private String descripcionEntidad;
    
    private String sucursal;
    
    private String codigoProducto;
    private String descripcionProducto;
    
    private String codigoEstado;
    private String descripcionEstado;
    
    private String actual;
    private String anterior;
        
    private String denominacion;
    
    private String tipo;
    private String iden;
    
    private String telefono;
    
    private String direccion;
    
    private String codigoPostal;
    
    private String localidad;
    
    private String codigoPais;
    private String descripcionPais;
    
    private String momentoUltimaActualizacion;
    private String momentoUltimaOperacionAprobada;
    private String momentoUltimaOperacionDenegada;
    private String momentoUltimaBajaBoletin;
    
    private String contadorPinERR;

    public StatusCardResponse() {
    }

    public StatusCardResponse(String codigo, String descripcion, String ticketWS, String inicio, String fin, String tiempo, String numero, String cuenta, String codigoEntidad, String descripcionEntidad, String sucursal, String codigoProducto, String descripcionProducto, String codigoEstado, String descripcionEstado, String actual, String anterior, String denominacion, String tipo, String iden, String telefono, String direccion, String codigoPostal, String localidad, String codigoPais, String descripcionPais, String momentoUltimaActualizacion, String momentoUltimaOperacionAprobada, String momentoUltimaOperacionDenegada, String momentoUltimaBajaBoletin, String contadorPinERR) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ticketWS = ticketWS;
        this.inicio = inicio;
        this.fin = fin;
        this.tiempo = tiempo;
        this.numero = numero;
        this.cuenta = cuenta;
        this.codigoEntidad = codigoEntidad;
        this.descripcionEntidad = descripcionEntidad;
        this.sucursal = sucursal;
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.codigoEstado = codigoEstado;
        this.descripcionEstado = descripcionEstado;
        this.actual = actual;
        this.anterior = anterior;
        this.denominacion = denominacion;
        this.tipo = tipo;
        this.iden = iden;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.codigoPais = codigoPais;
        this.descripcionPais = descripcionPais;
        this.momentoUltimaActualizacion = momentoUltimaActualizacion;
        this.momentoUltimaOperacionAprobada = momentoUltimaOperacionAprobada;
        this.momentoUltimaOperacionDenegada = momentoUltimaOperacionDenegada;
        this.momentoUltimaBajaBoletin = momentoUltimaBajaBoletin;
        this.contadorPinERR = contadorPinERR;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTicketWS() {
        return ticketWS;
    }

    public void setTicketWS(String ticketWS) {
        this.ticketWS = ticketWS;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getDescripcionEntidad() {
        return descripcionEntidad;
    }

    public void setDescripcionEntidad(String descripcionEntidad) {
        this.descripcionEntidad = descripcionEntidad;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getDescripcionPais() {
        return descripcionPais;
    }

    public void setDescripcionPais(String descripcionPais) {
        this.descripcionPais = descripcionPais;
    }

    public String getMomentoUltimaActualizacion() {
        return momentoUltimaActualizacion;
    }

    public void setMomentoUltimaActualizacion(String momentoUltimaActualizacion) {
        this.momentoUltimaActualizacion = momentoUltimaActualizacion;
    }

    public String getMomentoUltimaOperacionAprobada() {
        return momentoUltimaOperacionAprobada;
    }

    public void setMomentoUltimaOperacionAprobada(String momentoUltimaOperacionAprobada) {
        this.momentoUltimaOperacionAprobada = momentoUltimaOperacionAprobada;
    }

    public String getMomentoUltimaOperacionDenegada() {
        return momentoUltimaOperacionDenegada;
    }

    public void setMomentoUltimaOperacionDenegada(String momentoUltimaOperacionDenegada) {
        this.momentoUltimaOperacionDenegada = momentoUltimaOperacionDenegada;
    }

    public String getMomentoUltimaBajaBoletin() {
        return momentoUltimaBajaBoletin;
    }

    public void setMomentoUltimaBajaBoletin(String momentoUltimaBajaBoletin) {
        this.momentoUltimaBajaBoletin = momentoUltimaBajaBoletin;
    }

    public String getContadorPinERR() {
        return contadorPinERR;
    }

    public void setContadorPinERR(String contadorPinERR) {
        this.contadorPinERR = contadorPinERR;
    }

    

    
}
