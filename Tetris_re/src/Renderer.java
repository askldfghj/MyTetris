import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Renderer extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int SCENE1 = 1;
	private static final int SCENE2 = 2;
	private static final int SCENE3 = 3;
	
	private Image[] mBlocks;
	private Image mEndBlock;
	private Image mBackGround;
	private Image mPauseImage;
	private Image mTitleImage;
	private Image mStartButton;
	private Image mStartButton_N;
	private Image mExitButton;
	private Image mExitButton_N;
	private Image mArrowImage;
	private Image[] mPerfectBlocks;
	private Image[] mNumbers;
	private Image[] mLines;
	private Image[] mRanks;
	private Image mResultBackGround;
	private Image mPressEnterImage;
	private int mHoldNum;
	private int mNextNum;
	private int mLevel;
	private int mBlockCount;
	private int mHundredNum;
	private int mTenNum;
	private int mOneNum;
	private boolean mFlagPausePress;
	private int mSceneStatus;
	private int mOneAndNine;
	private boolean mFlagStart;
	private int[] mEraseLineResult;
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
		mFlagPausePress = false;
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
		mResultBackGround = EP.getImage();
		mPressEnterImage = Penter.getImage();
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
		mFlagPausePress = false;
		mEraseLineResult = new int[5];
		mScore = 0;
		mFlagStart = true;
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
	
	public void ResultBoardArrange(){
			line1_hund = mEraseLineResult[0] / 100;
			mEraseLineResult[0] = mEraseLineResult[0]-(line1_hund*100);
			line1_ten = mEraseLineResult[0] / 10;
			line1_one  = mEraseLineResult[0]-(line1_ten*10);
			
			line2_hund = mEraseLineResult[1] / 100;
			mEraseLineResult[1] = mEraseLineResult[1]-(line2_hund*100);
			line2_ten = mEraseLineResult[1] / 10;
			line2_one = mEraseLineResult[1] -(line2_ten*10);
			
			line3_hund = mEraseLineResult[2] / 100;
			mEraseLineResult[2] = mEraseLineResult[2]-(line3_hund*100);
			line3_ten = mEraseLineResult[2] / 10;
			line3_one = mEraseLineResult[2]-(line3_ten*10);
			
			line4_hund = mEraseLineResult[3] / 100;
			mEraseLineResult[3] = mEraseLineResult[3]-(line4_hund*100);
			line4_ten = mEraseLineResult[3] / 10;
			line4_one = mEraseLineResult[3]-(line4_ten*10);
			
			mScore = mEraseLineResult[4];
		}
	public void SetFixedArr(int[][] fixedarr)
	{
		mFixedArr = fixedarr;
	}
	
	public void paint(Graphics g) {
		
		switch(mSceneStatus)
		{
		case SCENE1 :
			Scene1Render(g);
			break;
		case SCENE2 :
			Scene2Render(g);
			break;
		case SCENE3 :
			Scene3Render(g);
			break;
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
		mFlagPausePress = stat;
	}
	
	public void SetSceneStatus(int scene_num)
	{
		mSceneStatus = scene_num;
	}
	
	public void SetStartFlag(boolean start_status)
	{
		mFlagStart = start_status;
	}
	
	public void SetErasedLineResult(int[] result)
	{
		mEraseLineResult = result;
	}
	
	void Scene1Render(Graphics g)
	{
		g.drawImage(mTitleImage, 0, 0, null);
		if (mFlagStart){
			g.drawImage(mStartButton, 513, 424, null);
			g.drawImage(mExitButton_N, 578, 525, null);
			g.drawImage(mArrowImage, 460, 433, null);
		}
		else {
			g.drawImage(mStartButton_N, 541, 430, null);
			g.drawImage(mExitButton, 565, 517, null);
			g.drawImage(mArrowImage, 510, 529, null);
		}
	}
	
	void Scene2Render(Graphics g)
	{
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

		if (mFlagPausePress) {
			g.drawImage(mPauseImage, 330, 186, null);
		}
	}
	
	void Scene3Render(Graphics g)
	{
		g.drawImage(mResultBackGround, 0, 0, null);
		g.drawImage(mLines[0], 350, 250, null);
		g.drawImage(mLines[1], 350, 310, null);
		g.drawImage(mLines[2], 350, 370, null);
		g.drawImage(mLines[3], 350, 430, null);
		g.drawImage(mNumbers[line1_hund], 490, 258, null);
		g.drawImage(mNumbers[line1_ten], 515, 258, null);
		g.drawImage(mNumbers[line1_one], 540, 258, null);
		g.drawImage(mNumbers[line2_hund], 490, 318, null);
		g.drawImage(mNumbers[line2_ten], 515, 318, null);
		g.drawImage(mNumbers[line2_one], 540, 318, null);
		g.drawImage(mNumbers[line3_hund], 490, 378, null);
		g.drawImage(mNumbers[line3_ten], 515, 378, null);
		g.drawImage(mNumbers[line3_one], 540, 378, null);
		g.drawImage(mNumbers[line4_hund], 490, 438, null);
		g.drawImage(mNumbers[line4_ten], 515, 438, null);
		g.drawImage(mNumbers[line4_one], 540, 438, null);
		g.drawImage(mPressEnterImage, 450, 600, null);
		
		if(mScore < 300){
			g.drawImage(mRanks[6], 750, 300, null);
		}
		else if (mScore < 700){
			g.drawImage(mRanks[5], 750, 300, null);
		}
		else if (mScore < 1200){
			g.drawImage(mRanks[4], 750, 300, null);
		}
		else if (mScore < 3000){
			g.drawImage(mRanks[3], 750, 300, null);
		}
		else if (mScore < 5000){
			g.drawImage(mRanks[2], 750, 300, null);
		}
		else if (mScore < 9000){
			g.drawImage(mRanks[1], 750, 300, null);
		}
		else if (mScore >= 9000){
			g.drawImage(mRanks[0], 750, 300, null);
		}
	}
}
