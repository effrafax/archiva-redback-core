package org.apache.archiva.redback.rbac.jpa;

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

import org.apache.archiva.redback.rbac.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;
import java.util.List;

/**
 * Created by martin on 20.09.16.
 */
@Service("rbacManager#jpa")
public class JpaRbacManager extends AbstractRBACManager implements RBACManagerListener {

    @Inject
    EntityManagerFactory entityManagerFactory;


    @Override
    public void rbacInit(boolean freshdb) {

    }

    @Override
    public void rbacRoleSaved(Role role) {

    }

    @Override
    public void rbacRoleRemoved(Role role) {

    }

    @Override
    public void rbacPermissionSaved(Permission permission) {

    }

    @Override
    public void rbacPermissionRemoved(Permission permission) {

    }

    @Override
    public void rbacUserAssignmentSaved(UserAssignment userAssignment) {

    }

    @Override
    public void rbacUserAssignmentRemoved(UserAssignment userAssignment) {

    }

    @Override
    public Role createRole(String name) {
        return null;
    }

    @Override
    public Role saveRole(Role role) throws RbacObjectInvalidException, RbacManagerException {
        return null;
    }

    @Override
    public void saveRoles(Collection<Role> roles) throws RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public Role getRole(String roleName) throws RbacObjectNotFoundException, RbacManagerException {
        return null;
    }

    @Override
    public List<Role> getAllRoles() throws RbacManagerException {
        return null;
    }

    @Override
    public void removeRole(Role role) throws RbacObjectNotFoundException, RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public Permission createPermission(String name) throws RbacManagerException {
        return null;
    }

    @Override
    public Permission createPermission(String name, String operationName, String resourceIdentifier) throws RbacManagerException {
        return null;
    }

    @Override
    public Permission savePermission(Permission permission) throws RbacObjectInvalidException, RbacManagerException {
        return null;
    }

    @Override
    public Permission getPermission(String permissionName) throws RbacObjectNotFoundException, RbacManagerException {
        return null;
    }

    @Override
    public List<Permission> getAllPermissions() throws RbacManagerException {
        return null;
    }

    @Override
    public void removePermission(Permission permission) throws RbacObjectNotFoundException, RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public Operation createOperation(String name) throws RbacManagerException {
        return null;
    }

    @Override
    public Operation saveOperation(Operation operation) throws RbacObjectInvalidException, RbacManagerException {
        return null;
    }

    @Override
    public Operation getOperation(String operationName) throws RbacObjectNotFoundException, RbacManagerException {
        return null;
    }

    @Override
    public List<Operation> getAllOperations() throws RbacManagerException {
        return null;
    }

    @Override
    public void removeOperation(Operation operation) throws RbacObjectNotFoundException, RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public Resource createResource(String identifier) throws RbacManagerException {
        return null;
    }

    @Override
    public Resource saveResource(Resource resource) throws RbacObjectInvalidException, RbacManagerException {
        return null;
    }

    @Override
    public Resource getResource(String resourceIdentifier) throws RbacObjectNotFoundException, RbacManagerException {
        return null;
    }

    @Override
    public List<Resource> getAllResources() throws RbacManagerException {
        return null;
    }

    @Override
    public void removeResource(Resource resource) throws RbacObjectNotFoundException, RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public UserAssignment createUserAssignment(String principal) throws RbacManagerException {
        return null;
    }

    @Override
    public UserAssignment saveUserAssignment(UserAssignment userAssignment) throws RbacObjectInvalidException, RbacManagerException {
        return null;
    }

    @Override
    public UserAssignment getUserAssignment(String principal) throws RbacObjectNotFoundException, RbacManagerException {
        return null;
    }

    @Override
    public List<UserAssignment> getAllUserAssignments() throws RbacManagerException {
        return null;
    }

    @Override
    public List<UserAssignment> getUserAssignmentsForRoles(Collection<String> roleNames) throws RbacManagerException {
        return null;
    }

    @Override
    public void removeUserAssignment(UserAssignment userAssignment) throws RbacObjectNotFoundException, RbacObjectInvalidException, RbacManagerException {

    }

    @Override
    public void eraseDatabase() {

    }

    @Override
    public String getDescriptionKey() {
        return null;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }
}
