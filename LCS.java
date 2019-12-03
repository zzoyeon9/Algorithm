package Week12;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LCS {

	static String str, str2; static int [][] lcs;
	static int index;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		str = "0"+input.nextLine();
		str2 = "0"+input.nextLine();

		lcs = new int[str2.length()][str.length()];
		Searching();

		System.out.println(lcs[str2.length()-1][str.length()-1]);

		Printing();

	}

	static void Searching() {

		for(int i=0;i<str2.length();i++)

			for(int j=0;j<str.length();j++)

				if(i==0 || j==0)
					lcs[i][j]=0;
				else 
					if(str2.charAt(i)==str.charAt(j))
						lcs[i][j]=lcs[i-1][j-1]+1;

					else 
						if(lcs[i][j-1]>lcs[i-1][j])
							lcs[i][j]= lcs[i][j-1];

						else
							lcs[i][j]=lcs[i-1][j];

	}
	static void Printing() {
		String temp = "";

		int i = str2.length()-1;
		int j = str.length()-1;

		while(i!=0 && j!=0 && lcs[i][j]!=0)
			if(lcs[i][j]>lcs[i-1][j] && lcs[i][j]>lcs[i][j-1]) {
				temp+=str2.charAt(i);
				i--; j--;
			}
			else 
				if(lcs[i][j]>lcs[i-1][j])
					j--;
				else
					i--;

		StringBuffer result = new StringBuffer(temp).reverse();

		System.out.println(result.toString());
	}
}
