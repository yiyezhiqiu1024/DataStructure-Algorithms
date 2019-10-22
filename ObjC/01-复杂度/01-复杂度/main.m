//
//  main.m
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Times.h"
#import "Fibonacci.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        
        [Times test:@"fib4" taskBlock:^{
            long result = [Fibonacci fib4:64];
            NSLog(@"%ld", result);
        }];
        
        [Times test:@"fib3" taskBlock:^{
            long result = [Fibonacci fib3:64];
            NSLog(@"%ld", result);
        }];
        
        [Times test:@"fib2" taskBlock:^{
            long result = [Fibonacci fib2:64];
            NSLog(@"%ld", result);
        }];
        
        [Times test:@"fib1" taskBlock:^{
            long result = [Fibonacci fib1:4];
            NSLog(@"%ld", result);
        }];
        
    }
    return 0;
}
