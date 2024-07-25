package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCidade;
    
    @Column(nullable = false)
    private String nomeCidade;
    
    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idEstado" )
    private Estado estado;
    
    public Cidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Cidade() {
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    @Override
    public String toString() {
        return nomeCidade;
    }

    
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
    
}
