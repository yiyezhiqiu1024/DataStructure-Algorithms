//
//  Times.swift
//  01-复杂度
//
//  Created by CoderSLZeng on 2019/10/21.
//  Copyright © 2019 Franklin Tsang. All rights reserved.
//

import Foundation

struct Times {
          
    static func test(_ title:  String, _ task: () -> Void) {
            
        print("【" + title + "】")
        let fmt = DateFormatter()
        fmt.dateFormat = "HH:mm:ss.SSSS"
        let dateStr = fmt.string(from: Date())
        print("开始：" + dateStr)
        let begin = Date().timeIntervalSince1970
        task()
        let end = Date().timeIntervalSince1970
        let endStr = fmt.string(from: Date())
        print("结束：" + endStr)
        let delta = String(format: "%.6f", (end - begin))
        print("耗时：" + delta )
        print("----------------------------------------")        
    }

    
}
