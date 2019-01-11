package thread;

public class SyncThread implements Runnable {
	private static int count;

	public SyncThread() {
		count = 0;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
      if (threadName.equals("A")) {
    	  sync();
      } else if (threadName.equals("B")) {
    	  other();
      }
		
		
//		String timeStr = new TestSync().createTimeStr();
//		System.out.println(Thread.currentThread().getName() + ": timeStr=" + timeStr);
	}
	
	private void sync(){
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ": i=" + i + "; count = " + (count++));
				 try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	private synchronized void other(){
//		synchronized (this) {
	      for (int i = 0; i < 5; i ++) {
	    	  System.out.println(Thread.currentThread().getName() + ": i=" + i + "; count = " + (count));
	    	  try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
//		}
	}

	public int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		//1.当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
		//一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
//		SyncThread syncThread = new SyncThread();
//		Thread thread1 = new Thread(syncThread, "A");
//		Thread thread2 = new Thread(syncThread, "B");
//		thread1.start();
//		thread2.start();
		
		int i = 10;
	    System.out.println(i++);
	    System.out.println(i);
	    
	    int j= 10;
	    System.out.println(++j);
	    System.out.println(j);
	    
		
//		for(int i = 0;i<1000;i++){
//			Thread thread1 = new Thread(new SyncThread(), "thread"+(i<10?"0"+i:i));
//			thread1.start();
//		}
		//8818-7494= 1324  7076-5967=1109  10354-9120 = 1234 1403-245=1158
	}
}
