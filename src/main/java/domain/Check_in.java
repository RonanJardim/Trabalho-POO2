package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Check_in implements Serializable{
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCheck_in;
    
    @Column(nullable = true)
    private int codVoo;

    @OneToOne(mappedBy = "check_in", fetch = FetchType.LAZY)
    private Reserva reserva;

    public Check_in(int codVoo, Reserva reserva) {
        this.codVoo = codVoo;
        this.reserva = reserva;
    }
    
    public Check_in() {
    }

    public int getIdCheck_in() {
        return idCheck_in;
    }

    public void setIdCheck_in(int idCheck_in) {
        this.idCheck_in = idCheck_in;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
