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
 * 
 */
public interface ValidateConfigurationBehavior {

	/**
	 * Determines whether the starting piece configurations are valid according
	 * to some configuration rule.
	 */
	public boolean isConfigurationValid();

}
