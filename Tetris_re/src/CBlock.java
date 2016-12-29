import java.util.Vector;


public class CBlock extends CModule{
	private Vector<BlockShape> mShape;
	private int mCurrentShapeNum = 0;
	private int mBlockArr[][];
	private BlockShape mBlockShape;
	private int mPosiX;
	private int mPosiY;
	private int mBlockColor;
	
	
	public void Update()
	{
		
	}
	
	public void Init()
	{
		mPosiX = 3;
		mPosiY = 0;
		mCurrentShapeNum = 0;
		mBlockShape = new BlockShape();
		mBlockArr = new int[20][10];
		mShape = new Vector<BlockShape>();
		mShape.add(mBlockShape);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mBlockArr[i][j] = 0;
			}
		}
	}
	
	public void ClearArray() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mBlockArr[i][j] = 0;
			}
		}
	}

	public void IntoArray() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (mShape.elementAt(mCurrentShapeNum).mBlocksArr[i][j] == 1) {
					mBlockArr[i + mPosiY][j + mPosiX] = 1;
				}
			}
		}
	}


	public void Spin() {
		if (mCurrentShapeNum >= mShape.size() - 1) 
		{
			mCurrentShapeNum = 0;
		} 
		else 
		{
			mCurrentShapeNum++;
		}
	};
	
	public void BackSpin() {
		if (mCurrentShapeNum == 0) 
		{
			mCurrentShapeNum = mShape.size() - 1;
		} 
		else 
		{
			mCurrentShapeNum--;
		}
	};

	public void MoveLeft() {
		mPosiX--;
	};

	public void MoveRight() {
		mPosiX++;
	};

	public void MoveDown() {
		mPosiY++;
	};
	
	public void SetInfo(BlockInfo info) {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				mBlockArr[i][j] = 0;
			}
		}
		mShape = info.Get();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				mBlockArr[i + mPosiY][j + mPosiX] = mShape.elementAt(mCurrentShapeNum).mBlocksArr[i][j];
			}
		}
	}
	
	public int[][] GetCurrentBlockArr()
	{
		return mShape.elementAt(mCurrentShapeNum).mBlocksArr;
	}
	
	public void SetColor(int color)
	{
		mBlockColor = color+1;
	}
	
	public int [][] GetBlockArr()
	{
		return mBlockArr;
	}
	
	public int GetBlockNum()
	{
		return mBlockColor - 1;
	}
	
	public int GetPosiX()
	{
		return mPosiX;
	}
	
	public void SetPosiX(int p_x)
	{
		mPosiX = p_x;
	}
	
	public int GetPosiY()
	{
		return mPosiY;
	}
	
	public void SetPosiY(int p_y)
	{
		mPosiY = p_y;
	}
}
