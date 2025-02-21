DSA Assignment - Sparse Matrix Operations
Overview
This project implements a sparse matrix data structure and operations for the Data Structures and Algorithms course. The implementation focuses on memory and computational efficiency for handling large matrices where most elements are zero.
Assignment Requirements

Implementation of a custom sparse matrix data structure
No usage of standard template libraries or built-in matrix libraries
Optimization for both memory usage and runtime performance
Support for large matrix operations (e.g., 8433 x 3180 matrices)

Features
Core Operations

Matrix addition
Matrix subtraction
Matrix multiplication
Element access and modification
File I/O operations

Optimizations

Efficient storage of non-zero elements only
Optimized algorithms for sparse matrix operations
Memory-efficient implementation

Installation

Clone the repository:

bashCopygit clone <your-repository-url>

Navigate to the project directory:

bashCopycd sparse-matrix-assignment

No external dependencies required - implementation uses standard language features only.

File Format
Input files must strictly follow this format:
Copyrows=<number_of_rows>
cols=<number_of_columns>
(<row>, <column>, <value>)
(<row>, <column>, <value>)
...
Example:
Copyrows=8433
cols=3180
(0, 381, -694)
(0, 128, -838)
(0, 639, 857)
Format Rules

First line must specify number of rows
Second line must specify number of columns
Each subsequent line contains one matrix element
Elements must be in parentheses with integers separated by commas
Whitespace is ignored
Only non-zero elements should be listed

Implementation Details
Data Structure

Custom implementation without using standard template libraries
Optimized for sparse matrix operations
Efficient memory usage by storing only non-zero elements

Core Functions
pythonCopySparseMatrix(char* matrixFilePath)  # Constructor from file
SparseMatrix(int numRows, int numCols)  # Constructor with dimensions
getElement(int currRow, int currCol)  # Access element
setElement(int currRow, int currCol, int value)  # Modify element
Operations

Matrix Addition: O(n₁ + n₂) where n₁, n₂ are non-zero elements
Matrix Subtraction: O(n₁ + n₂)
Matrix Multiplication: Optimized for sparse matrices

Error Handling
The implementation includes comprehensive error handling for:

Invalid file formats
Matrix dimension mismatches
Out-of-bounds access
Memory allocation failures

Error Types

std::invalid_argument for format errors
std::out_of_range for invalid indices
std::runtime_error for operational errors

Testing
To verify your implementation:

Use the provided sample input files
Test with various matrix sizes
Verify operations with:

Zero matrices
Identity matrices
Large sparse matrices
Edge cases



Rubric Compliance
Uniqueness (10 points)

Custom implementation without external libraries
Original code structure
Individual problem-solving approach

Correctness (80 points)

Accurate matrix operations
Proper file handling
Comprehensive error handling
Correct sparse matrix representation

Efficiency (10 points)

Optimized memory usage
Efficient algorithms
Handles large matrices effectively

Contributing Guidelines

Fork the repository
Create a feature branch
Follow the assignment guidelines
Submit a pull request
Ensure all tests pass

Author
TonnyleeM
