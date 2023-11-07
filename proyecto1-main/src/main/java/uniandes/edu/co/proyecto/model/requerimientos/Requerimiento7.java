package uniandes.edu.co.proyecto.model.requerimientos;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requerimiento7")
public class Requerimiento7 {

    @Id
    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "clientes_buenos")
    private String clientesBuenos;

    @Column(name = "dias_hospedado")
    private int diasHospedado;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getClientesBuenos() {
        return clientesBuenos;
    }

    public void setClientesBuenos(String clientesBuenos) {
        this.clientesBuenos = clientesBuenos;
    }

    public int getDiasHospedado() {
        return diasHospedado;
    }

    public void setDiasHospedado(int diasHospedado) {
        this.diasHospedado = diasHospedado;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }
}