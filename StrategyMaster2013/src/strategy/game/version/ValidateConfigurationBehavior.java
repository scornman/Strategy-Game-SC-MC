/**
 * 
 */
package strategy.game.version;

/**
 * Strategy Pattern interface for encapsulating the validation of starting piece
 * configurations.
 * 
 * @author Madalyn
 * @author Scott
 * @version 9/22/13
 * 
 */
public interface ValidateConfigurationBehavior {

	/**
	 * Determines whether the starting piece configurations are valid according
	 * to some configuration rule.
	 * 
	 * @return true if the starting configurations are valid according to this
	 *         condition.
	 */
	boolean isConfigurationValid();

}
