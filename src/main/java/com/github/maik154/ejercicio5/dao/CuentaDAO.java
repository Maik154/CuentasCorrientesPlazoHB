package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.Cuenta;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CuentaDAO {
    private CuentaDAO() {
    }

    public static void añadirCuentaHB(Cuenta cuenta) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cuenta);
            session.getTransaction().commit();
        }
    }

    public static void añadirCuentaPlazoHB(CuentaPlazo cuentaPlazo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cuentaPlazo);
            session.getTransaction().commit();
        }
    }

    public static void añadirCuentaCorrienteHB(CuentaCorriente cuentaCorriente) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(cuentaCorriente);
            session.getTransaction().commit();
        }
    }

    public static Cuenta buscarCuentaPorNumero(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return (Cuenta) session.createQuery("SELECT c FROM Cuenta c WHERE c.numero = " + numero).getSingleResult();
        }
    }

    public static CuentaPlazo buscarCuentaPlazo(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CuentaPlazo> cq = cb.createQuery(CuentaPlazo.class);
            Root<CuentaPlazo> root = cq.from(CuentaPlazo.class);
            cq.where(cb.equal(root.get("numero"), numero));
            return session.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void borrarCuentaCorrienteHB(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CuentaCorriente cuentaCorriente = buscarCuentaCorriente(numero);
            session.delete(cuentaCorriente);
            session.getTransaction().commit();
        }
    }

    public static void borrarCuentaPlazoHB(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CuentaPlazo cuentaPlazo = buscarCuentaPlazo(numero);
            session.delete(cuentaPlazo);
            session.getTransaction().commit();
        }
    }

    //TODO probar si al buscar una corriente le pasamos una a plazo y a la inversa
    //y tambien con el modificar intereses
    public static CuentaCorriente buscarCuentaCorriente(String numero) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CuentaCorriente> cq = cb.createQuery(CuentaCorriente.class);
            Root<CuentaCorriente> root = cq.from(CuentaCorriente.class);
            cq.where(cb.equal(root.get("numero"), numero));
            return session.createQuery(cq).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void modificarIntereses(CuentaPlazo cuentaPlazo) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(cuentaPlazo);
            session.getTransaction().commit();
        }
    }

}