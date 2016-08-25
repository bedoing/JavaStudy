package com.duwei.multythread;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FileSearch2 implements Callable<List<File>> {
	static ExecutorService service = Executors.newCachedThreadPool();// �̳߳�
	private File directory;
	private FilenameFilter filter;

	public FileSearch2(File directory, FilenameFilter filter) {
		super();
		this.directory = directory;
		this.filter = filter;
	}

	public static void main(String[] args) throws Exception {
		File dir = new File("D:\\Usersworkspace\\JavaStudy");// ָ������Ŀ¼
		FileSearch search2 = new FileSearch(dir, new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");// ������java��β���ļ�
			}
		});
		FutureTask<List<File>> task = new FutureTask<>(search2);

		service.submit(task);

		for (File f : task.get()) {// ���������߳�
			System.out.println(f.getPath());
		}
		service.shutdown(); // ��ɺ�����̳߳�

	}

	@Override
	public List<File> call() throws Exception {
		System.out.println("�߳�" + Thread.currentThread().getName());
		List<File> list = new ArrayList<File>();// �ļ�
		File[] files = directory.listFiles();

		ArrayList<Future<List<File>>> results = new ArrayList<Future<List<File>>>();// װ��������
		for (File f : files) {
			if (f.isDirectory()) {// ����һ��Ŀ¼
				Callable<List<File>> runnable = new FileSearch(f, filter);// �з���ֵ������
				FutureTask<List<File>> task = new FutureTask<List<File>>(
						runnable);
				results.add(task);
				service.submit(task);
			} else if (filter.accept(f.getParentFile(), f.getName())) {
				list.add(f);
			}
		}
		for (Future<List<File>> result : results) {
			list.addAll(result.get());
		}
		return list;
	}

}
