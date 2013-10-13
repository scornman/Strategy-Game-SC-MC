package strategy.game.common;

public interface StrategyGameObservable {

	 // Registers an observer 
	 void register(StrategyGameObserver observer); 
	 
	 // Removes an observer 
	 void unregister(StrategyGameObserver observer);
	 
}
