package labprorgam9;
import java.util.*;
class ValidateUSNException extends Exception
{
	private String msg = "";
	public ValidateUSNException(String msg)
	{
		this.msg = msg;
	}
	public String toString()
	{
		return msg;
	}
}
public class Main{
	private static void ValidateUSN(String usn) throws ValidateUSNException
	{
		int len =usn.length();
		if(len != 10)
			throw new ValidateUSNException("USN WITH INVALID LENGTH");
		boolean firstThree = usn.startsWith("4NM")||usn.startsWith("NNM");
		if(firstThree == false)
			throw new ValidateUSNException("USN DOES NOT START WITH 4NM");
		String year= usn.substring(3,5);
		int y= Integer.parseInt(year);
		if(y>22)
			throw new ValidateUSNException("USN WITH INVALID YEAR");
		String branch= usn.substring(5,7);
		String[] barr= {"CS","CV","AI","EE","EC","ME","RE","BT","IS","CC","DS"};
		boolean branchval = false;
		for(String str: barr)
		{
			if(branch.equals(str))
			{
				branchval = true;
			}
		}
		if(branchval==false)
			throw new ValidateUSNException("USN WITH INVALID BRANCH");
		String run =usn.substring(7,10);
		//int r=Integer.parseInt(run);
		boolean b=false;
		for(int i=0;i<run.length();i++)
		{
			char ch=run.charAt(i);
			if(ch>='0'&&ch<='9')
			{
				b=true;
			}
			else 
			{
				throw new ValidateUSNException("USN WITH INVALID RUNNING NUMBER");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter your USN: ");
		String str = read.nextLine();
		try
		{
			ValidateUSN(str);
		}
		catch(ValidateUSNException ex)
		{
			System.out.println(ex);
		}
		System.out.println("Validation Completed..");
	}
}