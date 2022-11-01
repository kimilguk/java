package ppt05;

public class ObjectCopyTest {
	public static class Pizza {
		private String toppings;
		public static int count; //static 고정 메모리 영역에 저장된다.
		public Pizza(String string) {
			this.toppings = string;
			count++;
		}
	}
	public static void main(String[] args) {
		Pizza pizza = new Pizza(null);
		Pizza p1 = new Pizza("슈프림");
        Pizza p2 = new Pizza("치즈");
        int n = pizza.count; //Pizza클래스로 직접 접근이 가능하다.
        System.out.println("지금까지 만든 피자 개수 = " + n);
        System.out.println("피자 p1와 p2 비교 = " + (p1==p2));
        p1 = p2; //p1 값이 메모리에서 사라진다. 즉,2개 모두 new Pizza("치즈")가 된다.
        System.out.println("피자 p1의 토핑은 = " + p1.toppings);
        System.out.println("피자 p2의 토핑은 = " + p2.toppings);
        System.out.println("피자 p1와 p2 비교 = " + (p1==p2));
	}
}
