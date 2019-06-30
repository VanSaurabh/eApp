package com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManager entityManager = null;
	
	static {
        try{
            loadEntityManager();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
	
	private static void loadEntityManager(){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MyApp_JPA");
		entityManager = emfactory.createEntityManager( );
    }
	
	public static EntityManager getEntityManager(){
		return entityManager;
	}
}
