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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;

    @Column(nullable = false)
    private String nomeEmpresa;

    @Column(unique = true, length = 18, updatable = false)
    private String cnpj;

    @Column(length = 14)
    private String telefone;

    @Temporal(value = TemporalType.DATE)
    @Column
    private Date dtFundacao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
    private List<Endereco> endereco = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Voos voo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
    private List<Aviao> avioes = new ArrayList<>();

    public Empresa(String nomeEmpresa, String cnpj, String telefone, Date dtFundacao, Endereco endereco) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.dtFundacao = dtFundacao;
        this.endereco.add(endereco);
    }

    public Empresa() {}

    // Getters e setters
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtFundacao() {
        return dtFundacao;
    }

    public void setDtFundacao(Date dtFundacao) {
        this.dtFundacao = dtFundacao;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }

    public List<Aviao> getAvioes() {
        return avioes;
    }

    public void setAvioes(List<Aviao> avioes) {
        this.avioes = avioes;
    }
    
    
}
