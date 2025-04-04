fun main() {
    val board = listOf(
        listOf("5", "3", "-", "-", "7", "-", "-", "-", "-"),
        listOf("6", "-", "-", "1", "9", "5", "-", "-", "-"),
        listOf("-", "9", "8", "-", "-", "-", "-", "6", "-"),
        listOf("8", "-", "-", "-", "6", "-", "-", "-", "3"),
        listOf("4", "-", "-", "8", "-", "3", "-", "-", "1"),
        listOf("7", "-", "-", "-", "2", "-", "-", "-", "6"),
        listOf("-", "6", "-", "-", "-", "-", "2", "8", "-"),
        listOf("-", "-", "-", "4", "1", "9", "-", "-", "5"),
        listOf("-", "-", "-", "-", "8", "-", "-", "7", "9")
    )

    println("Is valid board? ${is_Valid(board)}")
}
fun <T> is_Valid(board: List<List<T>>): Boolean {
    val size = board.size
    val boxSize = kotlin.math.sqrt(size.toDouble()).toInt()

    for (i in 0 until size) {
        val rowSet = mutableSetOf<T>()
        val columnSet = mutableSetOf<T>()
        val boxSet = mutableSetOf<T>()

        for (j in 0 until size) {
            val rowValue = board[i][j]

            if (rowValue != "-" && rowValue in rowSet) return false
            if (rowValue != "-") rowSet.add(rowValue)

            val columnValue = board[j][i]
            if (columnValue != "-" && columnValue in columnSet) return false
            if (columnValue != "-") columnSet.add(columnValue)

            val boxRow = boxSize * (i / boxSize) + j / boxSize
            val boxCol = boxSize * (i % boxSize) + j % boxSize
            val boxValue = board[boxRow][boxCol]
            if (boxValue != "-" && boxValue in boxSet) return false
            if (boxValue != "-") boxSet.add(boxValue)

            if (rowValue != "-" && rowValue is String) {
                val num = rowValue.toIntOrNull()

                if (num == null || num < 1 || num > 16) return false
            }

            if (rowValue != "-" && rowValue is String) {
                if (rowValue.length > 1 || !rowValue.matches("[0-9A-F]+".toRegex())) return false
            }
        }
    }

    return true
}
