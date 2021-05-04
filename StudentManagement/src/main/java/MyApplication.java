import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class MyApplication extends Application<MainConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    private HibernateBundle<MainConfiguration> hibernate = new HibernateBundle<MainConfiguration>(Student.class)
    {
        @Override
        public DataSourceFactory getDataSourceFactory(MainConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public void run(MainConfiguration myConfiguration, Environment environment) throws Exception {
        // System.out.println("Value from dev.yml is "+myConfiguration.getDataSourceFactory().getUrl());
       StudentDao theDao=new StudentDao(hibernate.getSessionFactory());
        final MyResource resource = new MyResource(theDao);

        environment.jersey().register(resource);


    }

    @Override
    public void initialize(Bootstrap<MainConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

}
