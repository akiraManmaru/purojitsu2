package cardgame.blackjack;

import cardgame.blackjack.gui.AWBetDialog;
import cardgame.blackjack.gui.BetDialog;
import cardgame.blackjack.gui.BlackJackDialog;
import cardgame.blackjack.gui.ChoiceDialog;
import cardgame.blackjack.gui.JoinDialog;
import cardgame.blackjack.gui.SWBetDialog;
import cardgame.blackjack.gui.factory.AWWidgetFactory;
import cardgame.blackjack.gui.factory.SWWidgetFactory;
import cardgame.blackjack.gui.factory.WidgetFactory;
import cardgame.blackjack.strategy.BasicStrategy;
import cardgame.blackjack.strategy.BearStrategy;
import cardgame.blackjack.strategy.BullStrategy;
import cardgame.blackjack.strategy.HumanStrategy;
import cardgame.blackjack.strategy.RandomStrategy;
import cardgame.blackjack.strategy.SimpleStrategy;
import cardgame.blackjack.strategy.Strategy;
import cardgame.blackjack.strategy.TwentyoneStrategy;

public class ExtendedBlackJackPlayer extends BlackJackPlayer {

	public WidgetFactory factory;
	{
		String GUI = BlackJack.getGUI();
		if (GUI.equals(BlackJack.AWT)) {
			factory = AWWidgetFactory.getInstance();
		} else if (GUI.equals(BlackJack.SWING)) {
			factory = SWWidgetFactory.getInstance();
		}
	}

	protected void createStrategy() {
		if (human) {
			strategy = new HumanStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BasicStrategy.name())) {
			strategy = new BasicStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BearStrategy.name())) {
			strategy = new BearStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.BullStrategy.name())) {
			strategy = new BullStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.SimpleStrategy.name())) {
			strategy = new SimpleStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.RandomStrategy.name())) {
			strategy = new RandomStrategy();
		} else if (strategyName.equals(Strategy.STRATEGY.TwentyoneStrategy.name())) {
			strategy = new TwentyoneStrategy();
		} else {
			strategy = null;
			System.err.println(strategyName + "が存在しません");
			System.exit(1);
		}
	}

	public BlackJackDialog createJoinDialog() {
		return new JoinDialog(factory);
	}

	public BlackJackDialog createBetDialog() {
		String GUI = BlackJack.getGUI();
		BetDialog betDialog = null;
		if (GUI.equals(BlackJack.AWT)) {
			betDialog = new AWBetDialog();
		} else if (GUI.equals(BlackJack.SWING)) {
			betDialog = new SWBetDialog();
		}
		return betDialog;
	}

	public BlackJackDialog createChoiceDialog() {
		return new ChoiceDialog(factory);
	}

}
