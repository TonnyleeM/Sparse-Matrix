import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Corrected paths - use ../ to go up one level from SRC directory
            SparseMatrix matrix1 = new SparseMatrix("../../Sample-inputs/matrixfile1.txt");
            SparseMatrix matrix2 = new SparseMatrix("../../Sample-inputs/matrixfile3.txt");
            
            SparseMatrix resultAdd = matrix1.add(matrix2);
            SparseMatrix resultSub = matrix1.subtract(matrix2);
            SparseMatrix resultMul = matrix1.multiply(matrix2);
            
            // Create results directory if it doesn't exist
            new java.io.File("../../results").mkdirs();
            
            resultAdd.saveToFile("../../results/result_add.txt");
            resultSub.saveToFile("../../results/result_sub.txt");
            resultMul.saveToFile("../../results/result_mul.txt");
            
            System.out.println("Operations completed successfully. Check the results folder for output files.");
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error performing matrix operations: " + e.getMessage());
        }
    }
}
