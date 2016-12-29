import java.util.Random;

public class Generator {
	private Random mRand;
	private BlockInfo mInfoArr[];
	private int mRandomValue;

    Generator(){
    	mRand = new Random();
    	
    	//0 - I
    	//1 - O
    	//2 - L
    	//3 - J
    	//4 - S
    	//5 - Z
    	//6 - T
    	
    	mInfoArr = new BlockInfo[7];
    	{ // I
	    	mInfoArr[0] = new BlockInfo();
	    	mInfoArr[0].AddShape(new int[] {
	    			1,1,1,1,
	    			0,0,0,0,
	    			0,0,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[0].AddShape(new int[] {
	    			0,1,0,0,
	    			0,1,0,0,
	    			0,1,0,0,
	    			0,1,0,0
	    	});
	    	
    	}
    	{ // O
    		mInfoArr[1] = new BlockInfo();
	    	mInfoArr[1].AddShape(new int[] {
	    			0,1,1,0,
	    			0,1,1,0,
	    			0,0,0,0,
	    			0,0,0,0
	    	});	
    	}
    	{ // L
    		mInfoArr[2] = new BlockInfo();
	    	mInfoArr[2].AddShape(new int[] {
	    			0,1,0,0,
	    			0,1,0,0,
	    			0,1,1,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[2].AddShape(new int[] {
	    			0,0,0,0,
	    			0,1,1,1,
	    			0,1,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[2].AddShape(new int[] {
	    			0,0,0,0,
	    			0,1,1,0,
	    			0,0,1,0,
	    			0,0,1,0
	    	});
	    	mInfoArr[2].AddShape(new int[] {
	    			0,0,0,0,
	    			0,0,1,0,
	    			1,1,1,0,
	    			0,0,0,0
	    	});
    		
    	}
    	{ // J
    		mInfoArr[3] = new BlockInfo();
	    	mInfoArr[3].AddShape(new int[] {
	    			0,0,1,0,
	    			0,0,1,0,
	    			0,1,1,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[3].AddShape(new int[] {
	    			0,0,0,0,
	    			0,1,0,0,
	    			0,1,1,1,
	    			0,0,0,0
	    	});
	    	mInfoArr[3].AddShape(new int[] {
	    			0,0,0,0,
	    			0,1,1,0,
	    			0,1,0,0,
	    			0,1,0,0
	    	});
	    	mInfoArr[3].AddShape(new int[] {
	    			0,0,0,0,
	    			1,1,1,0,
	    			0,0,1,0,
	    			0,0,0,0
	    	});
    	}
    	{ // S
    		mInfoArr[4] = new BlockInfo();
	    	mInfoArr[4].AddShape(new int[] {
	    			0,1,1,0,
	    			1,1,0,0,
	    			0,0,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[4].AddShape(new int[] {
	    			0,1,0,0,
	    			0,1,1,0,
	    			0,0,1,0,
	    			0,0,0,0
	    	});
    	}
    	{ // Z
    		mInfoArr[5] = new BlockInfo();
	    	mInfoArr[5].AddShape(new int[] {
	    			0,1,1,0,
	    			0,0,1,1,
	    			0,0,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[5].AddShape(new int[] {
	    			0,0,1,0,
	    			0,1,1,0,
	    			0,1,0,0,
	    			0,0,0,0
	    	});
    		
    	}
    	{ // T
    		mInfoArr[6] = new BlockInfo();
	    	mInfoArr[6].AddShape(new int[] {
	    			0,1,0,0,
	    			1,1,1,0,
	    			0,0,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[6].AddShape(new int[] {
	    			0,1,0,0,
	    			0,1,1,0,
	    			0,1,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[6].AddShape(new int[] {
	    			0,0,0,0,
	    			1,1,1,0,
	    			0,1,0,0,
	    			0,0,0,0
	    	});
	    	mInfoArr[6].AddShape(new int[] {
	    			0,1,0,0,
	    			1,1,0,0,
	    			0,1,0,0,
	    			0,0,0,0
	    	});
    	}
    }
    
    CBlock GetNewBlock()
    {
    	mRandomValue = mRand.nextInt(7);
    	CBlock a = new CBlock();
    	a.Init();
    	a.SetColor(mRandomValue);
    	a.SetInfo(mInfoArr[mRandomValue]);
    	
    	return a;
    }
    
    CBlock GetHoldBlock(int number)
    {
    	CBlock a = new CBlock();
    	a.Init();
    	a.SetColor(number);
    	a.SetInfo(mInfoArr[number]);
    	
    	return a;
    }
}
