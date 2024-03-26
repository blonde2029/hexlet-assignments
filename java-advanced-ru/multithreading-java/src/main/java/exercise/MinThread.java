package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] array;
    private int min;

    public int getMin() {
        return min;
    }

    public MinThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println("MinThread started");
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        this.min = min;
        System.out.println("MinThread finished");
    }
}
// END
