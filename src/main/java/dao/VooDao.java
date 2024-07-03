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

public class VooDao extends GenericDao{

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
    
    public Voos pesquisarVooCliente(String pesq){
        return pesquisar(0, pesq);
    }
    
}
