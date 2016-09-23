package org.apache.archiva.redback.users.jpa;

import org.apache.archiva.redback.policy.UserSecurityPolicy;
import org.apache.archiva.redback.users.User;
import org.apache.archiva.redback.users.UserManager;
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

    @Inject
    private UserSecurityPolicy securityPolicy;

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



    @Test
    public void testUserExists()
            throws Exception
    {
        assertCleanUserManager();
        securityPolicy.setEnabled( false );

        UserManager um = getUserManager();

        // create and add a few users
        User u1 = um.createUser( "admin", "Administrator", "admin@somedomain.com" );
        u1.setPassword( "adminpass" );
        um.addUser( u1 );

        assertTrue( um.userExists( "admin" ) );
        assertFalse( um.userExists( "voodoohatrack" ) );

        /* Check into the event tracker. */
        assertEquals( 1, getEventTracker().countInit );
        assertNotNull( getEventTracker().lastDbFreshness );
        assertTrue( getEventTracker().lastDbFreshness.booleanValue() );

        assertEquals( 1, getEventTracker().addedUsernames.size() );
        assertEquals( 0, getEventTracker().removedUsernames.size() );
        assertEquals( 0, getEventTracker().updatedUsernames.size() );
    }
}
