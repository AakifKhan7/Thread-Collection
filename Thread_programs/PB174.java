package Thread_programs;

public class PB174 {
    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        int[][] matrix = genrateMatrix(m, n);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        RowSumThread[] threads = new RowSumThread[m];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new RowSumThread(matrix[i], i);
            threads[i].start();
        }

        for (RowSumThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static int[][] genrateMatrix(int m, int n){
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] =  (int) Math.round(Math.random() * 10);
            }
        }
        return matrix;
    }
}

class RowSumThread extends Thread{

    int[] row;
    int rowNumber;
    double sum;

    RowSumThread(int[] row, int rowNumber){
        this.row = row;
        this.rowNumber = rowNumber;
        this.sum = 0.0;
    }

    public void run(){
        for(double num: row){
            sum += num;
        }
        System.out.println("Sum of elements in Row " + rowNumber + ": " + sum);
    }

    public double getSum(){
        return sum;
    }
}