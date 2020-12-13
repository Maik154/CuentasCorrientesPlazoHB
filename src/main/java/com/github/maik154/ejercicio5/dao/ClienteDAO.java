package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO {
    private ClienteDAO() {
    }

    public static void añadirClienteHB(Cliente cliente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        }
    }

    public static Set<Cliente> consultarClientesHb() {
        Set<Cliente> clientes;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            cq.from(Cliente.class);
            clientes = new HashSet<>(session.createQuery(cq).getResultList());
            session.getTransaction().commit();
        }
        return clientes;
    }

    public static Cliente buscarClientePorDni(String dni) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
            Root<Cliente> root = cq.from(Cliente.class);
            cq.where(cb.equal(root.get("dni"), dni));
            return session.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void borrarCliente(String dni) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Cliente cliente = buscarClientePorDni(dni);
            session.delete(cliente);
            session.getTransaction().commit();
        }
    }

    public static void modificarDireccion(Cliente cliente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(cliente);
            session.getTransaction().commit();
        }
    }
}
