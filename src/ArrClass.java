public class ArrClass {
    private final int dim;
    private final int thread_num;
    public final int[] arr;
    public int minIndex;

    public ArrClass(int dim, int thread_num) {
        this.dim = dim;
        arr = new int[dim];
        this.thread_num = thread_num;
        generateArray();
    }

    private void generateArray() {
        for (int i = 0; i < dim; i++) {
            if (i == 10) { arr[i] = -29; } 
            else { arr[i] = i; }
        }
    }

    public int find_min() {
        ThreadMin[] threads = new ThreadMin[thread_num];
        int partSize = dim / thread_num;

        for (int i = 0; i < thread_num; i++) {
            int startIndex = i * partSize;
            int finishIndex = (i + 1) * partSize;
            if (i == thread_num - 1) { finishIndex = dim; }
            threads[i] = new ThreadMin(startIndex, finishIndex, this);
        }

        for (ThreadMin thread : threads) { thread.start(); }

        for (ThreadMin thread : threads) {
            try { thread.join(); } 
            catch (InterruptedException e) { e.printStackTrace(); }
        }

        return arr[minIndex];
    }

    synchronized public void Update_min(int min, int index) {
        if (min < arr[minIndex]) {
            arr[minIndex] = min;
            this.minIndex = index;
        }
    }
}
