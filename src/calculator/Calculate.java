package calculator;

import java.util.Stack;

public class Calculate {
	Stack<Integer> numberStack = new Stack<Integer>();
	Stack<String> operandStack = new Stack<String>();
	Stack<String> fomulaStack = new Stack<String>(); 
	public Calculate(String fomula){
		int ans = 0;
		String[] items = FomulaToReversePolish(fomula);
		ans = DoCalculate(items);
		System.out.println("total ans is " + fomulaStack.pop());
	}
	//入力式の答えを計算
	private int DoCalculate(String[] items) {
		// TODO 自動生成されたメソッド・スタブ
		for(int i=0; i < items.length;i++){
			int n1,n2,numbertoStack=0;
			if(IsNumber(items[i])){
				fomulaStack.push(items[i]);
			}else{
					n1 = Integer.parseInt(fomulaStack.pop());
					n2 = Integer.parseInt(fomulaStack.pop());
					if(items[i].equals("+")){
						numbertoStack = plus(n1,n2);
					}else if(items[i].equals("-")){
						numbertoStack = minus(n1,n2);
					}else if(items[i].equals("*")){
						numbertoStack = time(n1,n2);
					}else if(items[i].equals("/")){
						numbertoStack = devide(n1,n2);
					}
					fomulaStack.push(Integer.toString(numbertoStack));
				}
		}
			
		return 0;
	}
	//入力文字式を項に分割し逆ポーランド記法に変換
	private String[] FomulaToReversePolish(String fomula) {
		String[] fomulaItems = fomula.split(" ");
		//逆ポーランド記法へ
		
		return fomulaItems;
	}

	private boolean IsNumber(String item){			
		try{
			Integer.parseInt(item);
		}catch (NumberFormatException e){
			return false;
		}
		return true;		
	}
	public static int plus(int n1, int n2){
		return n1 + n2;
	}
	public static int minus(int n1, int n2){
		return n1 - n2;
	}
	public static int time(int n1, int n2){
		return n1 * n2;
	}
	public static int devide(int n1, int n2){
		return n1 / n2;
	}
}
