public class CLogic extends CModule {
	private CField mField;
	private CBlock mCurrentBlock;
	private CBlock mNextBlock;
	private CBlock mHoldBlock;
	private int mHoldBlockNum;
	private int [][] mCurrentBlockArr;
	private int [][] mFieldArrClone;
	private int [][] mColorArrClone;
	private Generator mBlockGenerator;
	
	private KeyInfo mKey;
	private int mInputKey;
	
	private boolean mFlagIsDown;
	private boolean mFlagFrozen;
	private boolean mFlagSpin;
	private boolean mFlagGameEnd;
	
	private boolean mIsFirstHold;
	
	private boolean mKeyPressed;
	private boolean[] mKeyPossible;
	
	private int[][] mFixedArr;
	
	private int PreX;
	private int PreY;
	private int mCountTime;
	private int mTurnBlackIndex;
	private int mBlockCount;
	
	private static final int UP = 0;
	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	private static final int SPACE = 4;
	private static final int KEY_P = 5;
	private static final int KEY_Q = 6;
	private static final int ENTER = 7;
	private static final int RELEASE = 8;
	
	public CLogic(KeyInfo key)
	{
		mKey = key;
	}

	public void Init()
	{	
		mCountTime = 0;
		mBlockCount = 0;
		mHoldBlock = new CBlock();
		mHoldBlock.SetColor(7);
		gameend = true;
		mFixedArr = new int[20][10];
		mKeyPossible = new boolean[9];
		mTurnBlackIndex = 19;
		int i = 0;
		int j = 0;
		for (i = 0; i < 20; i++)
		{
			for (j = 0; j < 10; j ++)
			{
				mFixedArr[i][j] = 0;
			}
		}
		mFlagIsDown = false;
		mFlagFrozen = false;
		mFlagSpin = false;
		mFlagGameEnd = false;
		
		mIsFirstHold = true;
		
		mField = new CField();
		mBlockGenerator = new Generator();
		
		mField.Init();
		mFieldArrClone = mField.GetFieldArr();
		mColorArrClone = mField.GetColorArr();
		
		
		//Init에서만 예외로 함수사용 하지 않고 새블록 생성
		mCurrentBlock = mBlockGenerator.GetNewBlock();
		mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
		GetPrePosi();
		
		mNextBlock = mBlockGenerator.GetNewBlock();
		
		mCurrentBlock.IntoArray();
		mInputKey = mKey.GetKey();
		for (i = 0; i < mKeyPossible.length; i++)
		{
			mKeyPossible[i] = true;
		}
	}
	
	public void Update()
	{
		if(!mFlagGameEnd)
		{
			mCountTime++;
			
			if(mFlagFrozen)
			{
				FrozenProcess();
			}
			
			mFlagIsDown = false;
			
			ProcessingKey();
			
			if(mCountTime == 60)
			{
				mCountTime = 0;
				BlockMove(DOWN);
			}
			
			mFlagSpin = false;
			
			JoinArr();
			mBlockCount++;
		}
		else
		{
			if(mCountTime == 6)
			{
				ColorTurnBlack(mTurnBlackIndex);
				mTurnBlackIndex--;
				mCountTime = 0;
			}
			mCountTime++;
			if (mTurnBlackIndex < 0 )
			{
				gameend = false;
			}
		}
	}

	public int[][] GetFixedArr()
	{
		return mFixedArr;
	}
	
	public int GetNextBlockNum()
	{
		return mNextBlock.GetBlockNum();
	}
	
	public int GetHoldBlockNum()
	{
		return mHoldBlock.GetBlockNum();
	}
	
	public int GetBlockCount()
	{
		return mBlockCount;
	}
	
