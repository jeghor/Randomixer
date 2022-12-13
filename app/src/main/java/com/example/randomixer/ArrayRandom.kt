package com.example.randomixer

import kotlin.random.Random

object ArrayRandom {
    @JvmStatic
    fun randomFieldIntArray(amountElements: Int): IntArray{
        val randomArray = IntArray(amountElements)
        var counter = 0
        while (counter< randomArray.size){
            if (counter==0){
                randomArray[counter] = Random.nextInt(500)
                counter++
            }
            if (counter>0 && randomArray[counter]!=randomArray[counter-1]){
                randomArray[counter] = Random.nextInt(500)
                counter++
            }
        }
        return randomArray
    }
    @JvmStatic
    fun randomNumbOfElem(): Int {
        var elCount = Random.nextInt(26)
        while(elCount%2!= 0){
            elCount = Random.nextInt(26)
        }
        return elCount
    }
}