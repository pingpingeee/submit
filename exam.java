import java.util.Random;

public class exam {
    public static void main(String[] args) {
        int[][] numArr = new int[3][4];
        int sum = 0;

        for (int i = 0; i < numArr.length; i++) {
            for (int j = 0; j < numArr[0].length; j++) {
                numArr[i][j] = new Random().nextInt(9) + 1;
                System.out.print(numArr[i][j] + "\t");
                sum += numArr[i][j];
            }
            System.out.println();
        }
        System.out.println("합은 " + sum);
    }
}
