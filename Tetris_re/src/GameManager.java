import java.util.Vector;

public class GameManager 
{
	private Vector<CModule> modules;
	private WindowFrame window;
	private Renderer rend;
	private CKeyinput mKeyModule;
	private CLogic mLogicModule;
	private static final double MS_PER_UPDATE = 1000/60;
	//Init GameManger
	
	public GameManager()
	{
		modules = new Vector<CModule>();
		mKeyModule = new CKeyinput();
		modules.add(mKeyModule);
		mLogicModule = new CLogic(mKeyModule);
		modules.add(mLogicModule);
		int i;
		for (i = 0; i < modules.size(); i++)
		{
			modules.elementAt(i).Init();
		}
		rend = new Renderer();
		rend.Init();
		window = new WindowFrame((CKeyinput)modules.elementAt(0), rend);
	}
	
	public void Run()
	{
		double previous_time;
		double current_time;
		double lag;
		double sleep_time;
		while(modules.elementAt(1).gameend)
		{
			previous_time = System.currentTimeMillis();
			GameUpdate();
			GameRender();			
			current_time = System.currentTimeMillis();
			lag = current_time - previous_time;
			sleep_time = MS_PER_UPDATE - lag;
			if(sleep_time < 0)
				sleep_time = 0;
			System.out.println(sleep_time);
			try {
				Thread.sleep((long) sleep_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		rend.SetFixedArr(mLogicModule.GetFixedArr());
		rend.SetNextBlockNum(mLogicModule.GetNextBlockNum());
		rend.SetHoldBlockNum(mLogicModule.GetHoldBlockNum());
		rend.repaint();
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
}
