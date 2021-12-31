package com.testfile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;

public class NIOFileTest {

	public static String HOME = "d:\\Darpan";
	public static String PLAY_WITH_NIO = "tempDir";

	@Test
	public void checkPathExist() throws IOException {
		Path path = Paths.get(HOME);
		System.out.println(path);
		assertTrue(Files.exists(path));

		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (!Files.exists(playPath)) {
			assertFalse(Files.exists(playPath));
			try {
				Files.createDirectory(playPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Files.list(playPath).forEach(p -> {
				try {
					Files.delete(p);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

		System.out.println(playPath);
		assertTrue(Files.exists(playPath));

		IntStream.range(1, 10).forEach(cnt -> {
			Path filePath = Paths.get(playPath + "/temp" + cnt);
			if (Files.notExists(filePath)) {
				assertTrue((Files.notExists(filePath)));
				try {
					Files.createFile(filePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			assertFalse((Files.notExists(filePath)));
		});

		System.out.println("----------print only files-------------");
		Files.list(playPath).filter(Files::isRegularFile)
				.forEach(System.out::println);
		System.out.println("----------print all paths-------------");
		Files.newDirectoryStream(playPath)
				.forEach(System.out::println);
		System.out.println(
				"----------print only temp files-------------");
		Files.newDirectoryStream(playPath, p -> {
			return p.toFile().isFile()
					&& p.getFileName().toString().startsWith("temp");
		}).forEach(System.out::println);

	}
}