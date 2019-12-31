import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Statistics_menu {
	private static JFrame mainFrame;

	private static BufferedImage image;

	public static JLabel back_1;
	public static JLabel back_2;

	public static JLabel letter;

	public Statistics_menu() throws IOException {

		// Get background Image
		image = ImageIO.read(this.getClass().getResource("images\\statistics_menu.PNG"));
		JLabel label = new JLabel(new ImageIcon(image));
		label.setPreferredSize(new Dimension(1100, 700));

		JPanel panel = new JPanel();

		mainFrame = new JFrame("Mahjong");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);

		image = ImageIO.read(this.getClass().getResource("images\\back_1.PNG"));
		back_1 = new JLabel(new ImageIcon(image));

		image = ImageIO.read(this.getClass().getResource("images\\back_2.PNG"));
		back_2 = new JLabel(new ImageIcon(image));

		Main.PrintElo();

		back_1.setBounds(900, 30, 165, 50);

		back_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				back_1.setVisible(false);
				back_2.setBounds(900, 30, 165, 50);
				back_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				back_2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						mainFrame.setVisible(false);
						menu_2.getMainFrame().setVisible(true);
					}

					public void mouseExited(MouseEvent e) {
						back_1.setVisible(true);
					}
				});
			}
		});

		mainFrame.add(back_1);
		mainFrame.add(back_2);

		panel.add(label);
		mainFrame.add(panel);

		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public static void printGui(String string, int x, int y) throws IOException {

		for (int i = 0; i < string.length(); i++) {
			letter = new Letters().Letter(string.charAt(i));
			letter.setBounds(x, y, 165, 50);
			mainFrame.add(letter);
			x += 15;
		}
	}

}
