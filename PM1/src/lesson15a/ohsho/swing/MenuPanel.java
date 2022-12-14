package lesson15a.ohsho.swing;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends Panel implements ActionListener {

    private String menu;
    private Button gyozaButton;
    private Button chahanButton;
    
    public MenuPanel() {
        menu = null;
        createView();
    }

    private void createView() {
        // ギョーザボタンを生成
        gyozaButton = new Button("ギョーザ");
        gyozaButton.addActionListener(this);
        add(gyozaButton);
        // チャーハンボタンを生成
        chahanButton = new Button("チャーハン");
        chahanButton.addActionListener(this);
        add(chahanButton);
    }

    public String getMenu() {
        return menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gyozaButton) { // gyozaButtonが押されたとき
            menu = "ギョーザ";
        } else if(e.getSource() == chahanButton) { // chahanButtonが押されたとき
            menu = "チャーハン";
        }
    }
}
