fun main() {
    // Test case: Valid empty board
    check(
        "Valid Board: The board is empty Then it will return a true value.",
        result = is_Valid(
            listOf(
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-")
            )
        ),
        correctResult = true
    )

    // Test case: Valid board with only one number
    check(
        "Valid Board: Only one item is present, so the board is valid",
        result = is_Valid(
            listOf(
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "7", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-")
            )
        ),
        correctResult = true
    )

    // Test case: Invalid board with an invalid character '@'
    check(
        "Invalid Board: Invalid character (@) found",
        result = is_Valid(
            listOf(
                listOf("5", "3", "-", "9", "7", "-", "-", "-", "-"),
                listOf("6", "-", "9", "1", "9", "5", "-", "-", "-"),
                listOf("-", "@", "8", "-", "-", "-", "-", "6", "-"), // Invalid '@'
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )

    // Test case: Invalid board with an invalid character 'U'
    check(
        "Invalid Board: Contains an invalid character 'U' – expected: false",
        result = is_Valid(
            listOf(
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "7"),
                listOf("-", "7", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "U", "-", "-"),  // Invalid 'U'
                listOf("-", "2", "-", "5", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "6", "-", "-", "-", "9", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-")
            )
        ),
        correctResult = false
    )

    // Test case: Invalid board with an invalid number '-9'
    check(
        "Invalid Board: Contains an invalid number '-9' – expected: false",
        result = is_Valid(
            listOf(
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "7"),
                listOf("-", "7", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-9", "-", "-"),  // Invalid '-9'
                listOf("-", "2", "-", "5", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "6", "-", "-", "-", "9", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-"),
                listOf("-", "-", "-", "-", "-", "-", "-", "-", "-")
            )
        ),
        correctResult = false
    )

    // Test case: Invalid board with a duplicate in a row
    check(
        "Invalid Board: Duplicate found in row",
        result = is_Valid(
            listOf(
                listOf("5", "3", "5", "-", "7", "-", "-", "-", "-"), // Duplicate '5' in row
                listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
                listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
                listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
                listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
                listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
                listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
                listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
                listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
            )
        ),
        correctResult = false
    )
    // Continue testing for other cases as needed
}

fun check(value: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $value")
    } else {
        println("Failed - $value")
    }
}
