package lesson15a.sample;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FruitsViewAWT implements ActionListener {
    private final Dimension DIMENSION = new Dimension(500, 75); // 表示フレームの幅，高さ
    private Checkbox apple, banana, cherry; // チェックボックス
    private Button button; // 選択ボタン

    /**
     * 各種パネルを表示する
     */
    public void createView() {
        Frame frame = new Frame("フルーツ選択"); // 表示フレームの生成
        Panel panel = new Panel(); // パネルを生成

        apple = new Checkbox("リンゴ", true);
        // 「リンゴ」のチェックボックス．第２引数がtrueなので，初期状態で選択状態
        banana = new Checkbox("バナナ");
        // 「バナナ」のチェックボックス
        cherry = new Checkbox("さくらんぼ");
        // 「さくらんぼ」のチェックボックス
        button = new Button("選択");

        // パネルにチェックボックスなどを追加
        Label label = new Label("好きなフルーツ：");
        panel.add(label);
        panel.add(apple);
        panel.add(banana);
        panel.add(cherry);
        panel.add(button);

        // ActionListenerへの追加
        button.addActionListener(this);

        frame.add(panel); // パネルをフレームに貼付ける
        frame.setSize(DIMENSION); // フレームのサイズをセット
        frame.setVisible(true); // フレームを表示する
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.print("私が好きなフルーツ：");

            if (apple.getState()) {
                System.out.print("リンゴ ");
            }
            if (banana.getState()) {
                System.out.print("バナナ ");
            }
            if (cherry.getState()) {
                System.out.print("さくらんぼ ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        FruitsViewAWT fv = new FruitsViewAWT();
        fv.createView();
    }
}
