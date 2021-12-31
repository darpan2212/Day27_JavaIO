package com.watch.service;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public interface SimpleFileVisitor extends FileVisitor<Path>{

	@Override
	public FileVisitResult preVisitDirectory(Path dir,
			BasicFileAttributes attrs) throws IOException;
}
