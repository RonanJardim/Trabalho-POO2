package control;

import dao.ClienteDao;
import dao.ConexaoHibernate;
import dao.EmpresaDao;
import dao.GenericDao;
import dao.VooDao;
import domain.*;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

public class GerenciaDeDados {

    private GenericDao genDao;
    private ClienteDao cliDao;
    private VooDao vooDao;
    private EmpresaDao empresaDao;

    GenericDao dao = new GenericDao();

    public GerenciaDeDados() {
        ConexaoHibernate.getSessionFactory().openSession();

        genDao = new GenericDao();
        cliDao = new ClienteDao();
        vooDao = new VooDao();
        empresaDao = new EmpresaDao();
    }

    public Cliente inserirCliente(String nome, String cpf, String email, String telefone, String rua, String cidade,
            String bairro, String estado, String sexo, Date dtNasc) throws HibernateException {
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

    public Empresa inserirEmpresa(String nome, String cnpj, String telefone, String rua, String cidade, String bairro,
            String estado, Date dtFundacao) throws HibernateException {
        int numero = 0;
        String complemento = "";

        Empresa empresa = new Empresa(nome, cnpj, telefone, dtFundacao);
        genDao.inserir(empresa);

        Endereco endereco = new Endereco(rua, numero, complemento, cidade, estado, empresa);
        genDao.inserir(endereco);

        return empresa;
    }

    public Aviao inserirAviao(String modelo, Empresa empresa, Date anoFabric, Date anoModel, int numAviao)
            throws HibernateException {
        Aviao aviao = new Aviao();
        aviao.setModelAviao(modelo);
        aviao.setAnoFabric(anoFabric);
        aviao.setAnoModel(anoModel);
        aviao.setNumAviao(numAviao);
        aviao.setEmpresa(empresa);
        genDao.inserir(aviao);

        return aviao;
    }

    public Voos inserirVoo(String horario, String nomeAeroporto, Date dtVoo, Aviao Aviao, Cidade cidOrigem,
            Cidade cidDestino) throws HibernateException {
        Voos voo = new Voos();
        voo.setCidOrigem(cidOrigem);
        voo.setCidDest(cidDestino);
        voo.setHorario(dtVoo);
        voo.setDtVoo(dtVoo);
        voo.setAviao(Aviao);
        genDao.inserir(voo);

        return voo;
    }

    public Reserva inserirReserva(String formaPagamento, String email, Cliente cliente, Voos voo)
            throws HibernateException {

        Reserva reserva = new Reserva(formaPagamento, email, cliente, voo);
        genDao.inserir(reserva);

        return reserva;
    }

    public Check_in inserirCheckin(Reserva reserva) throws HibernateException {
        Check_in checkin = new Check_in();
        checkin.setReserva(reserva);
        genDao.inserir(checkin);

        return checkin;
    }

    public List list(Class classe) {
        return genDao.listar(classe);
    }

    public List listById(Class classe, Object id, String nome) {
        return genDao.listById(classe, id, nome);
    }

    public Cliente buscarCliente(String cpf) {
        return cliDao.pesquisarPorCPF(cpf);
    }

    public Cliente pesquisarClienteReserva(String pesq) {
        return cliDao.pesquisarClienteReserva(pesq);
    }

    public Voos pesquisarVooCliente(String pesq) {
        return vooDao.pesquisarVooCliente(pesq);
    }

    public Voos pesquisarVoos(int i, String pesq1, String pesq2) {
        return vooDao.pesquisarVoos(i, pesq1, pesq2);
    }

    public Reserva atualizarReserva(Reserva reserva) {
        Check_in check = new Check_in();
        reserva.setCheck_in(check);
        genDao.alterar(reserva);
        return reserva;
    }

    public Check_in atualizarCheckin(Check_in checkin) {
        genDao.alterar(checkin);
        return checkin;
    }

    public void excluir(Object obj)throws HibernateException{
        genDao.excluir(obj);
    }
    
    public Empresa pesquisarCNPJ(String pesq){
        return empresaDao.pesquisarCNPJ(pesq);
    }

    public List<Empresa> listaEmpresas(Class classe) {
        return empresaDao.listar(Empresa.class);
    }

    public List<Cliente> listaClientes(Class classe) {
        return cliDao.listar(Cliente.class);
    }

    public List<Check_in> listaCheckin(Class classe) {
        return genDao.listar(Check_in.class);
    }

    public void excluirCliente(Cliente cliente) {
        genDao.excluir(cliente);
    }

    public void excluirEmpresa(Empresa empresa) {
        genDao.excluir(empresa);
    }

    public void excluirCheckin(Check_in checkin) {
        genDao.excluir(checkin);
    }
    
    public void excluirReservasPorCheckin(Check_in checkin) {
        List<Reserva> reservas = genDao.listByCheckin(checkin);
        for (Reserva reserva : reservas) {
            genDao.excluir(reserva);
        }
    }
    
    public int atualizarCliente(Cliente cliente, String nome, Date data, String numero, String estado, String cidade) {
        Endereco endereco = cliente.getEndereco();
        endereco.setEstado(estado);
        endereco.setCidade(cidade);
        genDao.alterar(endereco);
        
        cliente.setNome(nome);
        cliente.setDtNasc(data);
        cliente.setTelefone(numero);
        genDao.alterar(cliente);
        
        return cliente.getIdCliente();
    }

    public int atualizarEmpresa(Empresa empresa, String nome, String cnpj, String numero) {
        empresa.setNomeEmpresa(nome);
        empresa.setCnpj(cnpj);
        empresa.setTelefone(numero);
        this.genDao.alterar(empresa);
        
        return empresa.getIdEmpresa();
    }

    public void atualizarCheck_in(Check_in checkin) {
        genDao.alterar(checkin);
    }
}
