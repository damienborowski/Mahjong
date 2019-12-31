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

public class menu_2 {
	private static JFrame mainFrame;

	private static BufferedImage image;

	public static JLabel bAdd_player,bStatistics,bAdd_match;
	public static JLabel bAdd_playerHover,bStatisticsHover,bAdd_matchHover;

	public menu_2() throws IOException {
		
		// Get background Image
		image = ImageIO.read(this.getClass().getResource("images\\main_menu_2.PNG"));
		JLabel label = new JLabel(new ImageIcon(image));
		label.setPreferredSize(new Dimension(1100, 700));
		
		JPanel panel = new JPanel();
		
		mainFrame = new JFrame("Mahjong");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		image = ImageIO.read(this.getClass().getResource("images\\add_player.PNG"));
		bAdd_player = new JLabel(new ImageIcon(image));
		image = ImageIO.read(this.getClass().getResource("images\\statistics.PNG"));
		bStatistics = new JLabel(new ImageIcon(image));
		image = ImageIO.read(this.getClass().getResource("images\\add_match.PNG"));
		bAdd_match = new JLabel(new ImageIcon(image));
		
		image = ImageIO.read(this.getClass().getResource("images\\add_player_2.PNG"));
		bAdd_playerHover = new JLabel(new ImageIcon(image));
		image = ImageIO.read(this.getClass().getResource("images\\statistics_2.PNG"));
		bStatisticsHover = new JLabel(new ImageIcon(image));
		image = ImageIO.read(this.getClass().getResource("images\\add_match_2.PNG"));
		bAdd_matchHover = new JLabel(new ImageIcon(image));
		
		bAdd_player.setBounds(475, 150, 165, 50);
		bStatistics.setBounds(475, 225, 165, 50);
		bAdd_match.setBounds(475, 300, 165, 50);
		
		bAdd_player.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				bAdd_player.setVisible(false);
				bAdd_playerHover.setBounds(475, 150, 165, 50);
				bAdd_playerHover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				bAdd_playerHover.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						//mainFrame.setVisible(false);
						//Main.StartGame();
					}

					public void mouseExited(MouseEvent e) {
						bAdd_player.setVisible(true);
					}
				});
			}
		});
		
		bStatistics.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				bStatistics.setVisible(false);
				bStatisticsHover.setBounds(476, 225, 165, 50);
				bStatisticsHover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				bStatisticsHover.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						mainFrame.setVisible(false);
						try {
							new Statistics_menu();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					public void mouseExited(MouseEvent e) {
						bStatistics.setVisible(true);
					}
				});
			}
		});
		
		bAdd_match.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				bAdd_match.setVisible(false);
				bAdd_matchHover.setBounds(475, 300, 165, 50);
				bAdd_matchHover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				bAdd_matchHover.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						System.out.println(">>");
						new User_input();
					}

					public void mouseExited(MouseEvent e) {
						bAdd_match.setVisible(true);
					}
				});
			}
		});
		
		mainFrame.add(bAdd_player);
		mainFrame.add(bStatistics);
		mainFrame.add(bAdd_match);
		mainFrame.add(bAdd_playerHover);
		mainFrame.add(bStatisticsHover);
		mainFrame.add(bAdd_matchHover);
		
		panel.add(label);
		mainFrame.add(panel);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static JFrame getMainFrame() {
		return mainFrame;
	}
}
