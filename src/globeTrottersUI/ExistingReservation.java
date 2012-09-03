package globeTrottersUI;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class ExistingReservation extends AbstractTableModel {
	Vector data;
	Vector columns;
	String fileName;

//	public ExistingReservation(String fileName) {
//		this.fileName = fileName;
//		drawUI();
//
//	}

	public ExistingReservation(String fileName) {
		try {

			File xmlFile = new File(fileName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);

			NodeList n1 = doc.getElementsByTagName("tourName");
			NodeList n2 = doc.getElementsByTagName("airline");
			NodeList n3 = doc.getElementsByTagName("hotel");
			NodeList n4 = doc.getElementsByTagName("localTrans");
			NodeList n5 = doc.getElementsByTagName("tourist");
			NodeList n6 = doc.getElementsByTagName("Email");
			NodeList n7 = doc.getElementsByTagName("Address");

			String data1 = "", data2 = "", data3 = "", data4 = "", data5 = "", data6 = "", data7 = "";
			data = new Vector();
			columns = new Vector();
			
			System.out.println(n1.getLength());
			for (int i = 0; i < n1.getLength(); i++) {
				data1 = n1.item(i).getFirstChild().getNodeValue();
				data2 = n2.item(i).getFirstChild().getNodeValue();
				data3 = n3.item(i).getFirstChild().getNodeValue();
				data4 = n4.item(i).getFirstChild().getNodeValue();
				data5 = n5.item(i).getFirstChild().getNodeValue();
				data6 = n6.item(i).getFirstChild().getNodeValue();
				data7 = n7.item(i).getFirstChild().getNodeValue();
			
				
				
				String line = data1 + " $" + data2 + "$ " + data3+"$ "+data4+"$ "+data5+" $"+data6+"$ "+data7;
				StringTokenizer st2 = new StringTokenizer(line, "$");
				while (st2.hasMoreTokens())
					data.addElement(st2.nextToken());
			}
			for(int i=0;i<=6;i++)
			columns.add("");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//drawUI();

	}

	public void drawUI() {

		
		JTable table = new JTable();
		table.setModel(this);
		
		JScrollPane scrollpane = new JScrollPane(table);
		JPanel panel = new JPanel();
		panel.add(scrollpane);
		JFrame frame = new JFrame();
		frame.add(panel, "Center");
		frame.pack();
		frame.setVisible(true);

	}

	public int getRowCount() {
		return data.size() / getColumnCount();
	}

	public int getColumnCount() {
		return columns.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return (String) data.elementAt((rowIndex * getColumnCount())
				+ columnIndex);
	}

}
