public class ThreadMin extends Thread {
    private final int startIndex;
    private final int finishIndex;
    private final ArrClass arrClass;
    private int min = Integer.MAX_VALUE;
    private int minIndex;

    public ThreadMin(int startIndex, int finishIndex, ArrClass arrClass) {
        this.startIndex = startIndex;
        this.finishIndex = finishIndex;
        this.arrClass = arrClass;
        this.minIndex = startIndex;
        this.min = arrClass.arr[startIndex];
    }

    @Override
    public void run() {
        for (int i = startIndex + 1; i < finishIndex; i++) {
            if (arrClass.arr[i] < min) {
                min = arrClass.arr[i];
                minIndex = i;
            }
        }
        arrClass.Update_min(min, minIndex);
    }
}
