package dao;

import domain.Cliente;
import domain.Voos;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class VooDao extends GenericDao {

    public VooDao() {
    }

    private Voos pesquisar(int tipo, String pesq) throws HibernateException {

        Voos voo = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery consulta = builder.createQuery(Cliente.class
            );

            Root tabela = consulta.from(Cliente.class
            );

            consulta.distinct(true);

            Predicate restricoes = null;
            switch (tipo) {
                case 0:
                    tabela.join("reserva", JoinType.INNER).get("voo").get("dadosVoo").get("nomeVoo").in(pesq);
                    break;
                /*case 1:
                    restricoes = builder.and(
                            builder.like(tabela.get("cliente").get("cpf"), pesq + "%"),
                            builder.isNotEmpty(tabela.get("cliente").get("checkin")));
                    break;*/
            }

            consulta.where(restricoes);
            // EXECUTAR
            voo = (Voos) sessao.createQuery(consulta).uniqueResult();
            if (voo != null) {
                Hibernate.initialize(voo.getReservas());
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
        return voo;

    }
    
    
     private Voos pesquisar(int tipo, Object pesq1, Object pesq2) throws HibernateException {
        Voos voo = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Voos> consulta = builder.createQuery(Voos.class);

            Root<Voos> tabela = consulta.from(Voos.class);
            consulta.distinct(true);

            Predicate restricoes = null;
            switch (tipo) {
                case 0:
                    tabela.join("cidOrigem", JoinType.INNER);
                    tabela.join("cidDest", JoinType.INNER);
                    restricoes = builder.and(
                        builder.equal(tabela.join("cidOrigem", JoinType.INNER).get("nomeCidade"), pesq1),
                        builder.equal(tabela.join("cidDest", JoinType.INNER).get("nomeCidade"), pesq2)
                    );
                    break;
            }

            if (restricoes != null) {
                consulta.where(restricoes);
            }

            // EXECUTAR
            voo = sessao.createQuery(consulta).uniqueResult();
            if (voo != null) {
                Hibernate.initialize(voo.getReservas());
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
        return voo;
    }
    
    
    public Voos pesquisarVooCliente(String pesq){
        return pesquisar(0, pesq);
    }

    public Voos pesquisarVoos(int i, Object pesq1, Object pesq2) {
        return pesquisar(i, pesq1, pesq2);
    }
    
}
