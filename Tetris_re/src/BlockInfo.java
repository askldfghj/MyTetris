import java.util.Vector;

public class BlockInfo {
	private Vector<BlockShape> mInfos;

	public BlockInfo() {
		mInfos = new Vector<BlockShape>();
	}

	public void AddShape(int[] shape) {
		BlockShape newShape = new BlockShape();
		newShape.SetValue(shape);
		mInfos.add(newShape);
	}

	public Vector<BlockShape> Get() {
		return mInfos;
	}
}
