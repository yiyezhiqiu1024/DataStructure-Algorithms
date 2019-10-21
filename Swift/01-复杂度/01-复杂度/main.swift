//
//  main.swift
//  01-复杂度
//
//  Created by Franklin on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

// 解题
// 509. 斐波那契数
// https://leetcode-cn.com/problems/fibonacci-number/

import Foundation

/// 递归思路
/// - Parameter n: 斐波那契数
func fib1(_ n: Int) -> Int {
    if n <= 1 { return n }
    return fib1(n - 1) + fib1(n - 2)
} // O(2^n)

/// 非递归思路1
/// - Parameter n: 斐波那契数
func fib2(_ n: Int) -> Int {
    if n <= 1 { return n }
    var first = 0, second = 1
    var copyN = n
    while copyN > 1 {
        second += first
        first = second - first 
        copyN -= 1
    }
    
    return second
} // O(n)

/// 非递归思路2
/// - Parameter n: 斐波那契数
func fib3(_ n: Int) -> Int {
    if n <= 1 { return n }
    
    var first = 0, second = 1
    for _ in 0..<(n-1) {
        second += first
        first = second - first
    }
    
    return second
}


/// 斐波那契的线性代数解法 - 特征方程
/// - Parameter n: 斐波那契数列
func fib4(_ n: Int) -> Int {
    let c = sqrt(5)
    return Int((pow((1 + c) / 2, Double(n)) - pow((1 - c) / 2, Double(n))) / c)
}

autoreleasepool {
    Times.test("fib4") {
        let result = fib4(64)
        print(result)
    }
    
    Times.test("fib3") {
        let result = fib3(64)
        print(result)
    }
    
    Times.test("fib2") {
        let result = fib2(64)
        print(result)
    }
    
    Times.test("fib1") {
        let result = fib1(64)
        print(result)
    }
}

