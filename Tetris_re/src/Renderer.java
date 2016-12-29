import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Renderer extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image mBlocks[];
	private Image mEndBlock;
	private Image mBackGround;
	private Image mPauseImage;
	private Image mTitleImage;
	private Image mStartButton;
	private Image mStartButton_N;
	private Image mExitButton;
	private Image mExitButton_N;
	private Image mArrowImage;
	private Image mPerfectBlocks[];
	private Image mNumbers[];
	private Image mLines[];
	private Image mRanks[];
	private Image end_phase;
	private Image press_enter;
	private int mHoldNum;
	private int mNextNum;
	private int mLevel;
	private int mBlockCount;
	private int mHundredNum;
	private int mTenNum;
	private int mOneNum;
	private boolean pressed_pause;
	private int mOneAndNine;
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
	private int mRank;
	private int mScore;
	private int[][] mFixedArr;
	
	public Renderer()
	{
		mBlocks = new Image[7];
		mNumbers = new Image[10];
		mPerfectBlocks = new Image[8];
		mLines = new Image[4];
		mRanks = new Image[7];
		mHoldNum = 7;
		mNextNum = 0;
		mLevel = 1;
		mHundredNum = 0;
		mTenNum = 0;
		mOneNum = 0;
		mOneAndNine = 0;
		line_1 = 0;
		line_2 = 0;
		line_3 = 0;
		line_4 = 0;
		pressed_pause = false;
		state = 0;
		is_end = 0;
		mScore = 0;
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
		mBlocks[0] = b1.getImage();
		mBlocks[1] = b2.getImage();
		mBlocks[2] = b3.getImage();
		mBlocks[3] = b4.getImage();
		mBlocks[4] = b5.getImage();
		mBlocks[5] = b6.getImage();
		mBlocks[6] = b7.getImage();
		mPauseImage = pa.getImage();
		mPerfectBlocks[0] = i.getImage();
		mPerfectBlocks[1] = o.getImage();
		mPerfectBlocks[2] = l.getImage();
		mPerfectBlocks[3] = j.getImage();
		mPerfectBlocks[4] = s.getImage();
		mPerfectBlocks[5] = z.getImage();
		mPerfectBlocks[6] = t.getImage();
		mPerfectBlocks[7] = q.getImage();
		mNumbers[0] = num0.getImage();
		mNumbers[1] = num1.getImage();
		mNumbers[2] = num2.getImage();
		mNumbers[3] = num3.getImage();
		mNumbers[4] = num4.getImage();
		mNumbers[5] = num5.getImage();
		mNumbers[6] = num6.getImage();
		mNumbers[7] = num7.getImage();
		mNumbers[8] = num8.getImage();
		mNumbers[9] = num9.getImage();
		mLines[0] = one_line.getImage();
		mLines[1] = two_line.getImage();
		mLines[2] = three_line.getImage();
		mLines[3] = four_line.getImage();
		mRanks[0] = R_S.getImage();
		mRanks[1] = R_A.getImage();
		mRanks[2] = R_B.getImage();
		mRanks[3] = R_C.getImage();
		mRanks[4] = R_D.getImage();
		mRanks[5] = R_E.getImage();
		mRanks[6] = R_F.getImage();
		end_phase = EP.getImage();
		press_enter = Penter.getImage();
		mEndBlock = end.getImage();
		mBackGround = back.getImage();
		mTitleImage = Titled.getImage();
		mStartButton = START.getImage();
		mStartButton_N = N_START.getImage();
		mExitButton = EXIT.getImage();
		mExitButton_N = N_EXIT.getImage();
		mArrowImage = ARROW.getImage();
	}
	
	public void Init(){
		mHoldNum = 7;
		mNextNum = 0;
		mLevel = 1;
		mHundredNum = 0;
		mTenNum = 0;
		mOneNum = 0;
		mOneAndNine = 0;
		line_1 = 0;
		line_2 = 0;
		line_3 = 0;
		line_4 = 0;
		pressed_pause = false;
		mScore = 0;
	}
	
	public void ArrangeScoreBoard() {
		if (mBlockCount <= 999)
		{
			mHundredNum = mBlockCount / 100;
			mBlockCount -= mHundredNum * 100;
			mTenNum = mBlockCount / 10;
			mOneNum = mBlockCount - mTenNum * 10;
		}
		else
		{
			mHundredNum = 9;
			mTenNum = 9;
			mOneNum = 9;
		}
		if (mHundredNum < 9)
		{
			mLevel = mHundredNum + 1;
		}
		else
		{
			mLevel = mHundredNum;
			mOneAndNine = 9;
		}
	}
	
	public void rank_compute(){
			
			mScore += line_1 * 10;
			mScore += line_2 * 20;
			mScore += line_3 * 30;
			mScore += line_4 * 40;
			mScore += (mLevel-1) * 100;
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
		ArrangeScoreBoard();
		g.drawImage(mBackGround, 0, 0, null);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if (mFixedArr[i][j] == 1) {
					g.drawImage(mBlocks[0], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 2) {
					g.drawImage(mBlocks[1], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 3) {
					g.drawImage(mBlocks[2], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 4) {
					g.drawImage(mBlocks[3], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 5) {
					g.drawImage(mBlocks[4], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 6) {
					g.drawImage(mBlocks[5], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 7) {
					g.drawImage(mBlocks[6], j * 32 + 464, i * 32 + 64, null);
				} else if (mFixedArr[i][j] == 8) {
					g.drawImage(mEndBlock, j * 32 + 464, i * 32 + 64, null);
				} else if ((mFixedArr[i][j] != 0)
						|| (mFixedArr[i][j] > 8)) {
					g.drawImage(mEndBlock, j * 32 + 464, i * 32 + 64, null);
				}
			}
		}
		g.drawImage(mPerfectBlocks[mNextNum], 794, 64, null);
		g.drawImage(mPerfectBlocks[mHoldNum], 314, 64, null);
		g.drawImage(mNumbers[mLevel], 891, 436, null);
		g.drawImage(mNumbers[mLevel], 829, 626, null);
		g.drawImage(mNumbers[mOneAndNine], 859, 626, null);
		g.drawImage(mNumbers[mOneAndNine], 889, 626, null);
		g.drawImage(mNumbers[mHundredNum], 829, 550, null);
		g.drawImage(mNumbers[mTenNum], 859, 550, null);
		g.drawImage(mNumbers[mOneNum], 889, 550, null);

		if (pressed_pause) {
			g.drawImage(mPauseImage, 330, 186, null);
		}
		
	}
	
	public void SetNextBlockNum(int num)
	{
		mNextNum = num; 
	}
	
	public void SetHoldBlockNum(int num)
	{
		mHoldNum = num;
	}
	
	public void SetBlockCount(int num)
	{
		mBlockCount = num;
	}
	
	public void SetGameStatus(boolean stat)
	{
		pressed_pause = stat;
	}
}
