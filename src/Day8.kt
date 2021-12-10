fun main() {
    fun part1(input: List<String>): Int {
        var liste_entry = mutableListOf<entry>()
        var response = 0
        input.forEach {
            liste_entry.add(entry(it))
        }

        liste_entry.forEach {
            response += it.question1()
        }
        return response
    }

    fun part2(input: List<String>): Int {
        var liste_entry = mutableListOf<entry>()
        var response = 0
        input.forEach {
            liste_entry.add(entry(it))
        }

        liste_entry.forEach {
            response += it.question2()
        }
        return response
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 61229)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
