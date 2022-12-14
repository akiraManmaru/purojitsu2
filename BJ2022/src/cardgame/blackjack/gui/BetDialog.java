package cardgame.blackjack.gui;

import java.awt.event.ActionListener;

import kwing.*;
import cardgame.Player;

/**
 * ベットダイアログ
 * 
 * @author Hiroki Tanaka
 * @author Shiro Takata
 * 
 * @version 2.0, 2007/12/05
 * @version 3.2, 2019/12/06
 */
public abstract class BetDialog extends BlackJackDialog{

	/**
	 * Player
	 */
	Player player;
	
	/**
	 * 賭けチップ
	 */
	private int betChips;
	
	/**
	 * BetDialogのコンンストラクタ
	 */
	public BetDialog() {
	}

	/**
	 * Player情報を用いたダイアログの構築
	 */
	@Override
	public void displayDialog(Player player) {
		
		this.player = player;
		
		/* タイマー */
		timer = createTimer(DIALOG_DISPLAY_TIME, this);

		/* プレイヤー情報 */
		playerInfoPanel = createPanel();
		playerInfoPanel.setLayout(createFlowLayout());
		
		/* 座席番号 */
		seatNumberLabel = createLabel();
		seatNumberLabel.setText("座席番号：" + String.valueOf(player.getSeatNumber()));
		playerInfoPanel.add(seatNumberLabel);
		
		/* プレイヤー名 */
		nameLabel = createLabel();
		nameLabel .setText("名前：" + player.getName());
		playerInfoPanel.add(nameLabel);
		
		/* 戦略名 */
		strategyNameLabel = createLabel();
		strategyNameLabel.setText("戦略：" + player.getStrategyName());
		playerInfoPanel.add(strategyNameLabel);
		
		/* チップ情報 */
		chipsValuePanel = createPanel();
		chipsValuePanel.setLayout(createFlowLayout());
		
		/* 購入チップ */
		exchangeChipsLabel = createLabel();
		exchangeChipsLabel.setText("購入チップ:"+ String.valueOf(player.getExchangeChips()));
		chipsValuePanel.add(exchangeChipsLabel);
		
		/* 所持チップ */
		chipsValueLabel = createLabel();
		chipsValuePanel.add(chipsValueLabel);
	
		/* ベットするかどうか */
		betMessagePanel = createPanel();
		betMessagePanel.setLayout(createFlowLayout());
		betMessageLabel = createLabel();
		betMessageLabel.setText("ベットしますか ?");	
		betMessagePanel.add(betMessageLabel);

		/* ベットラジオパネル */
		betPanel = createPanel();
		betPanel.setLayout(createFlowLayout());
		
		/* ベットするラジオボタン */
		betRadioButton = createRadioButton();
		betRadioButton.addActionListener(this);
		betRadioButton.setText("ベットする");
		betRadioButton.setSelected(true);
		betPanel.add(betRadioButton);
		
		/* ベットしないラジオボタン */
		noBetRadioButton = createRadioButton();
		noBetRadioButton.addActionListener(this);
		noBetRadioButton.setText("ベットしない");
		betPanel.add(noBetRadioButton);
		
		/* ベットチップ数 */
		betChipsPanel = createPanel();
		betChipsPanel.setLayout(createFlowLayout());	
		betChipsTextField = createTextField();
		betChipsTextField.setColumns(4);
		betChipsPanel.add(betChipsTextField);

		/* ボタン */
		okButtonPanel = createPanel();
		okButtonPanel.setLayout(createFlowLayout());
		okButton = createButton();
		okButton.setText("OK");
		okButton.addActionListener(this);
		okButtonPanel.add(okButton);

		/* ステータス */
		statusPanel = createPanel();
		statusLabel = createLabel();
		statusPanel.add(statusLabel);

		/* 土台 */
		globePanel = createPanel();

		/* レイアウト */
		gridLayout = createGridLayout();
		gridLayout.setColumns(1);
		gridLayout.setRows(7);
		
		globePanel.setLayout(gridLayout);
		globePanel.add(playerInfoPanel);
		globePanel.add(chipsValuePanel);
		globePanel.add(betMessagePanel);
		globePanel.add(betPanel);
		globePanel.add(betChipsPanel);
		globePanel.add(okButtonPanel);
		globePanel.add(statusPanel);

		/* ダイアログ */
		dialog = createDialog();
		dialog.setTitle("bet : ");
		dialog.setResizable(false);
		dialog.add(globePanel);
		
	}

