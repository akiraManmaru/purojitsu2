package lesson15a.sample;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class FruitsView implements ActionListener {
    private final Dimension DIMENSION = new Dimension(500, 75);  // 表示フレームの幅，高さ
    private JCheckBox apple, banana, cherry; // チェックボックス
    private JButton button; // 選択ボタン

    /**
     * 各種パネルを表示する
     */
    public void createView() {
        JFrame frame = new JFrame("フルーツ選択"); // 表示フレームの生成
        JPanel panel = new JPanel(); // パネルを生成

        apple = new JCheckBox("リンゴ", true);
        // 「リンゴ」のチェックボックス。第２引数がtrueなので、初期状態で選択状態
        banana = new JCheckBox("バナナ");
        // 「バナナ」のチェックボックス
        cherry = new JCheckBox("さくらんぼ");
        // 「さくらんぼ」のチェックボックス
        button = new JButton("選択");

        // パネルにチェックボックスなどを追加
        JLabel label = new JLabel("好きなフルーツ：");
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

            if (apple.isSelected()) {
                System.out.print("リンゴ ");
            }
            if (banana.isSelected()) {
                System.out.print("バナナ ");
            }
            if (cherry.isSelected()) {
                System.out.print("さくらんぼ ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        FruitsView fv = new FruitsView();
        fv.createView();
    }
}
