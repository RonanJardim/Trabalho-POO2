package control;

import domain.Cidade;
import domain.Cliente;
import domain.Voos;

public class GerenciaDeCidades {
    private Cidade cidOrigem = null;
    private Cidade cidDestino = null;
    private Voos voo = null;
    private Cliente cliente = null;
    
    public Cidade getCidOrigem() {
        return cidOrigem;
    }

    public void setCidOrigem(Cidade cidOrigem) {
        this.cidOrigem = cidOrigem;
    }

    public Cidade getCidDestino() {
        return cidDestino;
    }

    public void setCidDestino(Cidade cidDestino) {
        this.cidDestino = cidDestino;
    }

    public Voos getVoo() {
        return voo;
    }

    public void setVoo(Voos voo) {
        this.voo = voo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
