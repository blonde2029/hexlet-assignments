package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] array;
    private int max;

    public MaxThread(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        System.out.println("MaxThread started");
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        this.max = max;
        System.out.println("MaxThread finished");
    }
}
// END
