package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author SL Zeng
 *
 */
public class _150_逆波兰表达式求值 {

	public static void main(String[] args) {
//		String[] tokens = {"2", "1", "+", "3", "*"};
//		String[] tokens = {"4", "13", "5", "/", "+"};
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		int result = evalRPN(tokens);
		System.out.println(result);
	}
	
	public static int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<>();
		
		for (String token : tokens) {
			switch (token) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;
			case "/":
				Integer right = stack.pop();
				stack.push(stack.pop() / right);
				break;
			default:  
				stack.push(Integer.parseInt(token));
				break;
			}
		}
		
		return stack.pop();
	}
	
	public static int evalRPN2(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		
		for (String token : tokens) {
			stack.push(isOperator(token) 
					? calculate(stack.pop(), stack.pop(), token)
					: Integer.parseInt(token));
		}
		
		return stack.pop();
	}
	
	private static int calculate(int right, int left, String operator) {
		switch (operator) {
		case "+": return left + right;
		case "-": return left - right;
		case "*": return left * right;
		default: return  left / right;
		}
	}

	private static boolean isOperator(String token) {
		return "+-*/".contains(token);
	}
	

}
