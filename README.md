# Sparse Matrix Operations - DSA Assignment

This project implements a **sparse matrix** data structure and operations for the Data Structures and Algorithms course. The implementation focuses on **memory and computational efficiency** for handling large matrices where most elements are zero.

---

## **Assignment Requirements**
- Implement a custom sparse matrix data structure.
- Do **not** use standard template libraries or built-in matrix libraries.
- Optimize for both **memory usage** and **runtime performance**.
- Support large matrix operations (e.g., 8433 x 3180 matrices).

---

## **Features**
### **Core Operations**
- Matrix addition
- Matrix subtraction
- Matrix multiplication
- Element access and modification
- File I/O operations

### **Optimizations**
- Efficient storage of **non-zero elements only**.
- Optimized algorithms for sparse matrix operations.
- Memory-efficient implementation.

---

## **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/sparse-matrix-assignment.git
Navigate to the project directory:

bash
Copy
cd sparse-matrix-assignment/dsa/sparse_matrix/code/src
Compile the Java files:

bash
Copy
javac Main.java
Run the program:

bash
Copy
java Main
File Format
Input files must strictly follow this format:


The first line must specify the number of rows.

The second line must specify the number of columns.

Each subsequent line contains one matrix element.

Elements must be in parentheses with integers separated by commas.

Whitespace is ignored.

Only non-zero elements should be listed.

Implementation Details
Data Structure
Custom implementation without using standard template libraries.

Optimized for sparse matrix operations.

Efficient memory usage by storing only non-zero elements.

Core Functions
java
Copy
SparseMatrix(String matrixFilePath) // Constructor to load matrix from file
SparseMatrix(int numRows, int numCols) // Constructor to create an empty matrix
int getElement(int row, int col) // Access element at (row, col)
void setElement(int row, int col, int value) // Modify element at (row, col)
Operations
Matrix Addition: O(n₁ + n₂), where n₁ and n₂ are the number of non-zero elements in the two matrices.

Matrix Subtraction: O(n₁ + n₂).

Matrix Multiplication: Optimized for sparse matrices.

Error Handling
The implementation includes comprehensive error handling for:

Invalid file formats.

Matrix dimension mismatches.

Out-of-bounds access.

Memory allocation failures.

Author
TonnyleeM
