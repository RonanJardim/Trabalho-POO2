package dao;

import domain.Check_in;
import domain.Reserva;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import org.hibernate.query.Query;

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

    
    public <T> List<T> listById(Class<T> classe, Object argumento, String nome ) throws HibernateException {
        
        if (argumento == null) {
            throw new IllegalArgumentException("O argumento para a consulta não pode ser nulo");
        }
        
        Session sessao = null;
        List<T> resultado = new ArrayList<>();
        
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            CriteriaBuilder builder = sessao.getCriteriaBuilder();
            CriteriaQuery<T> consulta = builder.createQuery(classe);
            Root<T> root = consulta.from(classe);

            // Ajustando o predicado para filtrar pelo campo que referencia o ID da região
            Predicate predicado = builder.equal(root.get(nome), argumento); // Substitua "regiaoId" pelo nome correto do campo
            consulta.where(predicado);

            resultado = sessao.createQuery(consulta).getResultList();
        } catch (HibernateException erro) {
            throw new HibernateException(erro);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return resultado;
    }

    public Object get(Class classe, int id) throws HibernateException {
        Session sessao = null;
        Object objReturn = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            objReturn = sessao.get(classe, id);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return objReturn;
    }

    public Object get(Class classe, String id) throws HibernateException {
        Session sessao = null;
        Object objReturn = null;
        try {
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            objReturn = sessao.get(classe, id);

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }
            throw new HibernateException(ex);
        }
        return objReturn;
    }
    
    public List<Reserva> listByCheckin(Check_in checkin) {
        try (Session sessao = ConexaoHibernate.getSessionFactory().openSession()) {
            String hql = "FROM Reserva WHERE check_in = :checkin";
            Query<Reserva> query = sessao.createQuery(hql);
            query.setParameter("checkin", checkin);
            return query.list();
        }
    }
}