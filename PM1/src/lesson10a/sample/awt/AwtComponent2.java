package lesson10a.sample.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class AwtComponent2 {
    public void createView() {
        Frame viewFrame = new Frame("View");
        viewFrame.setSize(300, 200);
        viewFrame.setLayout(new GridLayout(1, 2));

        Panel panelLeft = new Panel();
        panelLeft.setLayout(new GridLayout(3, 1));
        panelLeft.add(new Button("前進"));
        panelLeft.add(new Button("後退"));
        panelLeft.add(new Button("停止"));

        Panel panelRight = new Panel();
        panelRight.setLayout(new GridLayout(2, 1));
        panelRight.add(new Checkbox("サイレン"));
        panelRight.add(new Checkbox("速度二倍", true));

        viewFrame.add(panelLeft);
        viewFrame.add(panelRight);
        viewFrame.setVisible(true);
    }

    public static void main(String[] args) {
        AwtComponent2 view = new AwtComponent2();
        view.createView();
    }
}
