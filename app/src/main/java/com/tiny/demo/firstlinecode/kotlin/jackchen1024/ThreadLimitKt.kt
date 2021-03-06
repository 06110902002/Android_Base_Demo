package com.tiny.demo.firstlinecode.kotlin.jackchen1024

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Description: $desc$
 *
 * @Author wangjianzhou@qding.me
 * @Version $version$
 * @Date 2018/8/27 2:16 PM
 */

fun main(args: Array<String>) {
//    testThread()
    testCoroutine()
}

// 创建多个线程时会报错
fun testThread() {
    val jobs = List(100_1000) {
        Thread {
            Thread.sleep(1000L)
            println(".")
        }
    }

    jobs.forEach {
        it.start()
    }
    jobs.forEach {
        it.join()
    }
}

/**
 * 创建多个协程时就没这个问题了
 */
fun testCoroutine() = runBlocking {
    var jobs = List(100_1000) {
        GlobalScope.launch {
            delay(1000L)
            println(".")
        }
    }
    jobs.forEach {
        it.join()
    }
}