package ppt06;

public class ImplementsCalc implements CalcAddSub, CalcMulDiv {
	@Override
	public void mul(double dx, double dy) {
		System.out.println("곱하기 결과는 " + dx*dy);
	}
	@Override
	public void div(double dx, double dy) {
		System.out.println("나누기 결과는 " + dx/dy);
	}
	@Override
	public void add(double dx, double dy) {
		System.out.println("더하기 결과는 " + (dx+dy) );
	}
	@Override
	public void sub(double dx, double dy) {
		System.out.println("빼기 결과는 " + (dx-dy) );
	}
}
