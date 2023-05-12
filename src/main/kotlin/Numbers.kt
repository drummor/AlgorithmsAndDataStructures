class Numbers {

    fun String2Int(numberStr: String): Int {
        var result = 0
        if (numberStr.isEmpty()) {
            return result
        }

        var idx = 0;
        while (idx < numberStr.length) {
            val char = numberStr.get(idx);
            result = result * 10 + (char - '0')
            idx++
        }

        return result;

    }
}