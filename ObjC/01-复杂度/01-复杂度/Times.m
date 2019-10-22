//
//  Times.m
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

#import "Times.h"

@implementation Times

+ (void)test:(NSString *)title taskBlock:(void (^)(void))block {
    NSLog(@"【%@】", title);
    NSDateFormatter *fmt = [[NSDateFormatter alloc] init];
    fmt.dateFormat = @"HH:mm:ss.SSSS";
    NSDate *beginDate = [[NSDate alloc] init];
    NSLog(@"开始：%@", [fmt stringFromDate:beginDate]);
    NSTimeInterval begin = [beginDate timeIntervalSince1970];
    block();
    NSDate *endDate = [[NSDate alloc] init];
    NSLog(@"结束：%@", [fmt stringFromDate:endDate]);
    NSTimeInterval end = [endDate timeIntervalSince1970];
    NSString *delta = [NSString stringWithFormat:@"%.6f", (end - begin)];
    NSLog(@"耗时：%@", delta);
    NSLog(@"---------------------------------------------------");
}
@end
