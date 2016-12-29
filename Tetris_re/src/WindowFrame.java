import javax.swing.*;

public class WindowFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WindowFrame(CKeyinput key, Renderer rend){
		this.setTitle("Tetris 0.1v");
		this.setSize(1262, 786);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(rend);
		this.addKeyListener(key);
	}
}
