package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Voos implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idVoos;
    
    @Column(nullable = false)
    private float valor;
    
    @Temporal ( value = TemporalType.DATE )
    @Column
    private Date horario;
    
    @Column(nullable = false)
    private String nomeAeroporto;
    
    @Temporal ( value = TemporalType.DATE )
    @Column
    private Date dtVoo;
    
   @ManyToOne( fetch = FetchType.EAGER)
    private Aviao aviao;
    
   @ManyToOne( fetch = FetchType.EAGER)
    private Cidade cidOrigem;
    
    @ManyToOne( fetch = FetchType.EAGER)
    private Cidade cidDest;
    
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "voo" )
    private List<Reserva> reservas;
    
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "voo" )
    private List<Empresa> empresas = new ArrayList();

    public Voos(float valor, Date horario, String nomeAeroporto, Date dtVoo, Aviao aviao, Cidade cidOrigem, Cidade cidDest) {
        this.valor = valor;
        this.horario = horario;
        this.nomeAeroporto = nomeAeroporto;
        this.dtVoo = dtVoo;
        this.aviao = aviao;
        this.cidOrigem = cidOrigem;
        this.cidDest = cidDest;
    }

    
    public Voos() {
    }

    public int getIdVoos() {
        return idVoos;
    }

    public void setIdVoos(int idVoos) {
        this.idVoos = idVoos;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public Date getDtVoo() {
        return dtVoo;
    }

    public void setDtVoo(Date dtVoo) {
        this.dtVoo = dtVoo;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Cidade getCidOrigem() {
        return cidOrigem;
    }

    public void setCidOrigem(Cidade cidOrigem) {
        this.cidOrigem = cidOrigem;
    }

    public Cidade getCidDest() {
        return cidDest;
    }

    public void setCidDest(Cidade cidDest) {
        this.cidDest = cidDest;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    
}
