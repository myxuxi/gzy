	class Tortoise {
		final int speed = 4;
		public static boolean hasEnd = false;
		public void run() {
			new Thread() {
				public void run() {
					int distance = 0;
					while (distance < 100) {
						try {
							Thread.sleep(1000);
							distance += speed;
							System.out.println("小乌龟跑了" + distance + "米");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					hasEnd = true;
					if (Rabbit.hasEnd) {
						System.out.println("差一点点就赢了~");
					} else {
						System.out.println("乌龟赢了");
					}
				}
			}.start();
		}
	}
class Rabbit {
		final int speed = 5;
		public static boolean hasEnd = false;
		public void run() {
			new Thread() {
				@Override
				public void run() {
					int distance = 0;
					boolean hasXiuXi = false;
					while (distance < 100) {
						try {
							Thread.sleep(1000);
							distance += speed;
							System.out.println("小兔子跑了" + distance + "米");
							if (distance > 50 && !hasXiuXi) {
								System.out.println("小兔子累了，决定休息一会儿~");
								Thread.sleep((long) (10000 * Math.random()));
								System.out.println("小兔子休息够了，又开始跑了！");
								hasXiuXi = true;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					hasEnd = true;
					if (Tortoise.hasEnd) {
						System.out.println("早知道就不休息了~");
					} else {
						System.out.println("兔子赢了");
					}
				}
			}.start();
		}
	}
	public class p2{
	public static void main(String[] arg) {
		new Tortoise().run();
		new Rabbit().run();
	}
}