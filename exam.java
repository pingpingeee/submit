import java.util.Random;

public class exam {
    public static void main(String[] args) {
        int[][] numArr = new int[3][4];
        Random random = new Random();
        int sum = 0;

        for (int i = 0; i < numArr.length; i++) {
            for (int j = 0; j < numArr[0].length; j++) {
                numArr[i][j] = random.nextInt(9);
                System.out.print(numArr[i][j] + "\t");
                sum += numArr[i][j];
            }
            System.out.println();
        }
        System.out.println("합은 " + sum);
    }
}
