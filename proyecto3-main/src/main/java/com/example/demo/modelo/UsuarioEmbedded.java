package com.example.demo.modelo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class UsuarioEmbedded {

    @Field("tipo_doc")
    private String tipoDoc;

    @Field("num_doc")
    private int numDoc;

    public UsuarioEmbedded() {
    }

    public UsuarioEmbedded(String tipoDoc, int numDoc) {

        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
    }

    /**
     * @return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * @return the numDoc
     */
    public int getNumDoc() {
        return numDoc;
    }

    /**
     * @param numDoc the numDoc to set
     */
    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

}
