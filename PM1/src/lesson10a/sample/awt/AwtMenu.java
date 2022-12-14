package lesson10a.sample.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;

public class AwtMenu {

	public void createView() {
		Frame controlFrame = new Frame("Control");
		controlFrame.setSize(200, 160);
		// MenuBar
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("DJ Control");
		MenuItem startMenuItem = new MenuItem("Start");
		menu.add(startMenuItem);
		MenuItem stopMenuItem = new MenuItem("Stop");
		menu.add(stopMenuItem);
		MenuItem exitMenuItem = new MenuItem("Quit");
		menu.add(exitMenuItem);
		menuBar.add(menu);
		controlFrame.setMenuBar(menuBar);
		// 1st row
		TextField bpmTextField = new TextField(2);
		Label bpmLabel = new Label("Enter BPM:");
		Panel enterPanel = new Panel(new GridLayout(1, 2));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);
		// 2nd row
		Button setBPMButton = new Button("Set");
		setBPMButton.setSize(10, 40);
		// 3rd row
		Button increaseBPMButton = new Button(">>");
		Button decreaseBPMButton = new Button("<<");
		Panel buttonPanel = new Panel(new GridLayout(1, 2));
		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);
		// Whole Panel
		Panel insideControlPanel = new Panel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBPMButton);
		insideControlPanel.add(buttonPanel);

		controlFrame.add(insideControlPanel);
		controlFrame.setVisible(true);
	}

	public static void main(String[] args) {
		AwtMenu view = new AwtMenu();
		view.createView();
	}
}
