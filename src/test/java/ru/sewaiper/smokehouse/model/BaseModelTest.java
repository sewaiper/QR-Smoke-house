package ru.sewaiper.smokehouse.model;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseModelTest {
    protected static String persistenceUnitName = null;
    protected static EntityManagerFactory entityManagerFactory;
    protected static SessionFactory sessionFactory;

    private static boolean setUpFlag = false;

    @Before
    public void setUp() {
        if(!setUpFlag) {
            setPersistenceUnitName();
            Assert.assertNotNull("Persistence unit name could be defined", persistenceUnitName);
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
            setUpFlag = true;
        }
    }

    @AfterClass
    public static void tearDown() {
        entityManagerFactory.close();
    }

    public abstract void setPersistenceUnitName();
    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }
}
