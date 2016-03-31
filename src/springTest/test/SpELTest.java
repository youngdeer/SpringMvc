package springTest.test;



import java.util.Date;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELTest {

	public static void main(String[] args){
		ExpressionParser parser = new SpelExpressionParser();
		Expression espression = parser.parseExpression("('hello' + ' deer ').concat(#end)");
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("end", "lalalala~~~");
		System.out.println(espression.getValue(context));
		//java lang包类访问
		Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
		System.out.println(result1);
		//其他包类访问
		String espression2 = "T(springTest.beans.Hello)";
		Class<String> result2 = parser.parseExpression(espression2).getValue(Class.class);
		System.out.println(result2);
		//类静态字段访问
		int result3 = parser.parseExpression("T(springTest.beans.Hello).MAX").getValue(int.class);
		System.out.println(result3);
		//类静态方法调用
		int result4 = parser.parseExpression("T(Integer).parseInt(1)").getValue(int.class);
		System.out.println(result4);
		//类实例化
		String result5 = parser.parseExpression("new String('deer')").getValue(String.class);
		System.out.println(result5);
		Date result6 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
		System.out.println(result6);
		//instancfof表达式
		boolean result7 = parser.parseExpression("'deer' instanceof T(String)").getValue(boolean.class);
		System.out.println(result7);
	}
}
