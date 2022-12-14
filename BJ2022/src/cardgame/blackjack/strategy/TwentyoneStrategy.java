package cardgame.blackjack.strategy;

import cardgame.Hand;
import cardgame.Player;
import cardgame.blackjack.BlackJackRule;

/*
 * 21以外は認めないクラス
 */

public class TwentyoneStrategy implements Strategy {

	@Override
	public int decideBetChipsValue(Player player) {
		int chipsValue = player.getChipsValue();
		int betChips = chipsValue / 5;
		if (betChips <= 0) {
			betChips = chipsValue;
		}

		/*追加したテストコード*/
		//System.out.println(betChips);

		return betChips;
	}

	@Override
	public boolean isGettingHit(Player player) {
		boolean isHit = false;
		Hand hand = player.getTable().getHand(player.getSeatNumber());

		if (BlackJackRule.totalHand(hand) < 21) {
			isHit = true;
		}

		return isHit;
	}

}
