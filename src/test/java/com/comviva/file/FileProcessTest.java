package com.comviva.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.comviva.exception.FileProcessException;

public class FileProcessTest {
	@Test
	public void fileProcessIsNull() {
		FileProcess fp = null;
		assertNull(fp);
	}

	@Test
	public void fileProcessIsNotNull() {
		FileProcess fp = new FileProcess();
		assertNotNull(fp);;
	}
	
	@Test()
	public void fileProcessSumAllNumberOfFile() throws FileProcessException {
		FileProcess fp = new FileProcess();
		assertEquals(new Double(124.2), fp.sumAllNumbers("/home/hernan/workspace/eclipse-workspace/comviva/files/test1.txt"));
	}
	
	@Test(expected=FileProcessException.class)
	public void fileProcessReturnException() throws FileProcessException {
		FileProcess fp = new FileProcess();
		assertEquals(new Double(124.2), fp.sumAllNumbers("/home/hernan/workspace/eclipse-workspace/comviva/files/test2.txt"));
	}
}
