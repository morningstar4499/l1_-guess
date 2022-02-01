package com.morningstar.l1_guess

import kotlin.random.Random

class SecretNumber {

    val secret  = Random(100).nextInt(10)+1
    var count =0
    fun validate(number:Int):Int {
        count++
        return number - secret
    }
}

fun main(){

    val secretnumber = SecretNumber()
    println(secretnumber.secret)
    //println("${secretnumber.validate(2)},count:${secretnumber.count}")
    println("${secretnumber.validate(2)} count: + ${secretnumber.count}")

}