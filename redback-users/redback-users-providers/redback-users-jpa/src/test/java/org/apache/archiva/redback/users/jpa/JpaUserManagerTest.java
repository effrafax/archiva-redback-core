package org.apache.archiva.redback.users.jpa;

import org.apache.archiva.redback.users.provider.test.AbstractUserManagerTestCase;
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

    @Inject
    @Named("userManager#jpa")
    JpaUserManager jpaUserManager;

    @Inject
    @Named("defaultUserEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Properties props = new Properties();

    // create the factory defined by the "openjpa" entity-manager entry
  
    }

    @Test
    public void testInit() {
        jpaUserManager.initialize();
    }
}
