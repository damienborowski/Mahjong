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

public class Menu {
	private static JFrame mainFrame;

	private static BufferedImage image;

	public static JLabel bStart;
	public static JLabel bStartHover;

	public Menu() throws IOException {
		
		// Get background Image
		image = ImageIO.read(this.getClass().getResource("images\\main_menu.PNG"));
		JLabel label = new JLabel(new ImageIcon(image));
		label.setPreferredSize(new Dimension(1100, 700));
		
		JPanel panel = new JPanel();
		
		mainFrame = new JFrame("Mahjong");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		image = ImageIO.read(this.getClass().getResource("images\\start_1.PNG"));
		bStart = new JLabel(new ImageIcon(image));
		
		image = ImageIO.read(this.getClass().getResource("images\\\\start_2.PNG"));
		bStartHover = new JLabel(new ImageIcon(image));
		
		bStart.setBounds(475, 550, 145, 50);
		
		bStart.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				bStart.setVisible(false);
				bStartHover.setBounds(475, 550, 145, 50);
				bStartHover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				bStartHover.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						mainFrame.setVisible(false);
						
						try {
							Main.ReadFile();
							new menu_2();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					public void mouseExited(MouseEvent e) {
						bStart.setVisible(true);
					}
				});
			}
		});
		
		mainFrame.add(bStart);
		mainFrame.add(bStartHover);
		
		panel.add(label);
		mainFrame.add(panel);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
