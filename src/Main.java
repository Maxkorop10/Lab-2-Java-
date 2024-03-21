public class Main {
    public static void main(String[] args) throws Exception {
        int dim = 200;
        int thread_num = 4;
        ArrClass arrClass = new ArrClass(dim, thread_num);

        int minElement = arrClass.find_min();

        System.out.println("\nMinimal element: " + minElement);
        System.out.println("Index of minimal element: " + arrClass.minIndex + "\n");
    }
}