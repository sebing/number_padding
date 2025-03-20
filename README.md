# Left Pad Numbers

## Overview

This project provides a Java implementation to left-pad numbers found in a given string to a specified length using
zeros. It includes two implementations:

- One using regular expressions (Regex)
- One without regular expressions

Unit tests are included to validate the correctness of both implementations.

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
   mvn exec:java -Dexec.mainClass="com.github.sebing.padding.NonRegexNumberPadder"
   mvn exec:java -Dexec.mainClass="com.github.sebing.padding.RegexNumberPadder"
   ```
4. To run the tests, execute:
   ```sh
   mvn test
   ```

## Usage

   ```java
    new com.github.sebing.padding.NonRegexNumberPadder("James Bond 7",3).

padNumbers();
    new com.github.sebing.padding.

RegexNumberPadder("James Bond 7",3).

padNumbers();
   ```

## Time and Space Complexity Analysis

### Implementation Without Regex

- **Time Complexity**: O(N) where N is the length of the input string. Each character is processed once.
- **Space Complexity**: O(N) for storing the output string.

### Implementation With Regex

- **Time Complexity**: O(N) on average, but can be higher due to regex processing.
- **Space Complexity**: O(N) for the output string and possible overhead due to regex pattern matching.

The implementation without regex is generally more efficient, especially for large inputs, as it avoids the overhead of
regex pattern matching.

## Improvements

- Use Project Lombok to remove boilerplate code
- Choice between Code Duplication vs Readability(Individual implementation of test `NonRegexNumberPadderTest` is much more readable than `ParameterizedTest` test `NumberPadderTest`)

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

To run the tests:

```sh
mvn test
```

## License

This project is open-source and free to use.

