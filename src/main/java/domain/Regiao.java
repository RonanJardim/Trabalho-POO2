package domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.text.ParseException;

@Entity
public class Regiao implements Serializable{

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idRegiao;

    @Column (name="nomeRegiao", nullable = false)
    private String nomeRegiao;
    
    public Regiao() {
    }

    public Regiao(int idRegiao, String nomeRegiao) {
        this.idRegiao = idRegiao;
        this.nomeRegiao = nomeRegiao;
    }
    
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "regiao" )
    List<Estado> estados = new ArrayList();

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }
    
    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }
    
    public Object toArray() throws ParseException {
        return this;
    }

    @Override
    public String toString() {
        return nomeRegiao;
    }
}
