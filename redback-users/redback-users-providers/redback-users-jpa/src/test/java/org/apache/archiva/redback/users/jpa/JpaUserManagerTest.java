package org.apache.archiva.redback.users.jpa;

import org.apache.archiva.redback.users.provider.test.AbstractUserManagerTestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Created by martin on 21.09.16.
 */

public class JpaUserManagerTest extends AbstractUserManagerTestCase {

    Log log = LogFactory.getLog(JpaUserManagerTest.class);

    @Inject
    @Named("userManager#jpa")
    JpaUserManager jpaUserManager;

    @Inject
    @Named("defaultUserEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @Before
    @Override
    public void setUp() throws Exception {

        super.setUp();
        log.info("test setup");
        Properties props = new Properties();
        super.setUserManager(jpaUserManager);
        assertNotNull(jpaUserManager);
        log.info("injected usermanager "+jpaUserManager);

    // create the factory defined by the "openjpa" entity-manager entry
  
    }

    @Test
    public void testInit() {
        jpaUserManager.initialize();
    }

    @Override
    public void testUserExists() throws Exception {
        log.info("Testing userExists");
        super.testUserExists();
    }
}
