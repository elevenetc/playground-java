import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Eugene Levenetc on 23/07/14.
 */
public class TasksSample {
	public static void execute() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.submit(new Task("A"));
		executorService.submit(new Task("B"));
		executorService.submit(new Task("C"));
		executorService.submit(new Task("D"));
		executorService.shutdown();
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("all tasks finished");
	}

	private static class Task implements Runnable {

		private String taskId;

		public Task(String taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("finished task: " + taskId);
		}
	}
}
