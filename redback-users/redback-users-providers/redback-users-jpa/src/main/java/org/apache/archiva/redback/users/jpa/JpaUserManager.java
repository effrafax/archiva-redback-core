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

import org.apache.archiva.redback.users.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by martin on 20.09.16.
 */
@org.springframework.stereotype.Service("userManager#jpa")
public class JpaUserManager extends AbstractUserManager {

    @javax.inject.Inject
    EntityManagerFactory entityManagerFactory;

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

    @Override
    public User createUser(String username, String fullName, String emailAddress) throws UserManagerException {
        return null;
    }

    @Override
    public UserQuery createUserQuery() {
        return null;
    }

    @Override
    public List<User> getUsers() throws UserManagerException {
        return null;
    }

    @Override
    public List<User> getUsers(boolean orderAscending) throws UserManagerException {
        return null;
    }

    @Override
    public User addUser(User user) throws UserManagerException {
        return null;
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
    public boolean userExists(String principal) throws UserManagerException {
        return false;
    }

    @Override
    public void deleteUser(String username) throws UserNotFoundException, UserManagerException {

    }

    @Override
    public void addUserUnchecked(User user) throws UserManagerException {

    }

    @Override
    public void eraseDatabase() {

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
