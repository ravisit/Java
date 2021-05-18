import java.util.Scanner;
import java.util.Arrays;
class Problem {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the start number ");
		int start = sc.nextInt();
		System.out.println("Enter the end number ");
		int end = sc.nextInt();
		int pCount=0, k=0, m=0, aCount=0, dCount=0, mCount=0, sCount=0, sSize=0;
		int pArr[] = new int[end-start];
		int sArr[] = new int[end-start];
		int temp[] = new int[end-start];
		//to get the prime numbers in between start and end.
		for(int i=start;i<=end;i++){
		    if(isPrime(i)){
				pArr[k++]=i;
				pCount++;
			}
		}
		//print the prime numbers
		System.out.println("The series is listed below ");
		sArr[0]=1;
		for(int i=0;i<pCount && sArr[i]<=end;i++){
			//System.out.print(" "+pArr[i]);
			sArr[i+1]= sArr[i]+pArr[i];
			//print the series
			//System.out.println();
			System.out.print(" "+sArr[i]);
			sSize=i+1;
		}
		System.out.println();
		System.out.println("------");
		System.out.println("Series array size = "+sSize);
		//System.out.println(sArr.length);
		System.out.println("------");
		for(int i=0;i<sSize;i++){
			Arrays.fill(temp,0);
			m=0;
			//System.out.println("for loop for ordering");
			if(sArr[i]<=100){
				sCount++;
			} else{
				int num=sArr[i];
				while(num!=0){
					//System.out.println("while loop");
					temp[m++]=num%10;
					num=num/10;
				}
				/*System.out.println();
				System.out.println("------");
				System.out.println("Temp array size = "+m);
				System.out.println("------");*/
				for(int j=0;j<m;j++){
					if(temp[j]<=temp[j+1] && temp[j+1]<=temp[j+2]){
						dCount++;
						break;
					} else if(temp[j]>=temp[j+1] && temp[j+1]>=temp[j+2]){
						aCount++;
						break;
					} else{
						mCount++;
						break;
					}
				}
			}
		}
		System.out.println();
		System.out.println("ordered numbers counting is ... ");
		System.out.println("Ascending ordered numbers count = "+aCount);
		System.out.println("Dscending ordered numbers count = "+dCount);
		System.out.println("Misslencious ordered numbers count = "+mCount);
		
	}
    
	public static boolean isPrime(int n){
		if(n<=1){
			return false;
		}
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n % i==0){
				return false;
			}
		}
		return true;
	}
}