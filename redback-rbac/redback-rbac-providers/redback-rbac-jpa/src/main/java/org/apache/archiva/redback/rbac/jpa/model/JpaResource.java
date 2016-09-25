package org.apache.archiva.redback.rbac.jpa.model;

import org.apache.archiva.redback.rbac.Resource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by martin on 25.09.16.
 */
@Entity
public class JpaResource implements Resource, Serializable {

    @Id
    @NotNull
    private String identifier;
    private boolean pattern;
    private boolean permanent;


    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean isPattern() {
        return pattern;
    }

    @Override
    public void setPattern(boolean pattern) {
        this.pattern = pattern;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JpaResource that = (JpaResource) o;

        return identifier.equals(that.identifier);

    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
