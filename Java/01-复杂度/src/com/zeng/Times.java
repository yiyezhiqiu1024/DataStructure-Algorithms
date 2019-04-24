package com.zeng;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间工具
 * @author CoderSLZeng
 *
 */
public class Times {

	/**
	 * 时间格式
	 */
	private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSSS");
	
	
	/**
	 * 任务接口
	 * @author CoderSLZeng
	 *
	 */
	public interface Task {
		
		/**
		 * 开始执行任务
		 */
		void execute();
	}
	
	/**
	 * 检查任务的执行时间
	 * @param title 任务名
	 * @param task	执行任务
	 */
	public static void test(String title, Task task) {
		if (task == null) return;
		
		title = (title == null) ? "" : ("【" + title + "】");
		System.out.println(title);
		System.out.println("开始" + fmt.format(new Date()));
		long begin = System.currentTimeMillis();
		task.execute();
		long end = System.currentTimeMillis();
		System.out.println("结束" + fmt.format(new Date()));
		double delta = (end - begin) / 1000.0;
		System.out.println("耗时" + delta + "秒");
		System.out.println("----------------------------------------");	
	}
}
