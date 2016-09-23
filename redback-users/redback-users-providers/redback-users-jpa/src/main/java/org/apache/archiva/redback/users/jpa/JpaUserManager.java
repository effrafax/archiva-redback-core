package org.apache.archiva.redback.users.jpa;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.archiva.redback.policy.UserSecurityPolicy;
import org.apache.archiva.redback.users.*;
import org.apache.archiva.redback.users.jpa.model.JpaUser;
import org.apache.commons.lang.StringUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by martin on 20.09.16.
 */
@org.springframework.stereotype.Service("userManager#jpa")
public class JpaUserManager extends AbstractUserManager {

    @Inject
    EntityManagerFactory entityManagerFactory;

    @Inject
    private UserSecurityPolicy userSecurityPolicy;

    public void setEntityManagerFactory(EntityManagerFactory factory) {
        this.entityManagerFactory = factory;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getId() {
        return "jpa";
    }

    private EntityManager getEm() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public User createUser(String username, String fullName, String emailAddress) throws UserManagerException {

        JpaUser user = new JpaUser();
        user.setUsername(username);
        user.setFullName(fullName);
        user.setEmail(emailAddress);
        return user;
    }

    @Override
    public UserQuery createUserQuery() {
        return null;
    }

    @Override
    public List<User> getUsers() throws UserManagerException {
        EntityManager em = getEm();
        Query q= em.createQuery("SELECT x from JpaUser x");
        return q.getResultList();
    }

    @Override
    public List<User> getUsers(boolean orderAscending) throws UserManagerException {
        return null;
    }

    @Override
    public User addUser(User user) throws UserManagerException {
        EntityManager em = getEm();
        if ( !( user instanceof JpaUser ) )
        {
            throw new UserManagerException( "Unable to Add User. User object " + user.getClass().getName() +
                    " is not an instance of " + JpaUser.class.getName() );
        }

        if ( StringUtils.isEmpty( user.getUsername() ) )
        {
            throw new IllegalStateException(
                    Messages.getString( "user.manager.cannot.add.user.without.username" ) ); //$NON-NLS-1$
        }

        userSecurityPolicy.extensionChangePassword( user );

        fireUserManagerUserAdded( user );

        // TODO: find a better solution
        // workaround for avoiding the admin from providing another password on the next login after the
        // admin account has been created
        // extensionChangePassword by default sets the password change status to false
        if ( "admin".equals( user.getUsername() ) )
        {
            user.setPasswordChangeRequired( false );
        }
        else
        {
            user.setPasswordChangeRequired( true );
        }
        em.getTransaction().begin();
        em.persist((JpaUser)user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException, UserManagerException {
        return null;
    }

    @Override
    public User findUser(String username) throws UserNotFoundException, UserManagerException {
        return null;
    }

    @Override
    public User findUser(String username, boolean useCache) throws UserNotFoundException, UserManagerException {
        return null;
    }

    @Override
    public List<User> findUsersByUsernameKey(String usernameKey, boolean orderAscending) throws UserManagerException {
        return null;
    }

    @Override
    public List<User> findUsersByFullNameKey(String fullNameKey, boolean orderAscending) throws UserManagerException {
        return null;
    }

    @Override
    public List<User> findUsersByEmailKey(String emailKey, boolean orderAscending) throws UserManagerException {
        return null;
    }

    @Override
    public List<User> findUsersByQuery(UserQuery query) throws UserManagerException {
        return null;
    }

    @Override
    public boolean userExists(String principal) throws UserManagerException  {
        EntityManager em = getEm();
        JpaUser user = em.find(JpaUser.class, principal);
        return user != null;
    }

    @Override
    public void deleteUser(String username) throws UserNotFoundException, UserManagerException {

    }

    @Override
    public void addUserUnchecked(User user) throws UserManagerException {

    }

    @Override
    public void eraseDatabase() {
        EntityManager em = getEm();
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM JpaUser u");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public User updateUser(User user, boolean passwordChangeRequired) throws UserNotFoundException, UserManagerException {
        return null;
    }

    @Override
    public String getDescriptionKey() {
        return null;
    }




}
