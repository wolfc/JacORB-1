package org.jacorb.security.sas;

/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 2002-2003 Gerald Brose
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

import org.apache.avalon.framework.logger.Logger;
import org.omg.GSSUP.InitialContextToken;
import org.omg.PortableInterceptor.ClientRequestInfo;
import org.omg.PortableInterceptor.ServerRequestInfo;

public class GssUpContext implements ISASContext
{
	private static Logger logger = org.jacorb.util.Debug.getNamedLogger("jacorb.SAS");
    private InitialContextToken initialContextToken = null;

    public boolean validate(ServerRequestInfo ri, byte[] contextToken) {
        initialContextToken = org.jacorb.security.sas.GSSUPNameSpi.decode(contextToken);
        return true;
    }

    public String getPrincipalName() {
        if (initialContextToken == null) return null;
        return new String(initialContextToken.username);
    }

	/* (non-Javadoc)
	 * @see org.jacorb.security.sas.ISASContext#createContext(org.omg.PortableInterceptor.ClientRequestInfo)
	 */
	public byte[] createContext(ClientRequestInfo ri) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jacorb.security.sas.ISASContext#getCreatedPrincipal()
	 */
	public String getCreatedPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.jacorb.security.sas.ISASContext#validateContext(org.omg.PortableInterceptor.ServerRequestInfo, byte[])
	 */
	public boolean validateContext(ServerRequestInfo ri, byte[] contextToken) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.jacorb.security.sas.ISASContext#getValidatedPrincipal()
	 */
	public String getValidatedPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
}