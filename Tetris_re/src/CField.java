public class CField extends CModule{
	private int mFieldArr[][];
	private int mColorArr[][];
	private int mLeaveArr[][];
	private int mColorLeaveArr[][];
	
	public void Init()
	{
		mFieldArr = new int[22][12];
		mColorArr = new int[22][12];
		mLeaveArr = new int[20][10];
		mColorLeaveArr = new int[20][10];
		ClearField();
	}
	
	public void ClearField() {
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 12; j++) {
				if (i == 0 || i == 21)
				{
					mFieldArr[i][j] = 1;
				}
				else if (j == 0 || j == 11)
				{
					mFieldArr[i][j] = 1;
				}
				else
				{
					mFieldArr[i][j] = 0;
				}
			}
		}
	}
	
	public void ClearColorArr() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mColorArr[i][j] = 0;
			}
		}
	}
	

	public void ClearLeave() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mLeaveArr[i][j] = 0;
			}
		}
	}
	
	public void ClearColorLeave() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mColorLeaveArr[i][j] = 0;
			}
		}
	}
	
	
	
	public void AddField(int[][] BlockArr, int color) 
	{
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if (BlockArr[i][j] == 1) {
					mFieldArr[i+1][j+1] = 1;
					mColorArr[i][j] = 1 * color;
				}
			}
		}
	}
	
	public boolean EraseLine()
	{
		int i = 0;
		int j = 0;
		int blockcount = 0;
		boolean iserased = false;
		
		
		for (i = 0; i < 20; i++)
		{
			blockcount = 0;
			for (j = 0; j < 10; j++)
			{
				if(mFieldArr[i+1][j+1] == 1)
				{
					blockcount++;
				}
			}
			if (blockcount == 10)
			{
				for (j = 0; j < 10; j++)
				{
					mFieldArr[i+1][j+1] = 0;
					mColorArr[i][j] = 0;
				}
				iserased = true;
			}
		}
		return iserased;
	}
	
	public void ArrangeLine()
	{
		int i = 0;
		int j = 0;
		int colornum = 0;
		int leaveindex = 0;
		int pullindex = 19;
		boolean isprocced = false;
		ClearLeave();
		ClearColorLeave();
		
		for (i = 19; i >= 0; i--)
		{
			for (j = 0; j < 10; j++)
			{
				if (mFieldArr[i+1][j+1] == 1)
				{
					mLeaveArr[leaveindex][j] = 1;
					colornum = mColorArr[i][j];
					mColorLeaveArr[leaveindex][j] = colornum;
					isprocced = true;
				}
			}
			if (isprocced)
			{
				leaveindex++;
				isprocced = false;
			}
		}
		
		ClearField();
		ClearColorArr();

		for (i = 0; i < leaveindex; i++)
		{
			for (j = 0; j < 10; j++)
			{
				mFieldArr[pullindex+1][j+1] = mLeaveArr[i][j];
				mColorArr[pullindex][j] = mColorLeaveArr[i][j];
			}	
			pullindex--;
		}
	}


	public int[][] GetFieldArr()
	{
		return mFieldArr;
	}
	
	public int [][] GetColorArr()
	{
		return mColorArr;
	}
}
