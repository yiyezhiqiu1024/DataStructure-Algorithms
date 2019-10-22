//
//  Times.h
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN
@interface Times : NSObject

+ (void)test:(NSString *)title taskBlock:(void (^)(void))block;
@end
  
NS_ASSUME_NONNULL_END
