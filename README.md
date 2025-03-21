# Left Pad Numbers

## Overview

This project provides a Java implementation to left-pad numbers found in a given string to a specified length using
zeros. 


## How to Run the Solution

### Prerequisites

- Maven installed
- The project is using java 21. It should work with java 8 or higher(need to change the pom.xml to match that)

### Steps to Run

1. Clone the repository or copy the source code.
2. Navigate to the project directory.
3. Compile and run the program using the following Maven commands:
   ```sh
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.github.sebing.padding.LeftNumberPadder"
   ```
4. To run the tests, execute:
   ```sh
   mvn test
   ```

## Usage

   ```java
    new com.github.sebing.padding.LeftNumberPadder("James Bond 7",3).padNumbers();
   ```

## Time and Space Complexity Analysis
###   **Time Complexity:**

#### Key operations:
- The solution iterates over the `input` string **once**, processing each character in sequence.
- For each digit sequence (number), it:
   - Builds a `StringBuilder` for the **integer part** (`O(k)` where `k` is the length of the number).
   - Optionally builds another `StringBuilder` for the **fractional part** if it's a decimal (`O(m)` where `m` is the length of the fractional part).
   - Pads the **integer part** using `String.format()` (constant time for small numbers; effectively `O(1)` for primitive integer sizes).
- All other characters are processed in constant time `O(1)` per character.

#### Total work done:
- Every character in the `input` string is visited exactly **once**.
- The `StringBuilder` and `String.format()` operations per number are small relative to `n` (the input length).

  Therefore, the **time complexity** is:
```
O(n)
```
Where `n` is the length of the input string.

---

###   **Space Complexity:**

#### Key allocations:
- A `StringBuilder` (`result`) that stores the entire processed output → `O(n)`.
- Temporary `StringBuilder` objects for numbers and fractions (reused during iteration).
- No recursion or additional data structures.

  So the **space complexity** is:
```
O(n)
```
Because:
- The output is stored in memory.
- The temporary buffers are small and proportional to the size of numbers, not the whole input.

---

###   External Libraries Impact:
- **`StringBuilder`** is a standard Java utility. Its append operations are amortized `O(1)`.
- **`String.format()`** is used for padding the number, but since we're dealing with **integers**, this operation is efficient and considered **constant time** (`O(1)`) relative to the number of digits (which is typically bounded).

---

###   Conclusion
```
Time Complexity:  O(n)
Space Complexity: O(n)
```

Where `n` is the length of the input string.



## Improvements

- Add container configurations
- Use Project Lombok to remove boilerplate code

## Testing

The project includes JUnit-5 tests located in the `src/test/java` directory. The test cases cover:

- Single-digit padding
- Numbers that already meet required length
- Mixed content with numbers
- Leading zeros
- Multiple numbers in sequence
- Numbers at the start and end of the string
- Strings without numbers
- Large numbers
- Single character strings
- Invalid cases
- Whole number tests

To run the tests:

```sh
mvn test
```

## License

This project is open-source and free to use.

