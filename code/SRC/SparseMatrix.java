import java.io.*;
import java.util.*;

public class SparseMatrix {
    private int rows;
    private int cols;
    private Map<String, Integer> elements;

    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new HashMap<>();
    }

    public SparseMatrix(String filePath) throws IOException {
        this.elements = new HashMap<>();
        loadFromFile(filePath);
    }

    private void loadFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (lineNumber == 0) {
                this.rows = Integer.parseInt(line.split("=")[1].trim());
            } else if (lineNumber == 1) {
                this.cols = Integer.parseInt(line.split("=")[1].trim());
            } else {
                String[] parts = line.replace("(", "").replace(")", "").split(",");
                int row = Integer.parseInt(parts[0].trim());
                int col = Integer.parseInt(parts[1].trim());
                int value = Integer.parseInt(parts[2].trim());
                setElement(row, col, value);
            }
            lineNumber++;
        }
        reader.close();
    }

    public void setElement(int row, int col, int value) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        String key = row + "," + col;
        if (value == 0) {
            elements.remove(key);
        } else {
            elements.put(key, value);
        }
    }

    public int getElement(int row, int col) {
        String key = row + "," + col;
        return elements.getOrDefault(key, 0);
    }

    public SparseMatrix add(SparseMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        SparseMatrix result = new SparseMatrix(rows, cols);
        for (Map.Entry<String, Integer> entry : this.elements.entrySet()) {
            result.setElement(
                Integer.parseInt(entry.getKey().split(",")[0]),
                Integer.parseInt(entry.getKey().split(",")[1]),
                entry.getValue()
            );
        }
        for (Map.Entry<String, Integer> entry : other.elements.entrySet()) {
            int row = Integer.parseInt(entry.getKey().split(",")[0]);
            int col = Integer.parseInt(entry.getKey().split(",")[1]);
            result.setElement(row, col, result.getElement(row, col) + entry.getValue());
        }
        return result;
    }

    public SparseMatrix subtract(SparseMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }
        SparseMatrix result = new SparseMatrix(rows, cols);
        for (Map.Entry<String, Integer> entry : this.elements.entrySet()) {
            result.setElement(
                Integer.parseInt(entry.getKey().split(",")[0]),
                Integer.parseInt(entry.getKey().split(",")[1]),
                entry.getValue()
            );
        }
        for (Map.Entry<String, Integer> entry : other.elements.entrySet()) {
            int row = Integer.parseInt(entry.getKey().split(",")[0]);
            int col = Integer.parseInt(entry.getKey().split(",")[1]);
            result.setElement(row, col, result.getElement(row, col) - entry.getValue());
        }
        return result;
    }

    public SparseMatrix multiply(SparseMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrices cannot be multiplied: columns of first matrix must equal rows of second matrix.");
        }
        SparseMatrix result = new SparseMatrix(this.rows, other.cols);
        for (Map.Entry<String, Integer> entry1 : this.elements.entrySet()) {
            int row1 = Integer.parseInt(entry1.getKey().split(",")[0]);
            int col1 = Integer.parseInt(entry1.getKey().split(",")[1]);
            for (Map.Entry<String, Integer> entry2 : other.elements.entrySet()) {
                int row2 = Integer.parseInt(entry2.getKey().split(",")[0]);
                int col2 = Integer.parseInt(entry2.getKey().split(",")[1]);
                if (col1 == row2) {
                    result.setElement(row1, col2, result.getElement(row1, col2) + entry1.getValue() * entry2.getValue());
                }
            }
        }
        return result;
    }

    public void saveToFile(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write("rows=" + rows + "\n");
        writer.write("cols=" + cols + "\n");
        for (Map.Entry<String, Integer> entry : elements.entrySet()) {
            writer.write("(" + entry.getKey().replace(",", ", ") + ", " + entry.getValue() + ")\n");
        }
        writer.close();
    }
}
