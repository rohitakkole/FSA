//program to generate otp
import java.util.ArrayList;
import java.util.Collections;
class otp
{
	public static void main(String[] args)
	{
		System.out.println(OTP());
	}
	public static String OTP()
	{
		ArrayList<Integer> list =new ArrayList<>();
		for(int i=0;i<=9;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		int Otp=0;
		Otp=(list.get(0)*1000)+(list.get(1)*100)+(list.get(2)*10)+(list.get(3)*1);
		return Integer.toString(Otp);
	}
}
