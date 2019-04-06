public class p1 extends Thread{
	public p1(String name){
		super(name);
	}
	public void run(){
		for(int k=1;k<=6;k++){
			System.out.println(getName()+":"+k);
			try{
				sleep((int)(Math.random()*200));
			}catch (InterruptedException e){}
		}
	}
	public static void main(String args[]){
		new p1("first").start();
		new p1("second").start();
		new p1("third").start();
	}


}
