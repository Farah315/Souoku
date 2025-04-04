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
// do it like a <T
fun is_Valid(board: List<List<String>>): Boolean {
    for (i in 0 until 9) {
        val rowSet = mutableSetOf<String>()
        val columnSet = mutableSetOf<String>()
        val boxSet = mutableSetOf<String>()

        for (j in 0 until 9) {
            val rowValue = board[i][j]
            if (rowValue != "-" && rowValue in rowSet)
                return false
            if (rowValue != "-") rowSet.add(rowValue)

            val columnValue = board[j][i]
            if (columnValue != "-" && columnValue in columnSet)
                return false
            if (columnValue != "-") columnSet.add(columnValue)

            val boxRow = 3 * (i / 3) + j / 3
            val boxCol = 3 * (i % 3) + j % 3
            val boxValue = board[boxRow][boxCol]
            if (boxValue != "-" && boxValue in boxSet)
                return false
            if (boxValue != "-") boxSet.add(boxValue)

            if (rowValue != "-" && (rowValue.toIntOrNull() == null || rowValue.toInt() < 1 || rowValue.toInt() > 9))
                return false
        }
    }
    return true
}


/*

 تكرار على كل عناصر الصف أو العمود
for (j in 0 until 9) {
     احصل على قيمة الخلية الحالية في الصف
    val rowValue = board[i][j]

     تحقق إذا كانت القيمة ليست فارغة ومتكررة في الصف
    if (rowValue != "-" && rowValue in rowSet) {
         إذا كانت متكررة، أرجع خطأ
        return false
    }

     إذا كانت القيمة ليست فارغة، أضفها إلى مجموعة الصف
    if (rowValue != "-") rowSet.add(rowValue)

    // احصل على قيمة الخلية الحالية في العمود
    val columnValue = board[j][i]

     تحقق إذا كانت القيمة ليست فارغة ومتكررة في العمود
    if (columnValue != "-" && columnValue in columnSet) {
        // إذا كانت متكررة، أرجع خطأ
        return false
    }

     إذا كانت القيمة ليست فارغة، أضفها إلى مجموعة العمود
    if (columnValue != "-") columnSet.add(columnValue)

     احسب موقع المربع الذي يحتوي على الخلية الحالية
    val boxRow = 3 * (i / 3) + j / 3
    val boxCol = 3 * (i % 3) + j % 3

     احصل على قيمة الخلية في المربع
    val boxValue = board[boxRow][boxCol]

     تحقق إذا كانت القيمة ليست فارغة ومتكررة في المربع
    if (boxValue != "-" && boxValue in boxSet) {
         إذا كانت متكررة، أرجع خطأ
        return false
    }

     إذا كانت القيمة ليست فارغة، أضفها إلى مجموعة المربع
    if (boxValue != "-") boxSet.add(boxValue)

    تحقق من صحة القيمة الرقمية
    if (rowValue != "-" && (rowValue.toIntOrNull() == null || rowValue.toInt()  9)) {
         إذا كانت القيمة غير صحيحة، أرجع خطأ
        return false
    }
}

 */