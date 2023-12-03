package com.example.demo.modelo;

public class UsuarioEmbedded {

    private String tipoDoc;
    private String numDoc;

    public UsuarioEmbedded() {
    }

    public UsuarioEmbedded(String tipoDoc, String numDoc) {

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
    public String getNumDoc() {
        return numDoc;
    }

    /**
     * @param numDoc the numDoc to set
     */
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

}
