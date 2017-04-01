package point;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Exchanger可以用于遗传算法，遗传算法里需要选出两个人作为交配对象，这时候会交换
	两人的数据，并使用交叉规则得出2个交配结果。Exchanger也可以用于校对工作，比如我们需
	要将纸制银行流水通过人工的方式录入成电子银行流水，为了避免错误，采用AB岗两人进行
	录入，录入到Excel之后，系统需要加载这两个Excel，并对两个Excel数据进行校对，看看是否
	录入一致
 * @author wangzequan
 *
 */
public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<String>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String A = "银行流水A"; // A录入银行流水数据
					exgr.exchange(A);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String B = "银行流水B";// B录入银行流水数据
					String A = exgr.exchange("B");
					System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.shutdown();
	}
}