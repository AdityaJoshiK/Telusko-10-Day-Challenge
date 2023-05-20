public class PascalTriangle_Recursive {

    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(pascalTriangle(i, j) + " ");   
            }
            System.out.println();
        }
    }

    private static int pascalTriangle(int row, int col) {  
        if (col == 0 || col == row) {
            return 1;
        } else {
            return pascalTriangle(row - 1, col - 1) + pascalTriangle(row - 1, col);
        }
    }
}
