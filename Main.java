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
    int cnt = 0;


    	tmp = array[indexLeft];

    	while(indexRight > indexLeft+1 && indexLeft != array.length-1) {
    		 //System.out.println("here");
    		if(array[indexRight] < pivot) {
    			cnt++;
    			//System.out.println("switch "+array[indexLeft]+" and "+array[indexRight]);
    			array[indexLeft] = array[indexRight];
    			array[indexRight] = tmp;
    			while(array[indexRight] > pivot && indexRight >indexLeft) {
    				indexRight--;
    				//System.out.println("_"+indexRight+" = "+array[indexRight]);
    			}
    			while(array[indexLeft] <= pivot && indexLeft<indexRight) {
    				indexLeft++;
       		    	//System.out.println("|"+indexLeft+" = "+array[indexLeft]);
    			}
    		}else {
    	    	//System.out.println("*"+indexRight+" = "+array[indexRight]);
    			indexRight--;
    		}
    	}
    	if(cnt == 0) {
    		return array;
    	}else {
    		//System.out.println("cnt" + cnt);
    		int[] pivotLess = Arrays.copyOfRange(array,  0, indexLeft);
        	int[] pivotLarge = Arrays.copyOfRange(array, indexRight, array.length);
        	if(pivotLess.length > 0) {
        	  	sort(pivotLess);
        	}
        	if(pivotLarge.length > 0) {
            	sort(pivotLarge);
        	}
    	}

    	//System.out.println(Arrays.toString(pivotLess));
        //System.out.println(Arrays.toString(pivotLarge));
    	return array;
    // ここまで記述
  }
}
