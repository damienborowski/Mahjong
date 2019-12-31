import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;

public class Letters {

	private static BufferedImage image;

	public static JLabel letter;
	public static JLabel bAdd_playerHover;

	public JLabel Letter(char letter) throws IOException {

		if (letter == 'a') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\a.PNG"));
		} else if (letter == 'b') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\b.PNG"));
		} else if (letter == 'c') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\c.PNG"));
		} else if (letter == 'd') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\d.PNG"));
		} else if (letter == 'e') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\e.PNG"));
		} else if (letter == 'f') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\f.PNG"));
		} else if (letter == 'g') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\g.PNG"));
		} else if (letter == 'h') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\h.PNG"));
		} else if (letter == 'i') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\i.PNG"));
		} else if (letter == 'j') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\j.PNG"));
		} else if (letter == 'k') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\k.PNG"));
		} else if (letter == 'l') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\l.PNG"));
		} else if (letter == 'm') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\m.PNG"));
		} else if (letter == 'n') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\n.PNG"));
		} else if (letter == 'o') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\o.PNG"));
		} else if (letter == 'p') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\p.PNG"));
		} else if (letter == 'q') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\q.PNG"));
		} else if (letter == 'r') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\r.PNG"));
		} else if (letter == 's') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\s.PNG"));
		} else if (letter == 't') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\t.PNG"));
		} else if (letter == 'u') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\u.PNG"));
		} else if (letter == 'v') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\v.PNG"));
		} else if (letter == 'w') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\w.PNG"));
		} else if (letter == 'x') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\x.PNG"));
		} else if (letter == 'y') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\y.PNG"));
		} else if (letter == 'z') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\z.PNG"));
		} else if (letter == '0') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\0.PNG"));
		} else if (letter == '1') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\1.PNG"));
		} else if (letter == '2') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\2.PNG"));
		} else if (letter == '3') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\3.PNG"));
		} else if (letter == '4') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\4.PNG"));
		} else if (letter == '5') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\5.PNG"));
		} else if (letter == '6') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\6.PNG"));
		} else if (letter == '7') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\7.PNG"));
		} else if (letter == '8') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\8.PNG"));
		} else if (letter == '9') {
			image = ImageIO.read(this.getClass().getResource("images\\letters\\9.PNG"));
		}

		this.letter = new JLabel(new ImageIcon(image));
		return this.letter;
	}

}
