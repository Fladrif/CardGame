import java.util.Random;

public class Randomizer{
	
	int hold1, hold2, hold3, hold4, hold5, hold6, hold7;

	public Randomizer(int num1, int num2, int num3, int num4, int num5, int num6, int num7){
		Random gen = new Random();
		int x = gen.nextInt(250);
		if(x % 3 == 0){
			hold1 = num1;
			hold2 = num5;
			hold3 = num2;
			hold4 = num6;
			hold5 = num3;
			hold6 = num7;
			hold7 = num4;
		} else if (x % 3 == 1){
			hold1 = num4;
			hold2 = num1;
			hold3 = num5;
			hold4 = num2;
			hold5 = num6;
			hold6 = num3;
			hold7 = num7;
		} else {
			hold1 = num2;
			hold2 = num3;
			hold3 = num4;
			hold4 = num5;
			hold5 = num6;
			hold6 = num7;
			hold7 = num1;
		}
	}
	public int returnNum1(){
		return hold1;
	}
	public int returnNum2(){
		return hold2;
	}
	public int returnNum3(){
		return hold3;
	}
	public int returnNum4(){
		return hold4;
	}
	public int returnNum5(){
		return hold5;
	}
	public int returnNum6(){
		return hold6;
	}
	public int returnNum7(){
		return hold7;
	}
}