	/**
	 * ダイアログを開く
	 */
	@Override
	public void redisplayDialog() {
		
		/* 戦略名、前回掛けチップ数と所持チップ数の表示 */
		strategyNameLabel.setText("戦略：" + player.getStrategyName());
		betChips = player.getBetChips(); 
		betChipsTextField.setText(String.valueOf(betChips));
		chipsValueLabel.setText("所持チップ:"+ String.valueOf(player.getChipsValue()));
		
		statusLabel.setText("");
		if (player.isHuman()) {
			betChipsTextField.setEnabled(true);
			betRadioButton.setSelected(true);
		} else {
			timer.start();
			betRadioButton.setEnabled(false);
			noBetRadioButton.setEnabled(false);
			betChipsTextField.setEnabled(false);
			betChipsTextField.setEditable(false);
			okButton.setEnabled(false);

			if (Integer.parseInt(betChipsTextField.getText()) <= 0) {
				betRadioButton.setSelected(false);
				noBetRadioButton.setSelected(true);
			}
		}

		/* ダイアログ */
		dialog.pack();
		dialog.setVisible(true);
	}

	/**
	 * イベントを仲介する
	 * 
	 * @param source イベントオブジェクト
	 */
	public void mediateEvent(Object source) {

		if (source.equals(timer.getWidget())) {
			closeDialog();
		} else if (source.equals(betRadioButton.getWidget())) {
			betChipsTextField.setEnabled(true);
		} else if (source.equals(noBetRadioButton.getWidget())) {
			betChips = 0;
			betChipsTextField.setText(String.valueOf(betChips));
			betChipsTextField.setEnabled(false);
		} else if (source.equals(okButton.getWidget())) {
			if (verify()) {
				closeDialog();
			}
		}
	}

	/**
	 * 入力された値を検証する
	 * 
	 * @return 検証結果（真-true, 偽-false）
	 */
	public boolean verify() {
		boolean isCorrect = true;

		if (!(betRadioButton.isSelected())) {
		} else {

			try {
				betChips = Integer.parseInt(betChipsTextField.getText());
				if (betChips <= 0 || player.getChipsValue() < betChips) {
					statusLabel.setText("所持金より少ない正の整数を入力してください!!");
					isCorrect = false;
				}	
			} catch (NumberFormatException error) {// 数字以外を入力した時
				statusLabel.setText("数字を入力してください !!");
				isCorrect = false;
			}
		}

		dialog.pack();
		return isCorrect;
	}

	/**
	 * ダイアログを閉じる
	 */
	public void closeDialog() {
		timer.stop();
		dialog.setVisible(false);
		player.setBetChips(betChips);
	}
	
	/**
	 * タイマーを生成する
	 * @param time 時刻
	 * @param listener アクションリスナー
	 * @return タイマーインスタンス
	 */
	public abstract Timer createTimer(int time, ActionListener listener);

	
	/**
	 * Graphicsを生成する
	 * 
	 * @param WIDTH パレットの幅
	 * @param HEIGHT パレットの高さ
	 * @return グラフィックス
	 */
	public abstract Graphics createGraphics(int WIDTH, int HEIGHT);

	/**
	 * Frameを生成する
	 * 
	 * @return フレーム
	 */
	public abstract Frame createFrame();

	/**
	 * パネルを生成する
	 * 
	 * @return パネル
	 */
	public abstract Panel createPanel();

	/**
	 * ボーダーレイアウトを生成する
	 * 
	 * @return ボーダーレイアウト
	 * 
	 */
	public abstract BorderLayout createBorderLayout();

	/**
	 * フローレイアウトを生成する
	 * 
	 * @return フローレイアウト
	 */
	public abstract FlowLayout createFlowLayout();

	/**
	 * グリッドレイアウトを生成する
	 * 
	 * @return グリッドレイアウト
	 */
	public abstract GridLayout createGridLayout();

	/**
	 * ラベルを生成する
	 * 
	 * @return ラベル
	 */
	public abstract Label createLabel();

	/**
	 * テキストフィールドを生成する
	 * 
	 * @return テキストフィールド
	 */
	public abstract TextField createTextField();

	/**
	 * ボタンを生成する
	 * 
	 * @return ボタン
	 */
	public abstract Button createButton();

	/**
	 * ダイアログを生成する
	 * 
	 * @return ダイアログ
	 */
	public abstract Dialog createDialog();

	/**
	 * ラジオボタンを生成する
	 * 
	 * @return ラジオボタン
	 */
	public abstract RadioButton createRadioButton();

}