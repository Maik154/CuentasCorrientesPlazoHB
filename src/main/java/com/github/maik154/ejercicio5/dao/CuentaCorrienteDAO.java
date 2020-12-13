package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class CuentaCorrienteDAO {
    private CuentaCorrienteDAO() {
    }

    public static List<CuentaCorriente> buscarTodas() {
        List<CuentaCorriente> cuentas = new ArrayList<>();
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            cuentas.addAll(session.createQuery("SELECT c FROM CuentaCorriente c", CuentaCorriente.class).getResultList());
        }
        return cuentas;
    }

    public static CuentaCorriente buscarPorNumero(String numero) {
        CuentaCorriente cuenta = null;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            cuenta = session.createQuery("SELECT c FROM CuentaCorriente c WHERE c.numero = " + numero, CuentaCorriente.class).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return cuenta;
    }

    public static void guardar(CuentaCorriente cuentaCorriente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cuentaCorriente);
            session.getTransaction().commit();
        }
    }

    public static void borrar(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CuentaCorriente cuentaCorriente = buscarPorNumero(numero);
            session.delete(cuentaCorriente);
            session.getTransaction().commit();
        }
    }
}