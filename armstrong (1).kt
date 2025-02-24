import java.util.*;
import kotlin.math.pow

fun main() {
    println("Enter a number to check if it is an Armstrong number:")
    var reader = Scanner(System.`in`)
    val number = reader.nextInt()

    if (isArmstrong(number)) {
        println("$number is an Armstrong number.")
    } else {
        println("$number is not an Armstrong number.")
    }
}

fun isArmstrong(num: Int): Boolean {
    val digits = num.toString().length
    var sum = 0
    var temp = num

    while (temp > 0) {
        val digit = temp % 10
        sum += digit.toDouble().pow(digits).toInt()
        temp /= 10
    }

    return sum == num
}