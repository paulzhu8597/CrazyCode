package point;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
/**
 * 使用Fork/Join框架首先要考虑到的是如何分割任务，如果希望每个子任务最多执行两个
数的相加，那么我们设置分割的阈值是2，由于是4个数字相加，所以Fork/Join框架会把这个任
务fork成两个子任务，子任务一负责计算1+2，子任务二负责计算3+4，然后再join两个子任务
的结果。因为是有结果的任务，所以必须继承RecursiveTask，

ForkJoinPool由ForkJoinTask数组和ForkJoinWorkerThread数组组成，ForkJoinTask数组负责
将存放程序提交给ForkJoinPool的任务，而ForkJoinWorkerThread数组负责执行这些任务。
（1）ForkJoinTask的fork方法实现原理
当我们调用ForkJoinTask的fork方法时，程序会调用ForkJoinWorkerThread的pushTask方法
异步地执行这个任务，然后立即返回结果。代码如下。
public final ForkJoinTask<V> fork() {
((ForkJoinWorkerThread) Thread.currentThread())
.pushTask(this);
return this;
}
pushTask方法把当前任务存放在ForkJoinTask数组队列里。然后再调用ForkJoinPool的
signalWork()方法唤醒或创建一个工作线程来执行任务。代码如下。
final void pushTask(ForkJoinTask<> t) {
ForkJoinTask<>[] q; int s, m;
if ((q = queue) != null) {　　　　// ignore if queue removed
long u = (((s = queueTop) & (m = q.length - 1)) << ASHIFT) + ABASE;
UNSAFE.putOrderedObject(q, u, t);
queueTop = s + 1;　　　　　　// or use putOrderedInt
if ((s -= queueBase) <= 2)
pool.signalWork();
else if (s == m)
growQueue();
}
}
（2）ForkJoinTask的join方法实现原理
Join方法的主要作用是阻塞当前线程并等待获取结果。让我们一起看看ForkJoinTask的join
方法的实现，代码如下。
public final V join() {
if (doJoin() != NORMAL)
return reportResult();
else
return getRawResult();
} private V
reportResult() {
int s; Throwable ex;
if ((s = status) == CANCELLED)
throw new CancellationException();
if (s == EXCEPTIONAL && (ex = getThrowableException()) != null)
UNSAFE.throwException(ex);
return getRawResult();
}
首先，它调用了doJoin()方法，通过doJoin()方法得到当前任务的状态来判断返回什么结
果，任务状态有4种：已完成（NORMAL）、被取消（CANCELLED）、信号（SIGNAL）和出现异常
（EXCEPTIONAL）。
·如果任务状态是已完成，则直接返回任务结果。
·如果任务状态是被取消，则直接抛出CancellationException。
·如果任务状态是抛出异常，则直接抛出对应的异常。
让我们再来分析一下doJoin()方法的实现代码。
private int doJoin() {
Thread t; ForkJoinWorkerThread w; int s; boolean completed;
if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
if ((s = status) < 0)
return s;
if ((w = (ForkJoinWorkerThread)t).unpushTask(this)) {
try {
completed = exec();
} catch (Throwable rex) {
return setExceptionalCompletion(rex);
}
if (completed)
return setCompletion(NORMAL);
}
return w.joinTask(this);
}
else
return externalAwaitDone();
}
在doJoin()方法里，首先通过查看任务的状态，看任务是否已经执行完成，如果执行完成，
则直接返回任务状态；如果没有执行完，则从任务数组里取出任务并执行。如果任务顺利执行
完成，则设置任务状态为NORMAL，如果出现异常，则记录异常，并将任务状态设置为
EXCEPTIONAL。

 * @author wangzequan
 *
 */
public class CountTask extends RecursiveTask<Integer> {
private static final int THRESHOLD = 2; // 阈值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			// 如果任务大于阈值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待子任务执行完，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		// 生成一个计算任务，负责计算1+2+3+4
		CountTask task = new CountTask(1, 4);
		// 执行一个任务
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
	}
}