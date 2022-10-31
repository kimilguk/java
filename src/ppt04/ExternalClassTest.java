package ppt04;

import ppt03.ExternalClass;

public class ExternalClassTest {

	public static void main(String[] args) {
		ExternalClass dice1, dice2;
		int rollCount;

		dice1 = new ExternalClass();
		dice2 = new ExternalClass();
		rollCount = 0;

		do {
			dice1.roll();
			dice2.roll();
			System.out.println("주사위1= " + dice1.getValue() + " 주사위2= " + dice2.getValue());
			rollCount++;
		} while ((dice1.getValue() + dice2.getValue()) != 2);

		System.out.println("(1, 1)이 나오는데 걸린 횟수= " + rollCount);
	}

}
