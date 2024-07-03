package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idEstado;
    
    @Column(nullable = false)
    private String nomeEstado;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "estado" )
    private List<Cidade> cidades = new ArrayList();

    @ManyToOne ( fetch = FetchType.EAGER )
    @JoinColumn ( name="idRegiao" )
    private Regiao regiao;
    
    public Estado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public Estado() {
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }
    
}
