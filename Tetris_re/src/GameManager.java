import java.util.Vector;

public class GameManager 
{
	private Vector<CModule> modules;
	private WindowFrame window;
	private Renderer rend;
	private CKeyinput mKeyModule;
	private CTitle mTitleModule;
	private CLogic mLogicModule;
	private CResult mResultModule;
	
	private int mCurrentScene;
	private double mPreviousTime;
	private double mCurrentTime;
	private double mLag;
	private double mSleeptime;
	
	private static final double MS_PER_UPDATE = 1000/60;
	//Init GameManger

	private static final int SCENE1 = 1;
	private static final int SCENE2 = 2;
	private static final int SCENE3 = 3;
	
	public GameManager()
	{
		mCurrentScene = 1;
		modules = new Vector<CModule>();
		
		mKeyModule = new CKeyinput();
		modules.add(mKeyModule);
		
		mTitleModule = new CTitle(mKeyModule);
		mLogicModule = new CLogic(mKeyModule);
		mResultModule = new CResult(mKeyModule);
		
		
		rend = new Renderer();
		rend.Init();
		
		window = new WindowFrame((CKeyinput)modules.elementAt(0), rend);
		
		mKeyModule.Init();
		
	}
	
	public void Run()
	{
		while(true)
		{
			mCurrentScene = 1;
			
			mTitleModule.Init();
			modules.add(mTitleModule);
			
			while(!mTitleModule.GetSelectFlag())
			{
				GameLoop();
			}
			if(!mTitleModule.GetStartFlag())
			{
				break;
			}
			mCurrentScene = 2;
			
			modules.removeElementAt(modules.size()-1);
			mLogicModule.Init();
			modules.add(mLogicModule);
			while(mLogicModule.gameend)
			{
				GameLoop();
			}
			mLogicModule.ComputeRank();
			rend.SetErasedLineResult(mLogicModule.GetErasedLineResult());
			rend.ResultBoardArrange();
			mCurrentScene = 3;
			
			modules.removeElementAt(modules.size()-1);
			mResultModule.Init();
			modules.add(mResultModule);
			while(!mResultModule.GetEnterStatus())
			{
				GameLoop();
			}
			modules.removeElementAt(modules.size()-1);
		}
	}
	void GameUpdate()
	{
		int index = 0;
		for (index = 0; index < modules.size(); index++)
		{
			modules.elementAt(index).Update();
		}
	}
	void GameRender()
	{
		switch(mCurrentScene)
		{
		case SCENE1:
			rend.SetStartFlag(mTitleModule.GetStartFlag());
			rend.SetSceneStatus(mCurrentScene);
			rend.repaint();
			break;
		case SCENE2:
			rend.SetFixedArr(mLogicModule.GetFixedArr());
			rend.SetNextBlockNum(mLogicModule.GetNextBlockNum());
			rend.SetHoldBlockNum(mLogicModule.GetHoldBlockNum());
			rend.SetBlockCount(mLogicModule.GetBlockCount());
			rend.SetGameStatus(mLogicModule.GetGameStatus());
			rend.SetSceneStatus(mCurrentScene);
			rend.repaint();
			break;
		case SCENE3:
			rend.SetSceneStatus(mCurrentScene);
			rend.repaint();
			break;
		}
	}
	
	public void GameEnd()
	{
		int index;
		for (index = modules.size()-1; index >= 0; index--)
		{
			modules.elementAt(index).Destroy();	
		}
		modules.removeAllElements();
	}
	
	void GameLoop()
	{
		mPreviousTime = System.currentTimeMillis();
		GameUpdate();
		GameRender();			
		mCurrentTime = System.currentTimeMillis();
		mLag = mCurrentTime - mPreviousTime;
		mSleeptime = MS_PER_UPDATE - mLag;
		if(mSleeptime < 0)
			mSleeptime = 0;
		System.out.println(mSleeptime);
		try {
			Thread.sleep((long) mSleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
