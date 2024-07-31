package dao;

import domain.Cliente;
import domain.Empresa;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class EmpresaDao extends GenericDao {

    public EmpresaDao() {
    }

    private Empresa pesquisar(int tipo, String pesq) throws HibernateException {

        Empresa empresa = null;
        Session sessao = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.beginTransaction();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<Empresa> consulta = builder.createQuery(Empresa.class);

            Root<Empresa> tabela = consulta.from(Empresa.class);

            consulta.distinct(true);

            Predicate restricoes = null;
            switch (tipo) {
                case 0:
                    restricoes = builder.equal(tabela.get("cnpj"), pesq);
                    break;
//                case 1:
//                    restricoes = builder.and(
//                            builder.like(tabela.get("cpf"), pesq + "%"),
//                            builder.isNotEmpty(tabela.get("reserva"))
//                    );
//                    break;
            }

            consulta.where(restricoes);
            // EXECUTAR
            empresa = sessao.createQuery(consulta).uniqueResult();
            if (empresa != null) {
                Hibernate.initialize(empresa);
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
        return empresa;
    }
    
    public Empresa pesquisarCNPJ(String pesq) {
        return pesquisar(0, pesq);
    }
    
    public List<Empresa> listarEmpresas() {
        return listar(Empresa.class);
    }

    public void atualizarEmpresa(Empresa empresa) {
        alterar(empresa);
    }
}
