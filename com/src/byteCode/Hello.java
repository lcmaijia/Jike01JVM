package src.byteCode;

public class Hello {
    private static int count = 0;

    private static double sum = 0.0D;

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        submit(num1);
        submit(num2);
        double avg = getAvg();
        System.out.println(avg);
    }

    public static double getAvg() {
        if (0 == count) {
            return sum;
        }
        return sum/count;
    }

    public static void submit(double value){
        count ++;
        sum += value;
    }

}
