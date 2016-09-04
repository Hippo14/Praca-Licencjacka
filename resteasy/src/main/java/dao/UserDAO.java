package dao;

import model.User;
import model.User_;

import javax.ejb.Stateful;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

/**
 * Created by KMacioszek on 2016-07-11.
 */
@Stateful
public class UserDAO {

    @PersistenceContext(name = "NewPersistenceUnit", type = PersistenceContextType.EXTENDED)
    EntityManager em;

    private static Map<Integer, User> USER_MAP = new HashMap<Integer, User>();
    static {
        USER_MAP.put(1, new User(1, "admin", "admin@gmail.com", new Date()));
        USER_MAP.put(2, new User(2, "test", "test@gmail.com", new Date()));
    }

    public void save(User user) {
            em.persist(user);  //em.merge(user) for updates
    }

    public  User getById(Integer id) {
        return em.find(User.class, id);

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<model.User> q = cb.createQuery(model.User.class);
//        Root<model.User> from = q.from(model.User.class);
//        Predicate _id = cb.equal(from.get(User_.id), id);
//        q.select((from)).where(_id);
//
//
//        return em.createQuery(q).getSingleResult();
    }

    public List<User> getAll() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(model.User.class);
        q.select(c);
        TypedQuery<User> query = em.createQuery(q);

        return query.getResultList();
    }

    public void delete(Integer id) {
        em.remove(id);
    }

    public void update(User user) {
//        model.User tempUser = em.find(model.User.class, user);
//
//        if (tempUser == null)
//            return;
//        em.remove(tempUser);
//        em.persist(user);
    }

    public void patch(User user) {
        em.merge(user);
    }

    public User getByName(String username) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<model.User> q = cb.createQuery(model.User.class);
        Root<model.User> from = q.from(model.User.class);
        Predicate predicate = cb.equal(from.get(User_.name), username);

        q.select((from)).where(predicate);


        return em.createQuery(q).getSingleResult();
    }
}
