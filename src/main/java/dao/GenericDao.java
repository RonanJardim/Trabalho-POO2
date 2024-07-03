package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaQuery;

public class GenericDao {

    public void inserir(Object obj) throws HibernateException {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            // OPERAÇÕES
            sessao.save(obj);

            transacao.commit();
        } catch (HibernateException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new HibernateException(erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void alterar(Object obj) throws HibernateException {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            // OPERAÇÕES
            sessao.update(obj);

            transacao.commit();
        } catch (HibernateException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new HibernateException(erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void excluir(Object obj) throws HibernateException {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            // OPERAÇÕES
            sessao.delete(obj);

            transacao.commit();
        } catch (HibernateException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw new HibernateException(erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public <T> List<T> listar(Class<T> classe) throws HibernateException {
        Session sessao = null;
        List<T> lista = null;

        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();

            // OPERAÇÕES
            CriteriaQuery<T> consulta = sessao.getCriteriaBuilder().createQuery(classe);
            consulta.from(classe);
            lista = sessao.createQuery(consulta).getResultList();
        } catch (HibernateException erro) {
            throw new HibernateException(erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return lista;
    }
    
    public Object get(Class classe, int id) throws HibernateException {
        Session sessao = null;
        Object objReturn = null;
        try   {
          sessao = ConexaoHibernate.getSessionFactory().openSession();
          sessao.getTransaction().begin();

          objReturn = sessao.get(classe, id );

          sessao.getTransaction().commit();
          sessao.close();
        } catch ( HibernateException ex) {
            if ( sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return objReturn;
    }
    
    
}
