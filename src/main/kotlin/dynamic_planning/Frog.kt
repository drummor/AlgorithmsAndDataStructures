package dynamic_planning

import kotlin.contracts.contract

/*
每次跳或者2
 跳到第target有多少种

 */

fun countJumpWays(target: Int): Int {

    if (target == 1) {
        return 1
    }
    if (target == 2) {
        return 2
    }

    return countJumpWays(target - 1) + countJumpWays(target - 2)
}



fun main() {
    println(countJumpWays(4))
}