import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


    @Path("/resource")
    @Produces(MediaType.APPLICATION_JSON)
    public class MyResource {



        private StudentDao theDao;

        public MyResource(StudentDao infoDao) {
            this.theDao = infoDao;
        }

        @GET
        @Timed
        @UnitOfWork
        @Path("/getById/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Student getById(@PathParam("id") String id)
        {
          return  theDao.getById(id);
        }


        @POST
        @Timed
        @UnitOfWork
        @Consumes(MediaType.APPLICATION_JSON)
        public String  Add(Student newStudent ){

            System.out.println("Name is :"+newStudent.getName());
            System.out.println("ID is :"+newStudent.getId());
            System.out.println("Age is :"+newStudent.getAge());
            theDao.insert( newStudent );
            return" Successfully Saved";

        }


        @GET
        @Timed
        @UnitOfWork
        @Path("/findAll")
        public List<Student> findAll() {
            System.out.println("All Emp  : "+theDao.findAll());
            return theDao.findAll();
        }

        @PUT
        @Timed
        @UnitOfWork
        @Consumes(MediaType.APPLICATION_JSON)
        public Student updateStudent(Student theStudent)
        {
           return theDao.insert(theStudent);
        }

        @DELETE
        @Timed
        @UnitOfWork
        @Path("/delete/{id}")
        public String Delete(@PathParam("id") String id)
        {
            return theDao.delete(id);
        }





    }

