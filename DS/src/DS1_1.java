import java.util.*;
public class DS1_1 {
	public static int Priority(char c) { //연산자 우선순위 정하기
		if(c=='(') 
			return 0;
		else if(c=='+'||c=='-')
			return 1;
		else
			return 2;
	}
    public static String PostFix(String s) { //후위표기법으로 스트링에 저장 
    	String postfix ="";
    	Stack<Character>ops = new Stack<>();
    	for(char c:s.toCharArray()) {
    		if('0'<=c&&c<='9') { //0~9가 들어오면 출력 int 형이 아니기 때문에 ''를 사용
    			postfix+=c;
    		}
    		else if(c=='(') {
    			ops.push(c);
    		}
    		else if(c==')') {
    			while(!ops.isEmpty()) {
    				char op = ops.pop();
    				if(op=='(') 
    					break;
    				postfix+=" " + op;
    			}
    		}
    		else {
    			while(!ops.isEmpty()&&Priority(ops.peek())>=Priority(c)) {
    				postfix+=" " + ops.pop();
    			}
    			ops.push(c);
    			postfix+=" "; //연산자를 만나면 띄어쓰기를 하여 10이상의 숫자를 대비하여 띄어쓰기를 하여 구분하기 위함
    		}
    	}
    	while(!ops.isEmpty()) {
    		postfix+=" " + ops.pop();
    	}
    	return postfix;
    } 
//    public static double calc(String s) {
//    	String[] a = s.split(" ", 0);
//    	double[] d = new double[a.length];
//    	String[] op = new String[a.length];
//    	double result = 0.0;
//    	for(int i = 0;i<a.length;i++) {
//    		System.out.print(a[i]+" ");
//    	}
//    	System.out.println();
//    	//System.out.print(a.length);
//    	int NumCount=0;
//    	int ChCount=0;
//    	
//    	for(int i = 0; i<a.length;i++) {
//    		if(a[i].equals("+")||a[i].equals("-") ||a[i].equals("*")||a[i].equals("/")) {
//    			switch(a[i]) {
//    			case "+": a[i]=a[i-2]+a[i-1];
//    			break;
//    			case "-": a[i]=a[i-2]-a[i-1];
//    			break;
//    			case "*": a[i]=a[i-2]*a[i-1];
//    			break;
//    			case "/": a[i]=a[i-2]/a[i-1];
//    			break;
//    			}
//    			result = d[i+1];
//    		}
//    	}
//    	
//    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//    	for(int i = 0;i<a.length;i++) {
//    		if(a[i].equals("+")||a[i].equals("-") ||a[i].equals("*")||a[i].equals("/")) {
//    				op[ChCount] = a[i];
//    				ChCount++;
//        	}
//        	else {
//        		d[NumCount] = Double.parseDouble(a[i]);
//        		NumCount++;
//        	}	
//    	}
//    	for(int i = 0;i<d.length;i++) {
//    		System.out.print(d[i]+" ");
//    	}
//    	for(int i = 0;i<op.length;i++) {
//    		System.out.print(op[i]+" ");
//    	}
//   
		
    	
//
//    	for(int i=0;i<op.length;i++) {
//    			if(op[i] == null) {
//    				break;
//    			}
//    			switch(op[i]) {
//    			case "+": d[i+1]=d[i]+d[i+1];
//    			break;
//    			case "-": d[i+1]=d[i]-d[i+1];
//    			break;
//    			case "*": d[i+1]=d[i]*d[i+1];
//    			break;
//    			case "/": d[i+1]=d[i]/d[i+1];
//    			break;
//    			}
//    			result = d[i+1];  		
//    	}
//    	return result;
//    }

    
    
	public static void main(String[] args) {
		System.out.print("식을 입력하시오>>");
		Scanner sc = new Scanner(System.in);		
		String s = sc.next();
		System.out.println(PostFix(s));
		sc.close();
	}

}
