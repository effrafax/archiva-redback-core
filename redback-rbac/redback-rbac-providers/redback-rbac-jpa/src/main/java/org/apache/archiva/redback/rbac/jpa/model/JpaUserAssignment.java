package org.apache.archiva.redback.rbac.jpa.model;

import org.apache.archiva.redback.rbac.AbstractUserAssignment;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin Stockhammer <martin_s@apache.org> on 26.09.16.
 */
@Entity
public class JpaUserAssignment extends AbstractUserAssignment {

    @Id
    private String principal;
    @ElementCollection
    private List<String> roleNames = new ArrayList<String>();
    private boolean permanent = false;

    @Override
    public String getPrincipal() {
        return principal;
    }

    @Override
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public List<String> getRoleNames() {
        return roleNames;
    }

    @Override
    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    @Override
    public boolean isPermanent() {
        return permanent;
    }

    @Override
    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }
}
