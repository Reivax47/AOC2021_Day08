import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

class entry(ligne: String) {

    val separation = ligne.split('|')
    val signal_pattern = separation[0].trim(' ').split(' ')
    val output = separation[1].trim(' ').split(' ')

    fun question1(): Int {

        var reponse = 0
        val liste = arrayOf(1, 4, 3, 7, 2)
        output.forEach {
            if (liste.contains(it.length)) {
                reponse++
            }
        }
        return reponse
    }

    fun question2(): Int {
        var reponse = 0

        val un = this.signal_pattern.find { it.length == 2 }.toString()
        val quatre = this.signal_pattern.find { it.length == 4 }.toString()
        val sept = this.signal_pattern.find { it.length == 3 }.toString()
        val huit = this.signal_pattern.find { it.length == 7 }.toString()
        val deux = this.signal_pattern.find { it.length == 5 && how_many_segment(it, quatre) == 2 }.toString()
        val trois = this.signal_pattern.find { it.length == 5 && how_many_segment(it, deux) == 4 }.toString()
        val cinq = this.signal_pattern.find { it.length == 5 && how_many_segment(it, deux) == 3 }.toString()
        val zero = this.signal_pattern.find { it.length == 6 && how_many_segment(it, cinq) == 4 }.toString()
        val neuf =
            this.signal_pattern.find { it.length == 6 && it != zero && how_many_segment(it, trois) == 5 }.toString()
        val six =
            this.signal_pattern.find { it.length == 6 && it != zero && how_many_segment(it, trois) == 4 }.toString()

        val sipher = listOf<String>(zero, un, deux, trois, quatre, cinq, six, sept, huit, neuf)
        var rep_string = ""

        output.forEach { it_ouput ->
            sipher.forEachIndexed { index, s ->
                if (how_many_segment(it_ouput, s) == it_ouput.length && it_ouput.length == s.length) {
                    rep_string += index.toString()
                }
            }
        }
        reponse = rep_string.toInt()
        return reponse
    }

    fun how_many_segment(source: String, cible: String): Int {
        var reponse = 0
        for (i in 0 until source.length) {
            for (j in 0 until cible.length) {
                if (source[i] == cible[j]) {
                    reponse++
                }
            }
        }
        return reponse
    }
}