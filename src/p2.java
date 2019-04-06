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
							System.out.println("С�ڹ�����" + distance + "��");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					hasEnd = true;
					if (Rabbit.hasEnd) {
						System.out.println("��һ����Ӯ��~");
					} else {
						System.out.println("�ڹ�Ӯ��");
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
							System.out.println("С��������" + distance + "��");
							if (distance > 50 && !hasXiuXi) {
								System.out.println("С�������ˣ�������Ϣһ���~");
								Thread.sleep((long) (10000 * Math.random()));
								System.out.println("С������Ϣ���ˣ��ֿ�ʼ���ˣ�");
								hasXiuXi = true;
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					hasEnd = true;
					if (Tortoise.hasEnd) {
						System.out.println("��֪���Ͳ���Ϣ��~");
					} else {
						System.out.println("����Ӯ��");
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