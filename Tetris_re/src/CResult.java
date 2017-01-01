
public class CResult extends CModule{
KeyInfo mKey;
	
	private int mInputKey;
	
	private boolean mKeyPressed;
	
	private boolean mFlagPressEnter;
	
	private static final int ENTER = 7;
	private static final int RELEASE = 8;
	
	public CResult(KeyInfo key)
	{
		mKey = key;
	}
	
	public void Init()
	{
		mInputKey = mKey.GetKey();
		mFlagPressEnter = false;
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
		case ENTER:
			mFlagPressEnter = true;
			break;
		}
	}
	
	public boolean GetEnterStatus()
	{
		return mFlagPressEnter;
	}
}
