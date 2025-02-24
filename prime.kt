import java.util.*;
fun main() {
    println("Enter a number to check if it is prime:")
    val readeer=Scanner(System.`in`)
    val number = readeer.nextInt()

    val isPrime = isPrime(number)
    if (isPrime) {
        println("$number is a prime number.")
    } else {
        println("$number is not a prime number.")
    }
}

fun isPrime(num: Int): Boolean {
    if (num < 2) return false // Numbers less than 2 are not prime
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false // Found a factor, not prime
    }
    return true // No factors found, it's prime
}