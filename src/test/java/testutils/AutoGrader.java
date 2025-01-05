package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

	// Test for Random Operations
	public boolean testRandomOperations(String filePath) throws IOException {
		System.out.println("Starting testRandomOperations with file: " + filePath);

		// Load participant's file
		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		// Parse the file using JavaParser
		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		// Flag to check for random-related operations
		boolean hasRandomOperations = false;

		// 1. Checking if any random-related methods (e.g., random, nextInt, nextDouble)
		// are used
		System.out.println("------ Checking Random Operations ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("random") || methodName.equals("nextInt") || methodName.equals("nextDouble")) {
				hasRandomOperations = true;
				System.out.println("✓ Found random operation: " + methodName);
			}
		}

		// Output the result for random operations
		if (hasRandomOperations) {
			System.out.println("✓ Random operations are present.");
		} else {
			System.out.println("✘ Missing random operations.");
		}

		// Test result
		System.out.println("Test result: " + hasRandomOperations);
		return hasRandomOperations;
	}
}
