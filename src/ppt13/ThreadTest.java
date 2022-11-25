package ppt13;

public class ThreadTest extends Thread {
	public ThreadTest(String name) {
		super(name);//작업1,2,3 객체이름 초기화
	}
	@Override
	public void run() {
		//super.run(); //생략해도 문제없음.
		synchronized (this) { //현재 메서드를 싱크로나이즈 synchronized  키워드로 감싸준다.
			for(int cnt=0;cnt<50;cnt++) {
				System.out.print(this.getName() + " ");
			}
			notify();//현재 스레드 작업인 for문이 완료 시 자바시스템에 알림 메세지를 보낸다.
		}
	}
	public static void main(String[] args) throws Exception {
		ThreadTest T1 = new ThreadTest("작업1");
		ThreadTest T2 = new ThreadTest("작업2");
		ThreadTest T3 = new ThreadTest("작업3");
		T1.start();
		synchronized(T1) {//객체를 synchronized 키워드로 감싸주면 스레드 작업이 1,2,3 순서대로 실행된다.

			T1.wait();
		}
		T2.start();
		synchronized(T2) {
			T2.wait();
		}
		T3.start();
		synchronized(T3) {
			T3.wait();
		}
		//(new ThreadTest("작업2")).start();
		//(new ThreadTest("작업3")).start();//비동기라서 스레드 작업이 1,2,3 순서대로 실행되지 않는다.
		//익명클래스 구현하는 방식(아래)
		Runnable task = new Runnable() {
			@Override
			public void run() {
				for(int i=10;i>=0;i--) {
					try {
						Thread.sleep(1000);//1000밀리세컨트 = 1초간 스레드대기
						System.out.print(i + " ");
						if(i == 5) {
							System.out.println("인터럽트 발생");
							Thread.currentThread().interrupt();//강제로 스레드작업을 중지 예외를 발생시킨다.
						}						
					} catch (InterruptedException e) {//스레드가 중지될때 발생하는 예외
						System.out.println("인터럽트발생 시 break처리");
						break; //for문 종료
					}
				}//for문 End
			}//run() 구현 메서드 End
		};//Runnable 익명클래스 End
		//스레드 시작
		new Thread(task).start();//러너블 task객체를 스레드로 실행하는 start메서드
	}
}
