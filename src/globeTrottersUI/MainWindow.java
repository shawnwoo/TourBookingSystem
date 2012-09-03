package globeTrottersUI;

import globeTrotters.ConstructTourPackageA;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tour.Tour;
import tour.TourPackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;

public class MainWindow implements ActionListener, ItemListener,
		ListSelectionListener {

	private TourPackage pkgA;
	private final String FIRST_URL = "LA.htm";
	private final String SEC_URL = "Sf.htm";
	private final String THIRD_URL = "Vegas.htm";

	private JList destList;
	private ReservationForm reservationForm;
	private JEditorPane pane = createEditorPane("");
	private JLabel airLineDetails = new JLabel();
	private JLabel airLinePrice = new JLabel();
	private JLabel hotelDetail = new JLabel();
	private JLabel hotelPrice = new JLabel();
	private JLabel localTransDetail = new JLabel();
	private JLabel localTransPrice = new JLabel();
	private JLabel temperature = new JLabel();
	private JLabel tourCost = new JLabel();
	private JLabel pkgPrice = new JLabel();
	private int tourIndex = -1;

	public void drawUI() {

		this.constructPkgA();
		
		Border emptyBorder=BorderFactory.createEmptyBorder(3,3,3,3);
		Border lineBorder=BorderFactory.createLineBorder(Color.LIGHT_GRAY);

		// 1. Create frame and title
		JFrame frame = new JFrame("GlobeTrotter Reservation System");

		JLabel title = new JLabel("Welcome to GlobeTrotter Reservation System",
				JLabel.CENTER);

		title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		Font labelfont = new Font("Serif", Font.BOLD, 30);
		title.setFont(labelfont);

		frame.getContentPane().add(BorderLayout.NORTH, title);

		// 2. Add the left panel with combo box and list of destinations
		JPanel leftPanel = new JPanel(new BorderLayout());
		frame.getContentPane().add(BorderLayout.WEST, leftPanel);

		JComboBox combo = new JComboBox();

		combo.addItem(pkgA.getName());

		combo.addItem("Tour Package B");

		combo.addItemListener(this);

		destList = new JList(pkgA.getNameList());

		destList.addListSelectionListener(this);

		
		destList.setBorder(BorderFactory.createCompoundBorder(emptyBorder,lineBorder));
			
	
		leftPanel.add(BorderLayout.NORTH, combo);
		
		
		//leftPanel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, lineBorder));
		leftPanel.add(BorderLayout.CENTER, destList);

		// 3. Add a panel at the bottom with Button and price label

		JPanel bottomPanel = new JPanel();
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);

		// JLabel price = new JLabel("Total Price is: " + pkgPrice + "USD");
		JButton Reserve = new JButton("Reserve NOW!");
		Reserve.addActionListener(new openNewWindow());
		bottomPanel.add(pkgPrice);
		bottomPanel.add(Reserve);

		// 5. Add a panel to display prices for each item
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.white);
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		frame.getContentPane().add(BorderLayout.EAST, rightPanel);
		JLabel tourDetail = new JLabel("Tour Details: ");
		tourDetail.setBackground(Color.LIGHT_GRAY);
		JLabel airLineLabel = new JLabel("Air Line Details:");
		JLabel airLinePriceLable = new JLabel("Air Line Price: ");
		JLabel hotelLabel = new JLabel("Hotel Details:");
		JLabel hotelPriceLabel = new JLabel("Hotel Price: ");
		JLabel localTransLabel = new JLabel("Local Transportation Details: ");
		JLabel localTransPriceLabel = new JLabel("Local Transportation Price: ");
		JLabel localTempLabel = new JLabel("Local average temperature: ");
		JLabel tourCostLabel = new JLabel("Total Cost for this Tour: ");

		// add tour Details
		rightPanel.add(tourDetail);

		rightPanel.add(new JSeparator());
		// add airline details and price
		rightPanel.add(airLineLabel);
		rightPanel.add(airLineDetails);
		rightPanel.add(airLinePriceLable);
		rightPanel.add(airLinePrice);
		rightPanel.add(new JSeparator());

		// add hotel details and price
		rightPanel.add(hotelLabel);
		rightPanel.add(hotelDetail);
		rightPanel.add(hotelPriceLabel);

		rightPanel.add(hotelPrice);
		rightPanel.add(new JSeparator());

		// add local transportation details and price
		rightPanel.add(localTransLabel);
		rightPanel.add(localTransDetail);
		rightPanel.add(localTransPriceLabel);
		rightPanel.add(localTransPrice);
		rightPanel.add(new JSeparator());

		// add local temperature information
		rightPanel.add(localTempLabel);
		rightPanel.add(temperature);
		rightPanel.add(new JSeparator());

		// add total tour cost
		rightPanel.add(tourCostLabel);
		rightPanel.add(tourCost);
		
		rightPanel.setBorder(BorderFactory.createCompoundBorder(emptyBorder, lineBorder));

		// 4. Add a panel to display discription

		pane.setEditable(false);
		pane.setText("");
		pane.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));

		frame.getContentPane().add(BorderLayout.CENTER, pane);

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
			// pkgA.getNameList()
			DefaultListModel ds = new DefaultListModel();
			if (index == 0) {

				for (int i = 0; i < pkgA.getNameList().length; i++) {
					ds.addElement(pkgA.getNameList()[i]);
				}
				;
				destList.setModel(ds);
			}
			if (index == 1) {
				ds.clear();
				destList.setModel(ds);
				pane.setText("");
			}

			// destList=new JList(pkgA.getNameList());

			System.out.println("Selected" + combo.getItemAt(index).toString());
		}
	}

	public void constructPkgA() {
		ConstructTourPackageA constructor = new ConstructTourPackageA();
		constructor.construct();

		pkgA = constructor.getA();

	}
	
	public void setPackage(TourPackage pkg){
		
		pkgA=pkg;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting())
			return;

		JList theList = (JList) e.getSource();
		if (theList.isSelectionEmpty())
			pane.setText("");
		else {
			int index = theList.getSelectedIndex();

			try {
				if (index == 0)
					pane.setPage(getURL(FIRST_URL));

				if (index == 1)
					pane.setPage(getURL(SEC_URL));
				if (index == 2)
					pane.setPage(getURL(THIRD_URL));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Tour tour = pkgA.getTour(index);

			airLineDetails.setText(tour.getAirline().getDesc());
			airLinePrice.setText(Double.toString(tour.getAirline().getPrice()));
			hotelDetail.setText(tour.getHotel().getDesc());
			hotelPrice.setText(Double.toString(tour.getAirline().getPrice()));
			localTransDetail.setText(tour.getTrans().getDesc());
			localTransPrice
					.setText(Double.toString(tour.getTrans().getPrice()));
			temperature.setText(tour.getTempF() + "F " + "(" + tour.getTempC()
					+ "C )");

			tourCost.setFont(new Font("SansSerif", Font.ITALIC, 18));
			tourCost.setText(tour.getPrice() + " USD");

			//pkgPrice.setText("Total Price is: " + pkgA.getPrice() + " USD");
			pkgPrice.setText("");

			tourIndex = index;

		}

	}

	private URL getURL(String url) {
		java.net.URL URL = MainWindow.class.getResource(url);
		if (URL != null)
			return URL;
		else
			System.err.println("Couldn't find file");
		return URL;

	}

	private JEditorPane createEditorPane(String url) {
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		java.net.URL URL = MainWindow.class.getResource(url);

		if (URL != null) {
			try {
				editorPane.setPage(URL);
			} catch (IOException e) {
				System.err.println("Attempted to read a bad URL: " + URL);
			}
		} else {
			System.err.println("Couldn't find file");
		}
		return editorPane;
	}

	class openNewWindow implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (tourIndex >= 0)
				reservationForm = new ReservationForm(MainWindow.this,pkgA, tourIndex);

		}

	}
}
