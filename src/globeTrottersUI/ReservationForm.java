package globeTrottersUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import people.Tourist;

import tour.Tour;
import tour.TourPackage;

public class ReservationForm extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2586681740435178976L;

	private TourPackage pkg;
	private int tourIndex;
	private MainWindow mainwindow;

	private JLabel titleLabel = new JLabel();
	private JPanel info = new JPanel();
	private JScrollPane s;
	private JLabel price = new JLabel();
	private JLabel vacancy = new JLabel();
	private JLabel discount = new JLabel("No Discount");
	private JTextField ID;
	private Tour tour;
	private int vacancyUI;
	private int waitingNum;
	private int reservationID = (int) (Math.random()*500);

	public ReservationForm(MainWindow mainWindow, TourPackage pkg, int tourIndex) {
		this.pkg = pkg;
		this.tourIndex = tourIndex;
		this.mainwindow = mainWindow;

		drawUI();

	}

	public void drawUI() {

		tour = pkg.getTour(tourIndex);

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		this.setTitle(pkg.getName() + " : " + pkg.getTour(tourIndex).getName()
				+ " Registration Form");

		// add title label
		titleLabel.setText(pkg.getName() + " : "
				+ pkg.getTour(tourIndex).getName() + " Registration Form");
		titleLabel.setFont(new Font("Serif", Font.BOLD, 15));

		// add a scrolling JPanel to contain information JPanels

		info.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

		// add text area
		JPanel rIDPane = new JPanel();
		JLabel IDLabel = new JLabel("Reservation ID: ");
		ID = new JTextField(10);
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new loadReservation());
		rIDPane.add(IDLabel);
		rIDPane.add(ID);
		rIDPane.add(loadButton);
		
		add(titleLabel);
		add(rIDPane);
	

		addInfo();

	
		s = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		s.setPreferredSize(new Dimension(200, 200));
		add(s);
		// add Prices and Vacancies

		JPanel pricePanel = new JPanel();
		JPanel vacancyPanel = new JPanel();
		JPanel discountPanel = new JPanel();
		JLabel priceLabel = new JLabel("Total Price: ");

		vacancy.setText("Vacancy: " + tour.getVacancy());
		vacancyUI = tour.getVacancy();
		waitingNum = 1;
		vacancyPanel.add(vacancy);
		vacancyPanel.setAlignmentX(LEFT_ALIGNMENT);

		pricePanel.add(priceLabel);
		pricePanel.add(price);
		pricePanel.add(discount);
		price.setText(Double.toString(tour.getPrice()));

		pricePanel.setAlignmentX(LEFT_ALIGNMENT);
		discountPanel.add(discount);
		discountPanel.setAlignmentX(LEFT_ALIGNMENT);

		add(vacancyPanel);
		add(pricePanel);
		add(discountPanel);

		// add button
		JPanel bottomPanel = new JPanel();
		JButton submitButton = new JButton("Submit");
		JButton addMoreButton = new JButton("Add More Tourist");
		submitButton.addActionListener(new actionSubmit());
		addMoreButton.addActionListener(new addMore());
		JButton clearButton=new JButton("Clear");
		clearButton.addActionListener(new clearAction());
	

		bottomPanel.add(submitButton);
		bottomPanel.add(addMoreButton);
		bottomPanel.add(clearButton);
		add(bottomPanel);

		// show frame

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

	}

	class actionSubmit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("Submit");
			System.out.println(info.getComponentCount());

			int addToTour = 0;
			int addToWaitingList = 0;

			for (int i = 0; i < info.getComponentCount(); i += 3) {
				String name = ((JTextField) ((JPanel) info.getComponent(i))
						.getComponent(1)).getText();
				String email = ((JTextField) ((JPanel) info.getComponent(i + 1))
						.getComponent(1)).getText();
				String address = ((JTextField) ((JPanel) info
						.getComponent(i + 2)).getComponent(1)).getText();

				if (!name.isEmpty()) {
					Tourist newTourist = new Tourist(name);
					newTourist.setEmail(email);
					newTourist.setAddress(address);
					if (tour.stillAvailable()) {

						addToTour++;
					} else {
						addToWaitingList++;

					}

					tour.addTourist(newTourist);

				}

			}

			if (addToTour == 0) {
				if (addToWaitingList == 0)
					JOptionPane.showMessageDialog(null, "No info submitted!");
				else
					JOptionPane.showMessageDialog(null, addToWaitingList
							+ " people are added to waiting list. " + " Reservation ID: "+reservationID);

			} else {
				if (addToWaitingList == 0)
					JOptionPane.showMessageDialog(null, addToTour
							+ " people are added to the tour!"+" Reservation ID: "+reservationID);
				else
					JOptionPane.showMessageDialog(null, addToTour
							+ " people are added to the tour and "
							+ addToWaitingList
							+ " are added to the waiting list" +" Reservation ID: "+reservationID);
			}

			if (addToTour != 0 || addToWaitingList != 0) {

		

				try {
					ArrayList<Tourist> tourList = tour.getTouristList();
					ArrayList<Tourist> waitingList = tour.getWaitingList();
					String fileName = Integer.toString(reservationID);

					util.XMLReader.crateXML(fileName);

					for (int i = 0; i < tourList.size(); i++) {

						Tourist tourist = tourList.get(i);

						util.XMLReader.updateXML(fileName, tour.getName(),tour.getAirline()
								.getDesc(), tour.getHotel().getDesc(), tour
								.getTrans().getDesc(), tourist.getName(),
								tourist.getEmail(), tourist.getAddress());
					}
					
					for(int i=0;i<waitingList.size();i++){
						Tourist tourist=waitingList.get(i);
						
						util.XMLReader.updateXML(fileName, tour.getName(),tour.getAirline()
								.getDesc(), tour.getHotel().getDesc(), tour
								.getTrans().getDesc(), tourist.getName(),
								tourist.getEmail(), tourist.getAddress());
					}

				} catch (Exception exception) {
					exception.printStackTrace();
				}
				
				

				dispose();
				
			}

		}
	}

	class addMore implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			vacancyUI--;
			addInfo();
			// info.validate();
			info.revalidate();
			int height = (int) info.getPreferredSize().getHeight();
			Rectangle rect = new Rectangle(0, height, 10, 10);
			info.scrollRectToVisible(rect);

			price.setText(Double.toString(tour.getDiscountedPrice()));

			discount.setText(tour.getDiscountNumber());

			// tour.addTourist(tourist)
			if (vacancyUI > 0) {
				vacancy.setText("Vacancy: " + vacancyUI);

			} else {
				vacancy.setText("No vacncy left. " + waitingNum
						+ " people will be add to waiting list");
				waitingNum++;
			}

		}

	}

	class loadReservation implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			
			ExistingReservation est=new ExistingReservation(ID.getText());
			est.drawUI();
		}
	}
	
	
	class clearAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for (int i = 0; i < info.getComponentCount(); i ++) {
				((JTextField) ((JPanel) info.getComponent(i))
						.getComponent(1)).setText("");
		}
	}
	
	}
	private void addInfo() {
		JPanel infoPane1 = new JPanel();
		JPanel infoPane2 = new JPanel();
		JPanel infoPane3 = new JPanel();

		JLabel nameLabel = new JLabel("Name:      ");
		nameLabel.setSize(20, 10);
		JLabel emailLabel = new JLabel("Email:       ");
		emailLabel.setSize(20, 10);
		JLabel addressLabel = new JLabel("Address: ");
		addressLabel.setSize(20, 10);

		JTextField name = new JTextField(20);
		JTextField Email = new JTextField(20);
		JTextField address = new JTextField(20);

		infoPane1.add(nameLabel);
		infoPane1.add(name);
		infoPane2.add(emailLabel);
		infoPane2.add(Email);
		infoPane3.add(addressLabel);
		infoPane3.add(address);

		infoPane1.setAlignmentX(LEFT_ALIGNMENT);
		infoPane2.setAlignmentX(LEFT_ALIGNMENT);
		infoPane3.setAlignmentX(LEFT_ALIGNMENT);

		info.add(infoPane1);
		info.add(infoPane2);
		info.add(infoPane3);
		// info.add(new JSeparator());

	}

}
