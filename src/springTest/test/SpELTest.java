package springTest.test;

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
	}
}
