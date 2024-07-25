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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column (name="nomeCliente", nullable = false)
    private String nome;
    
    @Column ( unique = true, length = 14, updatable = false )
    private String cpf;

    @Column ( unique = true, length = 50 )
    private String email;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    @Temporal ( value = TemporalType.DATE )
    @Column (name = "dataNascimento")
    private Date dtNasc;
    
    @Column ( length = 1)
    private String sexo;  
    
    @Column ( length = 15)
    private String telefone;

    @ManyToOne ( fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn ( name="idEndereco" )
    private Endereco endereco;
    
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "cliente" )
    private List<Reserva> reserva = new ArrayList();
    
    public Cliente(String nome, String cpf, Date dtNasc, String sexo, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
   
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", dtNasc=" + dtNasc + ", sexo=" + sexo + ", telefone=" + telefone + ", endereco=" + endereco + ", reserva=" + reserva + '}';
    }


}



