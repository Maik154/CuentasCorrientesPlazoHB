package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class CuentaPlazoDAO {
    private CuentaPlazoDAO() {
    }

    public static List<CuentaPlazo> buscarTodas() {
        List<CuentaPlazo> cuentas = new ArrayList<>();
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            // JPQL
            cuentas.addAll(session.createQuery("SELECT c FROM CuentaPlazo c", CuentaPlazo.class).getResultList());
        }
        return cuentas;
    }

    public static CuentaPlazo buscarPorNumero(String numero) {
        CuentaPlazo cuenta = null; // null
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            // JPQL
            cuenta = session.createQuery("SELECT c FROM CuentaPlazo WHERE c.numero = " + numero, CuentaPlazo.class)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return cuenta;
    }

    public static void guardar(CuentaPlazo cuentaPlazo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cuentaPlazo);
            session.getTransaction().commit();
        }
    }

    public static void borrar(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CuentaPlazo cuentaPlazo = buscarPorNumero(numero);
            session.delete(cuentaPlazo);
            session.getTransaction().commit();
        }
    }

    public static void actualizar(CuentaPlazo cuentaPlazo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(cuentaPlazo);
            session.getTransaction().commit();
        }
    }
}