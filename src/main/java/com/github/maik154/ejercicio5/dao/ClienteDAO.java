package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO {
    private ClienteDAO() {
    }

    public static Set<Cliente> buscarTodos() {
        Set<Cliente> clientes = new HashSet<>();
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            // JPQL
            clientes.addAll(session.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList());
        }
        return clientes;
    }

    public static void guardar(Cliente cliente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        }
    }

    public static Cliente buscarPorDni(String dni) {
        Cliente cliente = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            cliente = session.createQuery("SELECT c FROM Cliente c WHERE c.dni = " + dni, Cliente.class).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public static void borrar(String dni) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Cliente cliente = buscarPorDni(dni);
            session.delete(cliente);
            session.getTransaction().commit();
        }
    }

    public static void actualizar(Cliente cliente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(cliente);
            session.getTransaction().commit();
        }
    }
}
