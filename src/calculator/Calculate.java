package calculator;

import java.util.Stack;

public class Calculate {
	int ans = 0;
	Stack<String> fomulaStack = new Stack<String>(); 
	public Calculate(String fomula){
		String[] items = FomulaToReversePolish(fomula);
		ans = DoCalculate(items);
		System.out.println("ans is " + ans);
	}
	public int GetAns(){
		return ans;
	}
	//���͎��̓������v�Z
	private int DoCalculate(String[] items) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		//System.out.println("items have " + items.length);
		for(int i=0; items[i] != null;i++){
			int n1,n2,numbertoStack=0;
			if(IsNumber(items[i])){
				fomulaStack.push(items[i]);
				//System.out.println(items[i] + " is pushed3!");
			}else{
					n1 = Integer.parseInt(fomulaStack.pop());
					//System.out.println("n1 is " + n1);
					n2 = Integer.parseInt(fomulaStack.pop());
					//System.out.println("n2 is " + n2);
					if(items[i].equals("+")){
						numbertoStack = plus(n2,n1);
					}else if(items[i].equals("-")){
						numbertoStack = minus(n2,n1);
					}else if(items[i].equals("*")){
						numbertoStack = time(n2,n1);
					}else if(items[i].equals("/")){
						numbertoStack = devide(n2,n1);
					}
					fomulaStack.push(Integer.toString(numbertoStack));
				}
		}
			
		return Integer.parseInt(fomulaStack.pop());
	}
	//���͕����������ɕ������t�|�[�����h�L�@�ɕϊ�
	private String[] FomulaToReversePolish(String fomula) {
		Stack<String> tmpStack = new Stack<String>();
		String[] returnItems = new String[200];
		Stack<Integer> priorityStack = new Stack<Integer>();
		int count = 0;
		int this_priority;
		int privious_priority;
		boolean tmpStack_popped = false;
		String[] fomulaItems = fomula.split(" ");
		//�t�|�[�����h�L�@��
		for(int i=0; i<fomulaItems.length;i++){
			if(IsNumber(fomulaItems[i])){
				returnItems[count] = fomulaItems[i];
				++count;
			}else{
				//�D��x�̎擾
				this_priority = GetPriority(fomulaItems[i]);
				if(tmpStack.isEmpty()){
					tmpStack.push(fomulaItems[i]);
					priorityStack.push(this_priority);
				}else{
					//�X�^�b�N��ԏ�̉��Z�q�̗D��x���擾
					privious_priority = priorityStack.pop();
					//�X�^�b�N�擪�̗D��x��肪�Ⴍ�Ȃ�܂ŏ����o��
					while(this_priority <= privious_priority){
						tmpStack_popped = true;
						returnItems[count] = tmpStack.pop();
						//System.out.println(returnItems[count] + " is pushed!");
						count++;
						if(priorityStack.isEmpty()){
							privious_priority = 0;
						}else{
							privious_priority = priorityStack.pop();
						}
					}
					if(tmpStack_popped == false){
						priorityStack.push(privious_priority);
					}
					tmpStack_popped = false;
					tmpStack.push(fomulaItems[i]);
					priorityStack.push(this_priority);
				}
			}
			
		}
		while(!tmpStack.isEmpty()){
			returnItems[count] = tmpStack.pop();
			//System.out.println(returnItems[count] + " is pushed!2");
			count++;
		}

//		for(int i=0;i<count; i++){
//			System.out.println(returnItems[i]);
//		}
		return returnItems;
	}

	private int GetPriority(String operand) {
		if(operand.equals("+")||operand.equals("-")){
			return 1;
		}else{
			return 2;
		}
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
