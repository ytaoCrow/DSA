package sections4;

// 如果可以拿到 index 的話，search by index O(1) 會是最好的查詢效能
// 如果只能拿到 value 的話，search by value O(n) 會是最差的查詢效能
// 如果在最後面新增資料的話，add by value O(1) 會是最好的新增效能
// 如果在中間新增資料的話，add by index O(n) 會是最差的新增效能
// 其餘操作皆為 O(n) 的效能
// 其餘大部分都是 O(n) 的效能
public class Array {

  // 初始化容器
  private Integer[] array;

  // Index 結尾
  private Integer iEnd;

  // 建構子
  public Array(int size) {
    this.array = new Integer[size];
    this.iEnd = -1;
  }

  public void addByIndex(int iAdd, int value){

    /** step0.01：如果記憶體數量滿了，則新增記憶體大小 **/
    if (iEnd + 1 == array.length) expandSpace();

    /** step00：檢核 iAdd 參數是否為零，若為零則跳出 methods **/
    if(iAdd > iEnd +1 || iAdd < 0) return;

    /** step01：現有的值往右移一格 **/
    /** 用在當超過記憶體大小的時候，將所有的值往右移一格 **/
    // 問題：現有的iEnd值(-1)是不可能近來回圈的，所以要給他iEnd的值
    for(int i = iEnd; i >= iAdd; i--){
      array[i+1] = array[i];
      array[i] = null;
    }

    array[iAdd] = value;
    iEnd++;
  }

  public void addByValue(int value){
    addByIndex(iEnd + 1, value);
  }

  private void expandSpace() {
    // 在新的Array給他原來的2倍長度大小
    Integer[] arrayNew = new Integer[array.length * 2];

    // 把原本的Array的值複製到新的Array
    for(int i = 0; i < array.length; i++){
      arrayNew[i] = array[i];
    }
    // 把新的Array覆寫到原本的Array
    this.array = arrayNew;
  }

  public Integer searchByIndex(int index){
    if(index > iEnd || index < 0) return null;

    return array[index];
  }

  public Integer searchByValue(int value){
    for(int i = 0; i <= iEnd; i++){
      if(array[i] == value) return i;
    }
    return null;
  }

  public void deleteByIndex(int index){
    if(index > iEnd || index < 0) return;

    for(int i = index + 1; i < iEnd; i++){
      array[i-1] = array[i];
      array[i] = null;
    }
    iEnd--;
  }

  public void deleteByValue(int value){
    for(int i = 0; i <= iEnd; i++){
      if(array[i] == value){
        deleteByIndex(i);
        return;
      }
    }
  }


  public static void main(String[] args) {
    Array array = new Array(5);
    array.addByValue(11);
    array.addByValue(22);
    array.addByValue(33);
    array.addByValue(44);
    array.addByValue(55);

    /** add by value O(1) + expand O(n) **/
    array.addByValue(66666);
    /** add by index O(n) **/
    int iAdd = 1;
    array.addByIndex(iAdd, 50);

    /** search by value O(n) **/
    int value02 = array.searchByValue(98);
    /** search by Index O(1) **/
    int value01 = array.searchByIndex(4);

    /** delete by value O(n) **/
    array.deleteByValue(22);
    /** delete by Index O(n) **/
    array.deleteByIndex(3);

    System.out.println();
  }
}
