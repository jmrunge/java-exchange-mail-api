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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the mail that will be sent by the mail server
 * 
 * @author jmrunge
 * @see ar.com.zir.mail.server.MailServer
 */
public class Mail implements Serializable {
    private String sender;
    private String subject;
    private List<String> recipients;
    private String message;
    private List<Attachment> attachments;

    /**
     * Constructor
     */
    public Mail() {
    }

    /**
     * Getter method
     * 
     * @return the list of attachments
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * Setter method
     * 
     * @param attachments the list of attachments
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    /**
     * Getter method
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method
     * 
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method
     * 
     * @return the list of recipients
     */
    public List<String> getRecipients() {
        return recipients;
    }

    /**
     * Setter method
     * 
     * @param recipients the list of recipients
     */
    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    /**
     * Getter method
     * 
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * Setter method
     * 
     * @param sender the sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Getter method
     * 
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Setter method
     * 
     * @param subject the subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
     * Method for adding recipients
     * 
     * @param recipient the recipient to add
     */
    public void addRecipient(String recipient) {
        if (recipients == null)
            recipients = new ArrayList<String>();
        recipients.add(recipient);
    }
    
    /**
     * Method for adding attachments
     * 
     * @param file the file to attach
     */
    public void addAttachment(File file) throws FileNotFoundException, IOException {
        Attachment attachment = new Attachment();
        attachment.setName(file.getName());
        byte[] b = new byte[(int)file.length()];
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(b, 0, b.length);
        attachment.setData(b);
        addAttachment(attachment);
    }
    
    /**
     * Method for adding attachments
     * 
     * @param data the byte[] data to attach
     * @param name the name of the attachment
     * @param mime the mime type of the attachment
     */
    public void addAttachment(byte[] data, String name, String mime) {
        Attachment attachment = new Attachment();
        attachment.setData(data);
        attachment.setMime(mime);
        attachment.setName(name);
        addAttachment(attachment);
    }
    
    /**
     * Method for adding attachments
     * 
     * @param attachment the attachment object to add
     * @see ar.com.zir.mail.api.Attachment
     */
    public void addAttachment(Attachment attachment) {
        if (attachments == null) 
            attachments = new ArrayList<Attachment>();
        attachments.add(attachment);
    }
    
    /**
     * String representation of the object
     * 
     * @return a String which will show sender, recipients, subject, message and attachments of the object
     */
    @Override
    public String toString() {
        String s = "Sender: " + sender + "\n";
        s = s + "Recipients: ";
        for (String aux : recipients) {
            s = s + aux + "\n";
        }
        s = s + "Subject: " + subject + "\n";
        s = s + "Message: " + message + "\n";
        if (attachments != null && !attachments.isEmpty()) {
            s = s + "Attachments: ";
            for (Attachment aux : attachments) {
                s = s + aux.getName() + "\n";
            }
        }
        return s;
    }
}
