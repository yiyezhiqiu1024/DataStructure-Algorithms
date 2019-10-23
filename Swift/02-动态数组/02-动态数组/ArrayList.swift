//
//  ArrayList.swift
//  02-动态数组
//
//  Created by Franklin on 2019/10/22.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

enum SomeError: Error {
    case illegalArg(String)
    case outOfBounds(Int, Int)
    case outOfMemory
}

struct ArrayList<E: Comparable> {
    // MARK: - 私有属性
    /// 默认容量
    private var DEFAULT_CAPACITY: Int { 10 }
    /// 元素无法找到
    private var ELEMENT_NOT_FOUND: Int { -1 }
    
    // MARK: - 公共接口
    /// 是否为空
    var isEmpty: Bool { size == 0 }
    
    private var elements: [E?] = [E?]()
    /// 元素的数量
    private(set) var size: Int = 0
    
    init() {
        for _ in 0..<DEFAULT_CAPACITY {
            elements.append(nil)
        }
    }
    
    init(capacity: Int) {
        let capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity
        for _ in 0..<capacity {
            elements.append(nil)
        }
    }
    
    /// 是否包含某个元素
    /// - Parameter element: 元素
    func contains(_ element: E?) -> Bool {
        return indexOf(element) == ELEMENT_NOT_FOUND ? false : true
    }
    
    /// 添加元素到最后面
    /// - Parameter element: 元素
    mutating func add(_ element: E?)  {
        add(size, element)
    }
    
    /// 往index位置添加元素
    /// - Parameter index: 下标位置
    /// - Parameter element: 添加的元素
    mutating func add(_ index: Int, _ element: E?)  {
        if index < 0 || index > size { return }
        
        ensureCapacity(size + 1)
        
        var i = size
        while i > index {
            elements[i] = elements[i - 1]
            i -= 1
        }
        
        elements[index] = element
        size += 1
        
        
    }
    
    /// 返回index位置对应的元素
    /// - Parameter index: 下标位置
    @discardableResult func get(_ index: Int) -> E? {
        if index < 0 || index >= size { return nil }
        return elements[index];
    }
    
    /// 设置index位置的元素
    /// - Parameter index: 下标位置
    @discardableResult mutating func set(_ index: Int, element: E?) -> E? {
        if index < 0 || index >= size { return nil }
        let old = elements[index]
        elements[index] = element
        return old
    }
    
    /// 删除index位置对应的元素
    /// - Parameter index: 下标位置
    /// - Returns: 被删除的元素
    @discardableResult mutating func remove(_ index: Int) -> E? {
        if index < 0 || index >= size { return nil }
        
        let old = elements[index]
        for i in (index + 1)..<size {
            elements[i - 1] = elements[i]
        }
        size -= 1
        elements[size] = nil
        return old
    }
    
    /// 查看元素的位置
    /// - Parameter element: 元素
    /// - Returns: 元素所在位置
    @discardableResult func indexOf(_ element: E?) -> Int {
        if element == nil {
            for index in 0..<size {
                if elements[index] == nil { return index }
            }
        } else {
            for index in 0..<size {
                if element! == elements[index] { return index }
            }
        }
        return ELEMENT_NOT_FOUND
    }
    
    /// 清除所有元素
    mutating func clear() {
        for i in 0..<size {
            elements[i] = nil
        }
        size = 0
    }
    
    // MARK: - 私有接口
    private func outOfBounds(_ index: Int) throws {
        throw SomeError.outOfBounds(index, size)
    }
    
    private func rangeCheckForAdd(_ index: Int) throws {
        if index < 0 || index > size {
            throw SomeError.outOfBounds(index, size)
        }
    }
    
    /// 扩容
    /// - Parameter capacity: 当前容量
    private mutating func ensureCapacity(_ capacity: Int) {
        let oldCapacity = elements.count
        if oldCapacity >= capacity { return }
        
        // 新容量为旧容量的1.5倍
        let newCapacity = oldCapacity + (oldCapacity >> 1)
        var newElements = [E?]()
        for _ in 0..<newCapacity {
            newElements.append(nil)
        }
        
        for i in 0..<size {
            newElements[i] = elements[i]
        }
        
        elements = newElements
        print("\(oldCapacity) 扩容为 \(newCapacity)")
    }
}
