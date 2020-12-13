package com.github.maik154.ejercicio5.dao;

import com.github.maik154.ejercicio5.Pojos.Movimiento;
import com.github.maik154.ejercicio5.Util.SessionFactoryUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MovimientoDAO {
    private MovimientoDAO() {
    }

    public static void añadirMovimientoHB(Movimiento movimiento) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(movimiento);
            session.getTransaction().commit();
        }
    }

    public static void borrarMovimientoHB(Movimiento movimiento) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(movimiento);
            session.getTransaction().commit();
        }
    }

    public static Movimiento buscarMovimientoPorNumeroDeCuenta(String numeroCta){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Movimiento> cq = cb.createQuery(Movimiento.class);
            Root<Movimiento> root = cq.from(Movimiento.class);
            cq.where(cb.equal(root.get("numeroCta"), numeroCta));
            return session.createQuery(cq).getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        return null;
    }
}
