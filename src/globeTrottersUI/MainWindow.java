package globeTrottersUI;

import globeTrotters.ConstructTourPackageA;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import tour.TourPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainWindow implements ActionListener, ItemListener {

	TourPackage pkgA;

	public void drawUI() {
		
		this.constructPkgA();

		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));

		// 1. Create frame and title
		JFrame frame = new JFrame("GlobeTrotter Reservation System");

		JLabel title = new JLabel("Welcome to GlobeTrotter Reservation System",
				JLabel.CENTER);

		Font labelfont = new Font("Serif", Font.BOLD, 30);
		title.setFont(labelfont);

		frame.getContentPane().add(BorderLayout.NORTH, title);

		// 2. Add the left panel with combo box and list of destinations
		JPanel leftPanel = new JPanel(new BorderLayout());
		frame.getContentPane().add(BorderLayout.WEST, leftPanel);

		JComboBox combo = new JComboBox();

		combo.addItem("Tour Package A");

		combo.addItem("Tour Package B");

		combo.addItemListener(this);
		leftPanel.add(BorderLayout.NORTH, combo);

		JList destList = new JList(pkgA.getNameList());
		
		leftPanel.add(BorderLayout.CENTER, destList);

		// 3. Add a panel at the bottom with Button and price label

		JPanel bottomPanel = new JPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

		JLabel price = new JLabel("Total Price is: " + "1800 USD");
		JButton Reserve = new JButton("Reserve NOW!");
		bottomPanel.add(price);
		bottomPanel.add(Reserve);

		// 4. Add a panel to display discription

		JPanel description = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, description);
		description.setBackground(Color.DARK_GRAY);

		// show frame
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox combo = (JComboBox) e.getSource();
			int index = combo.getSelectedIndex();

			System.out.println("Selected" + combo.getItemAt(index).toString());
		}
	}

	public void constructPkgA() {
		ConstructTourPackageA constructor = new ConstructTourPackageA();
		constructor.construct();
		
		pkgA=constructor.getA();
	
		
	}
}
