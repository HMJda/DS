import java.util.Scanner;
public class DS1 {

	public static int[][] three(int[][] a) { //1) 입력받은 행렬을 3 원소로 저장
		int count = 0;
		int[][] copy = new int[a.length*a[0].length+1][a.length*a[0].length+1];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]!= 0) {
					count +=1;
					copy[count][0]=i;
					copy[count][1]=j;
					copy[count][2]=a[i][j];

				}
			}
		}
		int[][] three = new int[count+1][3];
		three[0][0]= a.length;
		three[0][1]= a[0].length;
		three[0][2]= count;
		for(int i=1;i<three.length;i++) {
			three[i][0] = copy[i][0];
			three[i][1] = copy[i][1];
			three[i][2] = copy[i][2];
		}		
		return three;
	}
	
	public static int[][] basic(int[][] a) { //2) 이 표현법으로 표기된 행렬을 원 상태의 행렬로 복원해 보시오.
		int[][] basic=new int[a[0][0]][a[0][1]];
		int count=1;
		for(int i = 0;i<basic.length;i++) {
			for(int j=0;j<basic[0].length;j++) {
				basic[a[count][0]][a[count][1]] = a[count][2];
				if(count < a.length-1) {
					count++;
				}
			}
		}
		return basic;
	}
	
	public static int[][] MatrixTranspose(int[][] a) { //3) 이의 전치행렬(matrix transpose)을 구한 결과를 보이시오.
		int[][] M = new int[a[0].length][a.length];
		for(int i =0;i<M.length;i++) {
			for(int j =0;j<M[0].length;j++) {
				M[i][j]=a[j][i];
			}
		}
		return M;
	}
	
	public static void main(String[] args) {
		System.out.print("행과 열을 입력>>");
		Scanner sc = new Scanner(System.in);
		int r,c;
		r = sc.nextInt(); //행 
		c = sc.nextInt(); //열
		int[][] a = new int[r][c]; //15 * 8 행렬 생성 
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				a[i][j] = (int)Math.floor(Math.random()*10); // 행렬에 랜덤한 값 입력 
			}
		}
//		for(int i = 0; i < a.length;i++) { //a의 행렬 출력 
//			for(int j=0;j<a[0].length;j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int[][] three = three(a); //희소 행렬 
		System.out.println("\\ 행 열 값");
		for(int i = 0; i < three.length;i++) {
			System.out.print(i + " ");
			for(int j=0;j<three[0].length;j++) {
				System.out.print(three[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] basic=basic(three); //원래 행렬로 
		for(int i = 0; i < basic.length;i++) {
			for(int j=0;j<basic[0].length;j++) {
				System.out.print(basic[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] M = MatrixTranspose(basic);  //전치행렬
		for(int i = 0; i < M.length;i++) {
			for(int j=0;j<M[0].length;j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
