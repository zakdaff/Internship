package rest.utilities;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import rest.ressources.Repository;

@ApplicationPath("/api")
public class RestActivator extends Application {



public RestActivator() {
        super();
        BeanConfig beanConfig=new BeanConfig();
        beanConfig.setTitle("Test Internship");
        beanConfig.setDescription("CRUD Test Internship");
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[] {"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("DafdoufZakaria/api");
        beanConfig.setResourcePackage("rest.ressources");
        beanConfig.setPrettyPrint(true); 
        beanConfig.setScan(true);



    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(Repository.class);
        // Available at localhost:port/swagger.json
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;

    }
}