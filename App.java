import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a size for your matrix: ");

        int size = scanner.nextInt();

        int[][] m1 = randomMatrix(size);
        int[][] m2 = randomMatrix(size);

        matrixToFile(m1, "matrix1.txt");
        matrixToFile(m2, "matrix2.txt");

        int[][] result = multiply(m1, m2);
        matrixToFile(result, "matrix3.txt");

        System.out.println("Output succesfull");



        scanner.close();
    }

    public static int[][] multiply(int[][] m1, int[][] m2){
        int[][] result = new int[m1.length][m2[0].length]; 
        for(int i = 0; i < m1.length; i++){
         for(int j = 0; j < m2[0].length; j++){
             for(int k = 0; k < m1[0].length; k++){
                 result[i][j] += m1[i][k] * m2[k][j];
             }
         }
        }
        return result;
     }

     public static int[][] randomMatrix(int size){
        Random random = new Random();
        
        int matrix[][] = new int[size][size];
    
    
        for( int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = random.nextInt(11);
    
            }
        }
    
        return matrix;
    }
    
    public static void matrixToFile(int[][] matrix, String fileName){
        try (PrintWriter writer = new PrintWriter(new File(fileName))){
        for(int[] row : matrix){
           for(int i = 0; i < row.length; i++){
               writer.print(row[i]);
               if(i < row.length - 1){
                   writer.print(" ");
               }
           }
           writer.println();
        }
       }
         catch (IOException e) {
           e.printStackTrace();
        }
    }
}
