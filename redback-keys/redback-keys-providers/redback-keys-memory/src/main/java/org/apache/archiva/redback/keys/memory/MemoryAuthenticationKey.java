package org.apache.archiva.redback.keys.memory;

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

import org.apache.archiva.redback.keys.AuthenticationKey;

import java.util.Date;

/**
 * MemoryAuthenticationKey
 *
 * @author <a href="mailto:joakim@erdfelt.com">Joakim Erdfelt</a>
 *
 */
public class MemoryAuthenticationKey
    implements AuthenticationKey
{
    private String key;

    private String forPrincipal;

    private String purpose;

    private Date dateCreated;

    private Date dateExpires;

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public Date getDateExpires()
    {
        return dateExpires;
    }

    public String getForPrincipal()
    {
        return forPrincipal;
    }

    public String getKey()
    {
        return key;
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setDateCreated( Date dateCreated )
    {
        this.dateCreated = dateCreated;
    }

    public void setDateExpires( Date dateExpires )
    {
        this.dateExpires = dateExpires;
    }

    public void setForPrincipal( String forPrincipal )
    {
        this.forPrincipal = forPrincipal;
    }

    public void setKey( String key )
    {
        this.key = key;
    }

    public void setPurpose( String purpose )
    {
        this.purpose = purpose;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append( "MemoryAuthenticationKey[" );
        sb.append( "key=" ).append( key );
        sb.append( ",forPrincipal=" ).append( forPrincipal );
        sb.append( ",purpose=" ).append( purpose );
        sb.append( ",dateCreated=" ).append( dateCreated );
        sb.append( ",dateExpired=" ).append( dateExpires );
        sb.append( ']' );

        return sb.toString();
    }
}
