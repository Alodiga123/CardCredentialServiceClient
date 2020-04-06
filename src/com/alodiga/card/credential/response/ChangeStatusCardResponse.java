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
public class ChangeStatusCardResponse implements Serializable {

        private String codigoRespuesta;
        private String descripcion;
        private String ticketWS;
        private String xml; 
        private String inicio;
        private String fin;
        private String tiempo;

    public ChangeStatusCardResponse() {
    }
        
        

    public ChangeStatusCardResponse(String codigoRespuesta, String descripcion, String ticketWS, String inicio, String fin, String tiempo) {
        this.codigoRespuesta = codigoRespuesta;
        this.descripcion = descripcion;
        this.ticketWS = ticketWS;
        
        this.inicio = inicio;
        this.fin = fin;
        this.tiempo = tiempo;
    }
        
        
    
    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
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

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
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
       

    

    
    
    
}
