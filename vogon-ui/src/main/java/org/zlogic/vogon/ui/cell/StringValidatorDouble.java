/*
 * Vogon personal finance/expense analyzer.
 * Licensed under Apache 2.0 License: http://www.apache.org/licenses/LICENSE-2.0
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.vogon.ui.cell;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zlogic.vogon.ui.ExceptionLogger;

/**
 * Validator which validates integer/double values.
 *
 * @author Dmitry Zolotukhin <a
 * href="mailto:zlogic@gmail.com">zlogic@gmail.com</a>
 */
public class StringValidatorDouble implements StringCellValidator {

	/**
	 * The logger
	 */
	private final static Logger log = Logger.getLogger(StringValidatorDouble.class.getName());
	/**
	 * Localization messages
	 */
	private java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("org/zlogic/vogon/ui/messages");

	/**
	 * Constructs a StringValidatorDouble
	 *
	 * @param exceptionHandler the exception handler
	 */
	public StringValidatorDouble() {
	}

	@Override
	public boolean isValid(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException ex) {
			log.log(Level.SEVERE, null, ex);
			ExceptionLogger.getInstance().showException(MessageFormat.format(messages.getString("CANNOT_PARSE_NUMBER"), new Object[]{value, ex.getMessage()}), ex);
			return false;
		}
	}
}
