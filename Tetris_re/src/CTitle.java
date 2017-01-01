
public class CTitle extends CModule {
	
	KeyInfo mKey;
	
	private int mInputKey;
	
	private boolean mKeyPressed;
	
	private boolean mFlagSelected;
	private boolean mFlagStart;
	
	private static final int UP = 0;
	private static final int DOWN = 3;
	private static final int ENTER = 7;
	private static final int RELEASE = 8;
	
	public CTitle(KeyInfo key)
	{
		mKey = key;
	}
	
	public void Init()
	{
		mInputKey = mKey.GetKey();
		mFlagStart = true;
		mFlagSelected = false;
	}
	
	public void Update()
	{
		ProcessingKey();
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
			ChangeStartStatus();
			break;
		case DOWN:
			ChangeStartStatus();
			break;
		case ENTER:
			mFlagSelected = true;
			break;
		}
	}
	
	public boolean GetStartFlag()
	{
		return mFlagStart;
	}
	
	public boolean GetSelectFlag()
	{
		return mFlagSelected;
	}
	
	void ChangeStartStatus()
	{
		if (mFlagStart)
		{
			mFlagStart = false;
		}
		else
		{
			mFlagStart = true;
		}
	}
}
