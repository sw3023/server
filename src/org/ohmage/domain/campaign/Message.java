package org.ohmage.domain.campaign;

import org.ohmage.util.StringUtils;

public final class Message extends SurveyItem {
	/**
	 * The text to be displayed to the user.
	 */
	private final String text;
	
	/**
	 * Creates a Message object.
	 * 
	 * @param id The message's unqiue identifier.
	 * 
	 * @param condition A string representing the conditions under which this 
	 * 					message should be shown.
	 * 
	 * @param index The messages index in its group of survey items.
	 * 
	 * @param text The text to display to the user.
	 * 
	 * @throws IllegalArgumentException Thrown if the text is null or 
	 * 									whitespace only.
	 */
	public Message(final String id, final String condition, final int index,
			final String text) {
		super(id, condition, index);
		
		if(StringUtils.isEmptyOrWhitespaceOnly(text)) {
			throw new IllegalArgumentException("The text cannot be null or whitespace only.");
		}
		
		this.text = text;
	}
	
	/**
	 * Returns the text of this message.
	 * 
	 * @return The text of this message.
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Returns the number of survey items that this represents which is always
	 * exactly 1.
	 * 
	 * @return 1
	 */
	@Override
	public int getNumSurveyItems() {
		return 1;
	}
	
	/**
	 * Always returns 0 as this is not a prompt and doesn't contain any
	 * subprompts.
	 * 
	 * @return 0
	 */
	@Override
	public int getNumPrompts() {
		return 0;
	}

	/**
	 * Creates a hash code for this message.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	/**
	 * Determines if this Message object is equal to another object.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}