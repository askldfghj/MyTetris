import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Renderer extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image block1;
	private Image block2;
	private Image block3;
	private Image block4;
	private Image block5;
	private Image block6;
	private Image block7;
	private Image end_block;
	private Image err;
	private Image bakc_ground;
	private Image pause;
	private Image title;
	private Image start1;
	private Image start2;
	private Image exit1;
	private Image exit2;
	private Image arrow;
	private Image mPerfectBlock[];
	private Image numbers[];
	private Image lines[];
	private Image ranks[];
	private Image end_phase;
	private Image press_enter;
	private int hold;
	private int next;
	private int level;
	private int mBlockCount;
	private int hund;
	private int ten;
	private int one;
	private int pressed_pause;
	private int atoz;
	private int er;
	private int state;
	private int is_end;
	private int line_1;
	private int line_2;
	private int line_3;
	private int line_4;
	private int line1_one;
	private int line1_ten;
	private int line1_hund;
	private int line2_one;
	private int line2_ten;
	private int line2_hund;
	private int line3_one;
	private int line3_ten;
	private int line3_hund;
	private int line4_one;
	private int line4_ten;
	private int line4_hund;
	private int rank;
	private int score;
	private int[][] mFixedArr;
	
	public Renderer()
	{
		numbers = new Image[10];
		mPerfectBlock = new Image[8];
		lines = new Image[4];
		ranks = new Image[7];
		hold = 7;
		next = 0;
		level = 1;
		hund = 0;
		ten = 0;
		one = 0;
		atoz = 0;
		line_1 = 0;
		line_2 = 0;
		line_3 = 0;
		line_4 = 0;
		pressed_pause = 0;
		state = 0;
		is_end = 0;
		score = 0;
		ImageIcon b1 = new ImageIcon("images/block1.jpg");
		ImageIcon b2 = new ImageIcon("images/block2.jpg");
		ImageIcon b3 = new ImageIcon("images/block3.jpg");
		ImageIcon b4 = new ImageIcon("images/block4.jpg");
		ImageIcon b5 = new ImageIcon("images/block5.jpg");
		ImageIcon b6 = new ImageIcon("images/block6.jpg");
		ImageIcon b7 = new ImageIcon("images/block7.jpg");
		ImageIcon pa = new ImageIcon("images/pause.png");
		ImageIcon i = new ImageIcon("images/I.jpg");
		ImageIcon o = new ImageIcon("images/O.jpg");
		ImageIcon l = new ImageIcon("images/L.jpg");
		ImageIcon j = new ImageIcon("images/J.jpg");
		ImageIcon s = new ImageIcon("images/S.jpg");
		ImageIcon z = new ImageIcon("images/Z.jpg");
		ImageIcon t = new ImageIcon("images/T.jpg");
		ImageIcon q = new ImageIcon("images/Q.jpg");
		ImageIcon num0 = new ImageIcon("images/0.png");
		ImageIcon num1 = new ImageIcon("images/1.png");
		ImageIcon num2 = new ImageIcon("images/2.png");
		ImageIcon num3 = new ImageIcon("images/3.png");
		ImageIcon num4 = new ImageIcon("images/4.png");
		ImageIcon num5 = new ImageIcon("images/5.png");
		ImageIcon num6 = new ImageIcon("images/6.png");
		ImageIcon num7 = new ImageIcon("images/7.png");
		ImageIcon num8 = new ImageIcon("images/8.png");
		ImageIcon num9 = new ImageIcon("images/9.png");
		ImageIcon end = new ImageIcon("images/end_block.jpg");
		ImageIcon error = new ImageIcon("images/error.jpg");
		ImageIcon back = new ImageIcon("images/BackGround2.jpg");
		ImageIcon Titled = new ImageIcon("images/TITLE.jpg");
		ImageIcon START = new ImageIcon("images/start.png");
		ImageIcon N_START = new ImageIcon("images/n_start.png");
		ImageIcon EXIT = new ImageIcon("images/exit.png");
		ImageIcon N_EXIT = new ImageIcon("images/n_exit.png");
		ImageIcon ARROW = new ImageIcon("images/arrow.png");
		ImageIcon one_line = new ImageIcon("images/line_1.png");
		ImageIcon two_line = new ImageIcon("images/line_2.png");
		ImageIcon three_line = new ImageIcon("images/line_3.png");
		ImageIcon four_line = new ImageIcon("images/line_4.png");
		ImageIcon R_S = new ImageIcon("images/S.png");
		ImageIcon R_A = new ImageIcon("images/A.png");
		ImageIcon R_B = new ImageIcon("images/B.png");
		ImageIcon R_C = new ImageIcon("images/C.png");
		ImageIcon R_D = new ImageIcon("images/D.png");
		ImageIcon R_E = new ImageIcon("images/E.png");
		ImageIcon R_F = new ImageIcon("images/F.png");
		ImageIcon EP = new ImageIcon("images/phase3.jpg");
		ImageIcon Penter = new ImageIcon("images/press_enter.png");
		block1 = b1.getImage();
		block2 = b2.getImage();
		block3 = b3.getImage();
		block4 = b4.getImage();
		block5 = b5.getImage();
		block6 = b6.getImage();
		block7 = b7.getImage();
		pause = pa.getImage();
		mPerfectBlock[0] = i.getImage();
		mPerfectBlock[1] = o.getImage();
		mPerfectBlock[2] = l.getImage();
		mPerfectBlock[3] = j.getImage();
		mPerfectBlock[4] = s.getImage();
		mPerfectBlock[5] = z.getImage();
		mPerfectBlock[6] = t.getImage();
		mPerfectBlock[7] = q.getImage();
		numbers[0] = num0.getImage();
		numbers[1] = num1.getImage();
		numbers[2] = num2.getImage();
		numbers[3] = num3.getImage();
		numbers[4] = num4.getImage();
		numbers[5] = num5.getImage();
		numbers[6] = num6.getImage();
		numbers[7] = num7.getImage();
		numbers[8] = num8.getImage();
		numbers[9] = num9.getImage();
		lines[0] = one_line.getImage();
		lines[1] = two_line.getImage();
		lines[2] = three_line.getImage();
		lines[3] = four_line.getImage();
		ranks[0] = R_S.getImage();
		ranks[1] = R_A.getImage();
		ranks[2] = R_B.getImage();
		ranks[3] = R_C.getImage();
		ranks[4] = R_D.getImage();
		ranks[5] = R_E.getImage();
		ranks[6] = R_F.getImage();
		end_phase = EP.getImage();
		press_enter = Penter.getImage();
		end_block = end.getImage();
		err = error.getImage();
		bakc_ground = back.getImage();
		title = Titled.getImage();
		start1 = START.getImage();
		start2 = N_START.getImage();
		exit1 = EXIT.getImage();
		exit2 = N_EXIT.getImage();
		arrow = ARROW.getImage();
	}
	
	public void Init(){
		hold = 7;
		next = 0;
		level = 1;
		hund = 0;
		ten = 0;
		one = 0;
		atoz = 0;
		line_1 = 0;
		line_2 = 0;
		line_3 = 0;
		line_4 = 0;
		pressed_pause = 0;
		score = 0;
	}
	
	public void arrange_etc() {
		if (mBlockCount <= 999)
		{
			hund = mBlockCount / 100;
			mBlockCount -= hund * 100;
			ten = mBlockCount / 10;
			one = mBlockCount - ten * 10;
		}
		else
		{
			hund = 9;
			ten = 9;
			one = 9;
		}
		if (hund < 9)
		{
			level = hund + 1;
		}
		else
		{
			level = hund;
			atoz = 9;
		}
	}
	
	public void rank_compute(){
			
			score += line_1 * 10;
			score += line_2 * 20;
			score += line_3 * 30;
			score += line_4 * 40;
			score += (level-1) * 100;
			line1_hund = line_1 / 100;
			line_1 = line_1-(line1_hund*100);
			line1_ten = line_1 / 10;
			line_1 = line_1-(line1_ten*10);
			line1_one = line_1;
			
			line2_hund = line_2 / 100;
			line_2 = line_2-(line2_hund*100);
			line2_ten = line_2 / 10;
			line_2 = line_2-(line2_ten*10);
			line2_one = line_2;
			
			line3_hund = line_3 / 100;
			line_3 = line_3-(line3_hund*100);
			line3_ten = line_3 / 10;
			line_3 = line_3-(line3_ten*10);
			line3_one = line_3;
			
			line4_hund = line_4 / 100;
			line_4 = line_4-(line4_hund*100);
			line4_ten = line_4 / 10;
			line_4 = line_4-(line4_ten*10);
			line4_one = line_4;
			
			
		}
	public void SetFixedArr(int[][] fixedarr)
	{
		mFixedArr = fixedarr;
	}
	
	public void paint(Graphics g) {
		arrange_etc();
		g.drawImage(bakc_ground, 0, 0, null);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if (mFixedArr[i][j] == 1) {
					g.drawImage(block1, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 2) {
					g.drawImage(block2, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 3) {
					g.drawImage(block3, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 4) {
					g.drawImage(block4, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 5) {
					g.drawImage(block5, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 6) {
					g.drawImage(block6, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 7) {
					g.drawImage(block7, j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 8) {
					g.drawImage(end_block, j * 32 + 464, i * 32 + 64, null);
				} else if ((mFixedArr[i][j] != 0)
						|| (mFixedArr[i][j] > 8)) {
					g.drawImage(end_block, j * 32 + 464, i * 32 + 64, null);
				}
			}
		}
		g.drawImage(mPerfectBlock[next], 794, 64, null);
		g.drawImage(mPerfectBlock[hold], 314, 64, null);
		g.drawImage(numbers[level], 891, 436, null);
		g.drawImage(numbers[level], 829, 626, null);
		g.drawImage(numbers[atoz], 859, 626, null);
		g.drawImage(numbers[atoz], 889, 626, null);
		g.drawImage(numbers[hund], 829, 550, null);
		g.drawImage(numbers[ten], 859, 550, null);
		g.drawImage(numbers[one], 889, 550, null);

		if (pressed_pause == 1) {
			g.drawImage(pause, 330, 186, null);
		}
		
	}
	
	public void SetNextBlockNum(int num)
	{
		next = num; 
	}
	
	public void SetHoldBlockNum(int num)
	{
		hold = num;
	}
	
	public void SetBlockCount(int num)
	{
		mBlockCount = num;
	}
}
