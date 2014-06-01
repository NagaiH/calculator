package calculator;

import java.util.Stack;

public class Calculate {
	Stack<Integer> numberStack = new Stack<Integer>();
	Stack<String> operandStack = new Stack<String>();
	public Calculate(String fomula){
		int ans = 0;
		FomulaToStack(fomula);
		ans = DoCalculate();
		System.out.println("total ans is " + numberStack.pop());
	}
	//�X�^�b�N�ɐς܂ꂽ�v�f��p���ē��͎��̓������v�Z
	private int DoCalculate() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		while(!operandStack.isEmpty()){
			int n1 = numberStack.pop();
			int n2 = numberStack.pop();
			int numbertoStack = 0;
			String operand = operandStack.pop();
			
			System.out.println("n1 is "+ n1 + " n2 is " + n2 + " ope is " + operand);
			
			if(operand.equals("+")){
				numbertoStack = plus(n1,n2);
			}else if(operand.equals("-")){
				numbertoStack = minus(n1,n2);
			}else if(operand.equals("*")){
				numbertoStack = time(n1,n2);
			}else if(operand.equals("/")){
				numbertoStack = devide(n1,n2);
			}
			
			numberStack.push(numbertoStack);
			System.out.println("this fomula ans is " + numbertoStack + " and pushed!!");
		}
		return 0;
	}
	//���͎����t�|�[�����h�L�@�ɕ������e�X�^�b�N�Ƀv�b�V��
	private void FomulaToStack(String fomula) {
		String[] fomulaItems = fomula.split(" ");
		String[] RPfomulaItems = ToReversePolish(fomulaItems);
		//�X�^�b�N�Ƀv�b�V��
		for(int i=0; i<RPfomulaItems.length;i++){
			try{
				numberStack.push(Integer.parseInt(RPfomulaItems[i]));
				System.out.println(RPfomulaItems[i] + " is Number and pushed!");
			}catch (NumberFormatException e){
				operandStack.push(RPfomulaItems[i]);
				System.out.println(RPfomulaItems[i] + " is operand and pushed!");
			}
		}
	}

	private String[] ToReversePolish(String[] fomulaItems) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return fomulaItems;
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