	void JoinArr()
	{
		int i = 0;
		int j = 0;
		for (i = 0; i < 20; i++)
		{
			for (j = 0; j < 10; j++)
			{
				mFixedArr[i][j] = mColorArrClone[i][j];
			}
		}
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++)
			{
				if (mCurrentBlockArr[i][j] == 1)
				{
					mFixedArr[i + mCurrentBlock.GetPosiY()]
							 [j + mCurrentBlock.GetPosiX()]
									 = mCurrentBlockArr[i][j] * (mCurrentBlock.GetBlockNum()+1);
				}
			}
		}
	}
	
	void LineErase()
	{
		if(mField.EraseLine())
		{
			mField.ArrangeLine();
		}
	}
	
	void GetPrePosi()
	{
		PreX = mCurrentBlock.GetPosiX();
		PreY = mCurrentBlock.GetPosiY();
	}
	
	void SetBlockPosi()
	{
		mCurrentBlock.SetPosiX(PreX);
		mCurrentBlock.SetPosiY(PreY);
	}
	
	void ProcessingKey()
	{

		mInputKey = RELEASE;
		if(!mKeyPressed)
		{
			mInputKey = mKey.GetKey();
		}
		mKeyPressed = mKey.GetPressed();	
		
		switch(mInputKey)
		{
		case UP:
			mCurrentBlock.Spin();
			mFlagSpin = true;
			CheckWallCrash();
			break;
		case DOWN:
			BlockMove(DOWN);
			break;
		case LEFT:
			BlockMove(LEFT);
			break;
		case RIGHT:
			BlockMove(RIGHT);
			break;
		case SPACE:
			mCountTime = 0;
			while(!mFlagFrozen)
			{
				BlockMove(DOWN);
			}
			break;
		case ENTER:
			break;
		case KEY_Q:
			BlockHold();
			break;
		case KEY_P:
			break;
		}
	}
	
	void BlockMove(int direction)
	{
		GetPrePosi();
		switch(direction)
		{
		case LEFT:
			mCurrentBlock.MoveLeft();
			break;
		case RIGHT:
			mCurrentBlock.MoveRight();
			break;
		case DOWN:
			mCountTime = 0;
			mCurrentBlock.MoveDown();
			mFlagIsDown = true;
			break;
		}
		CheckWallCrash();
	}
	
	void CreateNewBlock()
	{
		GetPrePosi();
		mCurrentBlock = mBlockGenerator.GetNewBlock();
		mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
	}
	
	void ToNextBlock()
	{
		GetPrePosi();
		mCurrentBlock = mNextBlock;
		mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
		mNextBlock = mBlockGenerator.GetNewBlock();
	}
	
	void BlockHold()
	{
		GetPrePosi();
		if(!mIsFirstHold)
		{
			mHoldBlockNum = mHoldBlock.GetBlockNum();
			mHoldBlock = mCurrentBlock;
			mCurrentBlock = mBlockGenerator.GetHoldBlock(mHoldBlockNum);
			mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
		}
		else
		{	
			mHoldBlock = mCurrentBlock;
			ToNextBlock();
			mIsFirstHold = false;
		}
		mCountTime = 0;
	}
	
	void CheckWallCrash()
	{
		mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
		int i = 0;
		int j = 0;
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++)
			{
				if(mCurrentBlockArr[i][j] == 1 && (mCurrentBlockArr[i][j] &
					mFieldArrClone[i + mCurrentBlock.GetPosiY() + 1]
									  [j + mCurrentBlock.GetPosiX() + 1]) == 1)
				{
					if(mFlagIsDown)
					{
						mFlagFrozen = true;
						SetBlockPosi();
						return;
					}
					else if(mFlagSpin)
					{
						mCurrentBlock.BackSpin();
						mCurrentBlockArr = mCurrentBlock.GetCurrentBlockArr();
						return;
					}
					else
					{
						SetBlockPosi();
						return;
					}
				}
			}
		}
	}
	
	void ColorTurnBlack(int index)
	{
		int j = 0;
		for (j = 0 ; j < 10; j++)
		{
			mFixedArr[index][j] = 8;
		}
	}
	
	void FrozenProcess()
	{
		mBlockCount++;
		mCurrentBlock.ClearArray();
		mCurrentBlock.IntoArray();
		mField.AddField(mCurrentBlock.GetBlockArr(), (mCurrentBlock.GetBlockNum()+1));
		LineErase();
		ToNextBlock();
		mFlagFrozen = false;
		CheckWallCrash();
		if(mFlagFrozen)
		{
			mCurrentBlock.SetPosiX(3);
			mCurrentBlock.SetPosiY(0);
			mFlagGameEnd = true;
		}
	}
}
