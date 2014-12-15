package com.sirma.itt.javacourse.designpatterns.mail;

/**
 * The class {@link Mail} contains methods for constructing Mail object containing sample fields.
 * 
 * XXX: When is this pattern used? What are its minuses?
 */
public class Mail {
	private String from = null;
	private String to = null;
	private String subject = null;
	private String content = null;
	private String[] cc = null;
	private Object[] attachments = null;

	/**
	 * Constructs a mail object assigning the origin.
	 * 
	 * @param from
	 *            the origin of the mail
	 */
	public Mail(String from) {
		this.from = from;
	}

	/**
	 * Attaches or changes the origin of the mail.
	 * 
	 * @param from
	 *            the origin of the mail
	 * @return the mail with the new field attached
	 */
	public Mail attachFrom(String from) {
		this.from = from;
		return this;
	}

	/**
	 * Attaches or changes the destination of the mail.
	 * 
	 * @param to
	 *            the destination of the mail
	 * @return the mail with the new field attached
	 */
	public Mail attachTo(String to) {
		this.setTo(to);
		return this;
	}

	/**
	 * Attaches or changes the subject of the mail.
	 * 
	 * @param subject
	 *            the subject of the mail
	 * @return the mail with the new field attached
	 */
	public Mail attachSubject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Attaches or changes the content of the mail.
	 * 
	 * @param content
	 *            the content of the mail
	 * @return the mail with the new field attached
	 */
	public Mail attachContent(String content) {
		this.content = content;
		return this;
	}

	/**
	 * Attaches or changes other destinations.
	 * 
	 * @param cc
	 *            the other destinations
	 * @return the mail with the new field attached
	 */
	public Mail attachCC(String[] cc) {
		this.cc = cc;
		return this;
	}

	/**
	 * Attaches or changes the attachments to the mail.
	 * 
	 * @param attachments
	 *            the attachments to the mail
	 * @return the mail with the new field attached
	 */
	public Mail attachAttachments(Object[] attachments) {
		this.attachments = attachments;
		return this;
	}

	/**
	 * Gets the origin.
	 * 
	 * @return the origin of the mail
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Gets the destination.
	 * 
	 * @return the destination of the mail
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets a new destination.
	 * 
	 * @param to
	 *            a new destination of the mail
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject of the mail
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets a new subject.
	 * 
	 * @param subject
	 *            a new subject of the mail
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the content.
	 * 
	 * @return the content of the mail
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets a new content.
	 * 
	 * @param content
	 *            a new content of the mail
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the secondary destinations.
	 * 
	 * @return the secondary destinations of the mail
	 */
	public String[] getCc() {
		return cc;
	}

	/**
	 * Sets secondary destinations.
	 * 
	 * @param cc
	 *            new secondary destinations
	 */
	public void setCc(String[] cc) {
		this.cc = cc;
	}

	/**
	 * Gets the attachments.
	 * 
	 * @return the attachments to the mail
	 */
	public Object[] getAttachments() {
		return attachments;
	}

	/**
	 * Sets new attachments.
	 * 
	 * @param attachments
	 *            new attachments to the mail
	 */
	public void setAttachments(Object[] attachments) {
		this.attachments = attachments;
	}
}
