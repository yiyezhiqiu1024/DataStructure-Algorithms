//
//  Fibonacci.m
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

#import "Fibonacci.h"

@implementation Fibonacci
+ (long)fib1:(int)n {
    if (n <= 1) return n;
    return [self fib1:n - 1] + [self fib1:n - 2];
}

+ (long)fib2:(int)n {
    if (n <= 1) return n;
    long first = 0, second = 1;
    while (n-- > 1) {
        second += first;
        first = second - first;
    }
    return second;
}

+ (long)fib3:(int)n {
    if (n <= 1) return n;
    long first = 0, second = 1;
    for (int i = 0; i < n - 1; i++) {
        second += first;
        first = second - first;
    }
    return second;
}

+ (long)fib4:(int)n {
    double c = sqrt(5);
    return (long)((pow((1 + c) / 2, (double)n) - pow((1 - c) / 2, (double)n)) / c);
}// -2147483648


@end
