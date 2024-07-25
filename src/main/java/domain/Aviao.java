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
public class Aviao implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idAviao;
    
    @Column(nullable = false, updatable = false)
    private String modelAviao;
    
    @Temporal ( value = TemporalType.DATE )
    @Column
    private Date anoFabric;
    
    @Temporal ( value = TemporalType.DATE )
    @Column
    private Date anoModel;
    
    @Column(nullable = false, updatable = false)
    private int numAviao;

    @ManyToOne( fetch = FetchType.EAGER)
    private Empresa empresa;
    
    @OneToMany ( fetch = FetchType.LAZY )
    private List<Voos> voos = new ArrayList();
    
    
    public Aviao(String modelAviao, Date anoFabric, Date anoModel, int numAviao) {
        this.modelAviao = modelAviao;
        this.anoFabric = anoFabric;
        this.anoModel = anoModel;
        this.numAviao = numAviao;
    }

    public Aviao() {
    }
    

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public String getModelAviao() {
        return modelAviao;
    }

    public void setModelAviao(String modelAviao) {
        this.modelAviao = modelAviao;
    }

    public Date getAnoFabric() {
        return anoFabric;
    }

    public void setAnoFabric(Date anoFabric) {
        this.anoFabric = anoFabric;
    }

    public Date getAnoModel() {
        return anoModel;
    }

    public void setAnoModel(Date anoModel) {
        this.anoModel = anoModel;
    }

    public int getNumAviao() {
        return numAviao;
    }

    public void setNumAviao(int numAviao) {
        this.numAviao = numAviao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
