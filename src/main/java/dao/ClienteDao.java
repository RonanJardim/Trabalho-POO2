package dao;

import domain.Cliente;
import domain.Voos;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ClienteDao extends GenericDao {

    public ClienteDao() {

    }

    private Cliente pesquisar(int tipo, String pesq) throws HibernateException {

        Cliente cliente = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Cliente> consulta = builder.createQuery(Cliente.class);

            Root<Cliente> tabela = consulta.from(Cliente.class);

            consulta.distinct(true);

            Predicate restricoes = null;
            switch (tipo) {
                case 0:
                    restricoes = builder.equal(tabela.get("cpf"), pesq);
                    break;
                case 1:
                    restricoes = builder.and(
                            builder.like(tabela.get("cpf"), pesq + "%"),
                            builder.isNotEmpty(tabela.get("reserva"))
                    );
                    break;
                /*                        
            case 2: restricoes = builder.like(tabela.get("endereco").get("bairro"), pesq + "%");
                    break;                    
                
            case 3: Expression mes = builder.function("month", Integer.class, tabela.get("dataPedido") );
                    Expression ano = builder.function("year", Integer.class, tabela.get("dataPedido") );
                    
                    String arr[] = pesq.split("/");                        
                    
                    restricoes = builder.and(  
                            builder.equal(mes, arr[0]),
                            builder.equal(ano, arr[1])
                    );
                    break;*/
            }

            consulta.where(restricoes);
            // EXECUTAR
            cliente = (Cliente) sessao.createQuery(consulta).uniqueResult();
            if (cliente != null) {
                Hibernate.initialize(cliente.getReserva());
            }

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return cliente;

    }

    public Cliente pesquisarPorCPF(String pesq) {
        return pesquisar(0, pesq);
    }

    public Cliente pesquisarClienteReserva(String pesq) {
        return pesquisar(1, pesq);
    }

}
