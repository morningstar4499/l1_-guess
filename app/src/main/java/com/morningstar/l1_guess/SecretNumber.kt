package com.morningstar.l1_guess

import kotlin.random.Random

class SecretNumber {

    var secret  = Random.nextInt(10)+1
    var count =0
    fun validate(number:Int):Int {
        count++
        return number - secret
    }
    fun Reset(){

        secret  = Random.nextInt(10)+1
        count =0
    }
}

fun main(){

    val secretnumber = SecretNumber()
    println(secretnumber.secret)
    //println("${secretnumber.validate(2)},count:${secretnumber.count}")
    println("${secretnumber.validate(2)} count: + ${secretnumber.count}")

}
