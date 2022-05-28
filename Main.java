import java.util.Arrays;

class Main {

  public static void main(String[] args) {
    // ランダムに並べられた重複のない整数の配列
    var array = new int[] { 5, 4, 6, 2, 1, 9, 8, 3, 7, 10 };
    // ソート実行
    var sortedArray = new Main().sort(array);
    // 結果出力
    Arrays.stream(sortedArray).forEach(System.out::println);
  }

  private int[] sort(int[] array) {
    // 要素が一つの場合はソートの必要がないので、そのまま返却
    if (array.length == 1) {
      return array;
    }

    // 配列の先頭を基準値とする
    var pivot = array[0];

    // ここから記述
    int indexLeft = 0;
    int indexRight = array.length-1;
    int tmp = 0;

    //while(indexLeft < array.length-1 && indexRight >=1) {
    	tmp = array[indexLeft];

    	while(indexRight > indexLeft+1) {
    		if(array[indexRight] < pivot) {
    			array[indexLeft] = array[indexRight];
    			array[indexRight] = tmp;
    			while(array[indexRight] > pivot && indexRight >1) {
    				indexRight--;
    			}
    			while(array[indexLeft] <= pivot && indexLeft<array.length-1) {

    				indexLeft++;
    			}
    		}else {
    			indexRight--;
    		}
    	}

    return array;
    // ここまで記述
  }
}
