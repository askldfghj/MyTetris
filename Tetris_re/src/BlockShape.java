
public class BlockShape {
	public int mBlocksArr[][];

	public BlockShape() {
		mBlocksArr = new int[4][4];
	}

	public void SetValue(int[] values) {
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				mBlocksArr[i][j] = values[j + i * 4];
			}
		}
	}
}
