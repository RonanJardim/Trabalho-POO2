package control;

import dao.ClienteDao;
import dao.ConexaoHibernate;
import dao.GenericDao;
import domain.*;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

public class GerenciaDeDados {
    private GenericDao genDao;
    private ClienteDao cliDao;

    GenericDao dao = new GenericDao();
    
    public GerenciaDeDados(){
        ConexaoHibernate.getSessionFactory().openSession();

        genDao = new GenericDao();
        cliDao = new ClienteDao();
    }
    
    public Cliente inserirCliente(String nome, String cpf, String email, String telefone, String rua, String cidade, String bairro, String estado, String sexo, Date dtNasc) throws HibernateException{
        int numero = 0;
        String complemento = "";
        
        Endereco endereco = new Endereco(rua, numero, complemento, cidade, estado);
        genDao.inserir(endereco);
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        cliente.setSexo(sexo);
        cliente.setDtNasc(dtNasc);
        genDao.inserir(cliente);
        return cliente;
    }
    
    public Empresa inserirEmpresa(String nome, String cnpj, String telefone, String rua, String cidade, String bairro, String estado, Date dtFundacao) throws HibernateException{
        int numero = 0;
        String complemento = "";
        
        Endereco endereco = new Endereco(rua, numero, complemento, cidade, estado);
        //genDao.inserir(endereco);
        
        Empresa empresa = new Empresa(nome, cnpj, telefone, dtFundacao, endereco);
        
        genDao.inserir(empresa);
        
        return empresa;
    }

    public Aviao inserirAviao(String modelo, Date anoFabric, Date anoModel, int numAviao) throws HibernateException{
        Aviao aviao = new Aviao();
        aviao.setModelAviao(modelo);
        aviao.setAnoFabric(anoFabric);
        aviao.setAnoModel(anoModel);
        aviao.setNumAviao(numAviao);
        genDao.inserir(aviao);
        
        return aviao;
    }

    public Voos inserirVoo(String horario, String nomeAeroporto, Date dtVoo, Aviao Aviao, Cidade cidOrigem, Cidade cidDestino) throws HibernateException{
        Voos voo = new Voos();
        voo.setCidOrigem(cidOrigem);
        voo.setCidDest(cidDestino);
        voo.setHorario(dtVoo);
        voo.setDtVoo(dtVoo);
        voo.setAviao(Aviao);
        genDao.inserir(voo);
        
        return voo;
    }

    public Reserva inserirReserva(String formaPagamento, Cliente cliente, Voos voo) throws HibernateException{
        Reserva reserva = new Reserva();
        reserva.setFormaPagamento(formaPagamento);
        reserva.setCliente(cliente);
        reserva.setVoo(voo);
        genDao.inserir(reserva);
        
        return reserva;
    }

    public Check_in inserirCheckin(int codVoo, Reserva reserva) throws HibernateException{
        Check_in checkin = new Check_in();
        checkin.setCodVoo(codVoo);
        checkin.setReserva(reserva);
        genDao.inserir(checkin);

        return checkin;
    }
    
    public List list(Class classe){
        return genDao.listar(classe);
    }
    
    public Cliente buscarCliente(String cpf){
        return cliDao.pesquisarPorCPF(cpf);
    }
    
    public Cliente pesquisarClienteReserva(String pesq){
        return cliDao.pesquisarClienteReserva(pesq);
    }
}

