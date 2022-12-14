package baseball.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import baseball.League;
import baseball.Order;
import baseball.PlayerType;
import baseball.SetPlayers;
import baseball.SetPlayersInterface;

public class TinyBaseballView implements ActionListener {

	private final static String PITCHER_FILENAME = "pitchers.csv"; // Pitcher用データファイル名
	private final static String BATTER_FILENAME = "batters.csv"; // Batter用データファイル名

	private final int FRAME_WIDTH = 500; // フレームの幅
	private final int FRAME_HEIGHT = 200; // フレームの高さ
	private JButton b1;
	private Dimension UPPER_DIMENSION;

	// 選択可能なorder
	private final String[][] PITCHER_KEY = {
			{ "試合数順", "pitcher game" },
			{ "勝利数順", "pitcher win" }
	};
	private final String[][] BATTER_KEY = {
			{ "打率順", "batter average" },
			{ "本塁打数順", "batter homerun" }
	};

	// ボタンにより選択されたorderとPlayerType
	private Order order = Order.NONE;
	private PlayerType playerType = PlayerType.BOTH;

	// リーグ選択
	private JCheckBox pacificCkBox; // パシフィックリーグを選択するチェックボックス
	private JCheckBox centralCkBox; // セントラルリーグを選択するチェックボックス

	// データベース管理
	private SetPlayersInterface spi;

	public TinyBaseballView() {
		spi = new SetPlayers();
		spi.scanPlayers(PITCHER_FILENAME, BATTER_FILENAME);
	}

	/**
	 * 各種パネルを表示する
	 */
	public void createView() {
		/* 表示フレームを生成し、レイアウトとサイズを設定する */
		JFrame frame = new JFrame("BaseBall Database");
		UPPER_DIMENSION = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

		/* 上部パネルを生成する */
		JPanel p1 = new JPanel(new GridLayout(2, 1));

		/* 下部パネルを生成し、レイアウトを設定する */
		JPanel p2 = new JPanel(new GridLayout(1, 3));

		/* 下部パネル：リーグ選択用にチェックボックスを2つ生成し、パネルに追加する */
		pacificCkBox = new JCheckBox("パシフィックリーグ");
		pacificCkBox.addActionListener(this);
		p2.add(pacificCkBox);

		centralCkBox = new JCheckBox("セントラルリーグ");
		centralCkBox.addActionListener(this);
		p2.add(centralCkBox);

		/* 下部パネル：実行ボタンを生成、アクションリスナとアクションコマンドを設定し、
		   パネルに追加する */
		b1 = new JButton("実行");
		b1.addActionListener(this);
		p2.add(b1);

		/* フレームに上部パネルと下部パネルを追加する */
		frame.add(p1);
		p1.add(createOrderPanel());
		p1.add(p2);
		frame.add(p1);
		/* フレームを表示する */
		frame.setSize(UPPER_DIMENSION);
		frame.setVisible(true);
	}

	/**
	 * order選択のパネルを作る
	 */
	private JPanel createOrderPanel() {
		JPanel ret = new JPanel(new GridLayout(1, 2));
		ret.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ButtonGroup selectOrderGroup = new ButtonGroup();

		// ピッチャーのorder
		JPanel pPanel = new JPanel(new GridLayout(3, 1));
		JLabel pLabel = new JLabel("ピッチャー");
		pPanel.add(pLabel);
		for (int i = 0; i < PITCHER_KEY.length; i++) {
			JRadioButton button = new JRadioButton(PITCHER_KEY[i][0], true);
			button.setActionCommand(PITCHER_KEY[i][1]);
			selectOrderGroup.add(button);
			pPanel.add(button);
			button.addActionListener(this);
		}

		// バッターのorder
		JPanel bPanel = new JPanel(new GridLayout(3, 1));
		JLabel bLabel = new JLabel("バッター");
		bPanel.add(bLabel);
		for (int i = 0; i < BATTER_KEY.length; i++) {
			JRadioButton button = new JRadioButton(BATTER_KEY[i][0], true);
			button.setActionCommand(BATTER_KEY[i][1]);
			selectOrderGroup.add(button);
			bPanel.add(button);
			button.addActionListener(this);
		}

		ret.add(pPanel);
		ret.add(bPanel);
		return ret;
	}

	/**
	 * 現在チェックされているリーグを返す
	 */
	public League getLeague() {
		League ret = League.NONE;

		/* 現在チェックされているチェックボックスによって場合分けして処理する */

		return ret;
	}

	public void actionPerformed(ActionEvent event) { // 実行ボタンのイベントリスナー
		String command = b1.getActionCommand();

		if (command.equals("exec")) {
			League league = getLeague();

			if (league != League.NONE) { // リーグの選択があるときのみ実行
				/* LeagueとPlayerTypeを設定、
				   現在選択されているOrderでソートして、
				   結果をファイルに出力する */
				spi = new SetPlayers();
				spi.sort(order);
				spi.dumpResult();

			} else {
				spi.clearPlayers();
			}
		} else if (command.equals(PITCHER_KEY[0][1])) { // ピッチャー、試合数順を選択
			playerType = PlayerType.PITCHER;
			order = Order.GAME;
		} else if (command.equals(PITCHER_KEY[1][1])) { // ピッチャー、勝利数順を選択
			playerType = PlayerType.PITCHER;
			order = Order.WIN;
		} else if (command.equals(BATTER_KEY[0][1])) { // バッター、打率順を選択
			playerType = PlayerType.BATTER;
			order = Order.AVERAGE;
		} else if (command.equals(BATTER_KEY[1][1])) { // バッター、本塁打数順を選択
			playerType = PlayerType.BATTER;
			order = Order.HOMERUN;
		}
	}

}