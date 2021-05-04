import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

public class StudentDao extends AbstractDAO<Student> {

 private SessionFactory sessionFactory;

    public StudentDao(SessionFactory factory) {
        super(factory);

        this.sessionFactory=factory;

    }

public List<Student> findAll()
{
   Session session=sessionFactory.getCurrentSession();
    Query<Student> theQuery=session.createQuery("from Student",Student.class);
    List<Student> theStudent=theQuery.getResultList();
    return theStudent;
}



    public Student insert(Student theStudent)
    {
Session currentSession=sessionFactory.getCurrentSession();

//save the customer lol
currentSession.saveOrUpdate(theStudent);
return theStudent;
        
    }

    public Student getById(String id) {
        Session session=sessionFactory.getCurrentSession();
        Student theStudent=session.get(Student.class, id);
        return theStudent;

    }

    public void update(Student theStudent) {

    }

    public String delete(String id) {
        Session session=sessionFactory.getCurrentSession();
        Student theStudent=session.get(Student.class,id);
        session.delete(theStudent);
        return "Deleted";
    }
}
