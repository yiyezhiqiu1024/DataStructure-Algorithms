//
//  main.swift
//  02-动态数组
//
//  Created by Franklin on 2019/10/22.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

import Foundation

var arr = ArrayList<Int>()
for i in 0...9 {
    arr.add(i)
}
print(arr)
assert(arr.size == 10)
assert(arr.get(9) == 9)
assert(arr.remove(9) == 9)
print(arr)

// 扩容测试
arr.add(9)
arr.add(10)
assert(arr.size == 11)
print(arr)

assert(arr.set(10, element: -1) == 10)
print(arr)

assert(arr.contains(-1))

arr.add(0, -2)
assert(arr.indexOf(-2) == 0)
print(arr)


arr.clear()
assert(arr.isEmpty)
print(arr)

