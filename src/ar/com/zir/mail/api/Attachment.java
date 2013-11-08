/*
    Copyright 2012 Juan Martín Runge
    
    jmrunge@gmail.com
    http://www.zirsi.com.ar
    
    This file is part of MailApi.

    MailApi is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MailApi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MailApi.  If not, see <http://www.gnu.org/licenses/>.
*/
package ar.com.zir.mail.api;

import java.io.Serializable;

/**
 * Class that represents the attachments
 * 
 * @author jmrunge
 * @version 1.00
 */
public class Attachment implements Serializable {
    private String name;
    private byte[] data;
    private String mime;

    /**
     * Constructor
     */
    public Attachment() {
    }

    /**
     * Getter method
     * 
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Setter method
     * 
     * @param data data to attach
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * Getter method
     * 
     * @return the name of the attachment
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method
     * 
     * @param name the name of the attachment
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method
     * 
     * @return the mime type of the attachment
     */
    public String getMime() {
        return mime;
    }

    /**
     * Setter method
     * 
     * @param mime the mime type of the attachment
     */
    public void setMime(String mime) {
        this.mime = mime;
    }
    
}
