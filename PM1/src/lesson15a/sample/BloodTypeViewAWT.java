package lesson15a.sample;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class BloodTypeViewAWT implements ItemListener {
    private final Dimension DIMENSION = new Dimension(500, 75); // 表示フレームの幅，高さ
    private Checkbox a, b, o, ab; // ラジオボタン

    /**
     * 各種パネルを表示する
     */
    public void createView() {
        Frame frame = new Frame("血液型選択"); // 表示フレームの生成
        Panel panel = new Panel(); // パネルを生成

        CheckboxGroup cbg = new CheckboxGroup();
        // このCheckboxGroupをCheckboxに指定することで，ラジオボタンになる
        a = new Checkbox("A型", true, cbg);
        // 「A型」のラジオボタン．第２引数がtrueなので，初期状態で選択状態
        b = new Checkbox("B型", false, cbg);
        // 「B型」のラジオボタン．初期状態では選択されていない
        o = new Checkbox("O型", false, cbg);
        // 「O型」のラジオボタン．初期状態では選択されていない
        ab = new Checkbox("AB型", false, cbg);
        // 「AB型」のラジオボタン．初期状態では選択されていない

        // パネルにラジオボタンを追加
        Label label = new Label("右から血液型を選んでください：");
        panel.add(label);
        panel.add(a);
        panel.add(b);
        panel.add(o);
        panel.add(ab);

        // ItemListenerへの追加（ActionListenerではない）
        a.addItemListener(this);
        b.addItemListener(this);
        o.addItemListener(this);
        ab.addItemListener(this);

        frame.add(panel); // パネルをフレームに貼付ける
        frame.setSize(DIMENSION); // フレームのサイズをセット
        frame.setVisible(true); // フレームを表示する
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == a) {
            System.out.println("A型");
        } else if (e.getSource() == b) {
            System.out.println("B型");
        } else if (e.getSource() == ab) {
            System.out.println("AB型");
        } else if (e.getSource() == o) {
            System.out.println("O型");
        }
    }
    
    public static void main(String[] args) {
        BloodTypeViewAWT btv = new BloodTypeViewAWT();
        btv.createView();
    }
}
