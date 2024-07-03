package domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Reserva implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idReserva;
    
    @Column(nullable = false)
    private String formaPagamento;
    
    @Column(nullable = false)
    private String email;
    
    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "idCheck_in")
    private Check_in check_in;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    private Cliente cliente;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    private Voos voo;

    public Reserva(String formaPagamento, String email, Cliente cliente, Voos voo) {
        this.formaPagamento = formaPagamento;
        this.email = email;
        this.cliente = cliente;
        this.voo = voo;
    }
    
    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Check_in getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Check_in check_in) {
        this.check_in = check_in;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }
}
