package org.apache.archiva.redback.users.jpa.model;

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

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by martin on 20.09.16.
 */
@Entity
@Table(name="JDOUSER")
public class JpaUser implements org.apache.archiva.redback.users.User {

    @Id
    private String username;

    private String fullName;
    private String email;
    private String encodedPassword;
    private Date lastPasswordChange;
    @ElementCollection
    private List<String> previousEncodedPasswords = new ArrayList<String>();
    private boolean permanent;
    private boolean locked;
    private boolean passwordChangeRequired;
    private boolean validated;
    private int countFailedLoginAttempts;
    private Date accountCreationDate;
    private Date lastLoginDate;
    private String rawPassword;


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String name) {
        this.username = name;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String address) {
        this.email = address;
    }

    @Override
    public String getPassword() {
        return rawPassword;
    }

    @Override
    public void setPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    @Override
    public String getEncodedPassword() {
        return encodedPassword;
    }

    @Override
    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    @Override
    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    @Override
    public void setLastPasswordChange(Date passwordChangeDate) {
        this.lastPasswordChange = lastPasswordChange;
    }

    @Override
    public List<String> getPreviousEncodedPasswords() {
        return previousEncodedPasswords;
    }

    @Override
    public void setPreviousEncodedPasswords(List<String> encodedPasswordList) {
        this.previousEncodedPasswords.clear();
        this.previousEncodedPasswords.addAll(encodedPasswordList);
    }

    @Override
    public void addPreviousEncodedPassword(String encodedPassword) {
        this.previousEncodedPasswords.add(encodedPassword);
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }

    @Override
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean isPasswordChangeRequired() {
        return passwordChangeRequired;
    }

    @Override
    public void setPasswordChangeRequired(boolean changeRequired) {
        this.passwordChangeRequired = changeRequired;
    }

    @Override
    public boolean isValidated() {
        return validated;
    }

    @Override
    public void setValidated(boolean valid) {
        this.validated = valid;
    }

    @Override
    public int getCountFailedLoginAttempts() {
        return countFailedLoginAttempts;
    }

    @Override
    public void setCountFailedLoginAttempts(int count) {
        this.countFailedLoginAttempts = count;
    }

    @Override
    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    @Override
    public void setAccountCreationDate(Date date) {
        this.accountCreationDate = date;
    }

    @Override
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    @Override
    public void setLastLoginDate(Date date) {
        this.lastLoginDate = date;
    }

    @Override
    public String getUserManagerId() {
        return null;
    }
}
