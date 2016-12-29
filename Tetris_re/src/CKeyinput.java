import java.awt.event.*;

public class CKeyinput extends CModule implements KeyListener, KeyInfo {
	private int keymap[];
	private int inputkey;
	private boolean keypressed;
	private static final int UP = 0;
	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	private static final int SPACE = 4;
	private static final int KEY_P = 5;
	private static final int KEY_Q = 6;
	private static final int ENTER = 7;
	private static final int RELEASE = 8;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		keypressed = true;
		switch(key){
			case KeyEvent.VK_UP:
			{
				inputkey = UP;
				break;
			}
			case KeyEvent.VK_LEFT:
			{
				inputkey = LEFT;
				break;
			}
			case KeyEvent.VK_RIGHT:
			{
				inputkey = RIGHT;
				break;
			}
			case KeyEvent.VK_DOWN:
			{
				inputkey = DOWN;
				break;
			}
			case KeyEvent.VK_SPACE:
			{
				inputkey = SPACE;
				break;
			}
			case KeyEvent.VK_P:
			{
				inputkey = KEY_P;
				break;
			}
			case KeyEvent.VK_Q:
			{
				inputkey = KEY_Q;
				break;
			}
			case KeyEvent.VK_ENTER:
			{
				inputkey = ENTER;
				break;
			}
		}
	}

	public void Init()
	{
		int i;
		inputkey = 8;
		keymap = new int [9];
		for (i = 0; i < keymap.length; i++)
		{
			keymap[i] = 0;
		}
	}
	
	public void Update()
	{
		int i;
		for (i = 0; i < keymap.length; i++)
		{
			keymap[i] = 0;
		}
		keymap[inputkey] = 1;
	}
	public void keyReleased(KeyEvent e)
	{
		inputkey = RELEASE;
		keypressed = false;
	}
	public void keyTyped(KeyEvent e) 
	{
		
	}
	@Override
	public int GetKey() {
		return inputkey;
	}
	@Override
	public boolean GetPressed() {
		return keypressed;
	}
}
