package lesson15a.ohsho.swing;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizePanel extends Panel implements ActionListener {

    private int ninmae;
    private Button ichininmaeButton;
    private Button nininmaeButton;

    public SizePanel() {
        ninmae = 1;
        createView();
    }

    private void createView() {
        // 1人前ボタンを生成
        ichininmaeButton = new Button("１人前");
        ichininmaeButton.addActionListener(this);
        add(ichininmaeButton);
        // ２人前ボタンを生成
        nininmaeButton = new Button("２人前");
        nininmaeButton.addActionListener(this);
        add(nininmaeButton);
    }

    public int getNinmae() {
        return ninmae;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ichininmaeButton) { // ichininmaeButtonが押されたとき
            ninmae = 1;
        } else if(e.getSource() == nininmaeButton) { // nininmaeButtonが押されたとき
            ninmae = 2;
        }
    }
}
