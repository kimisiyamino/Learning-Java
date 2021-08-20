public class TestShield04{
	public static void main(String[] args){
		
		int num1 = 1;
		int num2 = 0;
		char num = 0;
		try{
			 num = (char)System.in.read();
		}catch(Exception e){}
		
		num2 = num - '0';
		
		System.out.println("Введенное число " + num2);
		
		while(++num1 < --num2) ;
		System.out.println(num1);
		
		int[] superArray1 = {1 ,2,3};
		int[][] superArray2 = {
			{1,2,3}, 
			{1,2,3}, 
			{1,2,3}
		};
		int[][][] superArray3 = 
		{
			{
				{1,2,3}, 
				{1,2,3}, 
				{1,2,3}
			},
			{
				{1,2,3}, 
				{1,2,3}, 
				{1,2,3}
			},
			{
				{1,2,3},
				{1,2,3}, 
				{1,2,999}
			}
		};
		int[][][][] superArray4 =
		{
			{
				{
					{1,2,3}, 
					{4,5,6}, 
					{7,8,9}
				},
				{
					{10,11,12}, 
					{13,14,15}, 
					{16,17,18}
				},
				{
					{19,20,21},
					{22,23,24}, 
					{25,26,27}
				}
			},	
			{
				{
					{28,29,30}, 
					{31,32,33}, 
					{34,35,36}
				},
				{
					{37,38,39}, 
					{40,41,42}, 
					{43,44,45}
				},
				{
					{46,47,48},
					{49,50,51}, 
					{52,53,54}
				}
			}
		};
		
		
		System.out.println(superArray3[2][2][2]);
		System.out.println(superArray4[1][2][2][2]);
		
		
		pointOne: for(int[][][] superArray4_3 : superArray4){
			pointTwo: for(int[][] superArray4_2 : superArray4_3){
						for(int[] superArray4_1: superArray4_2){
							for(int superArray4_val : superArray4_1){
								System.out.print(superArray4_val);
							}
							System.out.print("\n");
							continue pointTwo;
				}
			}
		}
	}	
}