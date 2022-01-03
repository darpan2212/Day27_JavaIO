package com.watch.service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

@FunctionalInterface
interface FileVisit<T> {
	public void visit(T t);
}

public class SimpleFileVisitor<T> implements FileVisitor<T> {

	FileVisit<T> visit;

	public SimpleFileVisitor(FileVisit<T> visit) {
		this.visit = visit;
	}

	@Override
	public FileVisitResult visitFileFailed(T t, IOException exc) {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(T t, BasicFileAttributes attrs) {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(T t, IOException exc) {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(T t,
			BasicFileAttributes attrs) {
		System.out
				.println("previsit dir method has been called " + t);
		visit.visit(t);
		return FileVisitResult.CONTINUE;
	}
}
