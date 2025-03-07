import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Load matrices
            SparseMatrix matrix1 = new SparseMatrix("/Sparse-Matrix/Sample-inputs/matrixfile1.txt");
            SparseMatrix matrix2 = new SparseMatrix("/Sparse-Matrix/Sample-inputs/matrixfile3.txt");

            // Perform operations
            SparseMatrix resultAdd = matrix1.add(matrix2);
            SparseMatrix resultSub = matrix1.subtract(matrix2);
            SparseMatrix resultMul = matrix1.multiply(matrix2);

            // Save results to the results folder
            resultAdd.saveToFile("/Sparse-Matrix/results/result_add.txt");
            resultSub.saveToFile("/Sparse-Matrix/results/result_sub.txt");
            resultMul.saveToFile("/Sparse-Matrix/results/result_mul.txt");

            System.out.println("Operations completed successfully. Check the results folder for output files.");
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error performing matrix operations: " + e.getMessage());
        }
    }
}
