//
//  Fibonacci.h
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Fibonacci : NSObject
/// 递归思路
/// - Parameter n: 斐波那契数
+ (long)fib1:(int)n;

/// 非递归思路1
/// - Parameter n: 斐波那契数
+ (long)fib2:(int)n;
+ (long)fib3:(int)n;

/// 斐波那契的线性代数解法 - 特征方程
/// - Parameter n: 斐波那契数
+ (long)fib4:(int)n;
@end

NS_ASSUME_NONNULL_END
