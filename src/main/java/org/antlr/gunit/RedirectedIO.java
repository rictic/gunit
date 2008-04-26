package org.antlr.gunit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;



//Use of this class is not in any way thread safe in the slightest.
//It has global effects.
public class RedirectedIO {
	private PipedInputStream pipedIn;
	private PipedInputStream pipedErrIn;
	private PrintStream console;
	private PrintStream consoleErr;
	private PrintStream ps;
	private PrintStream ps2;
	private String stdOut = null;
	private String stdErr = null; 
	
	public void beginRedirecting() {
		/** Start of I/O Redirecting */
        pipedIn = new PipedInputStream();
        PipedOutputStream pipedOut = new PipedOutputStream();
        
        pipedErrIn = new PipedInputStream();
        PipedOutputStream pipedErrOut = new PipedOutputStream();
        try {
        	pipedOut.connect(pipedIn);
        	pipedErrOut.connect(pipedErrIn);
        }
        catch(IOException e) {
        	System.err.println("connecting Piped Streams together failed...");
        	System.exit(1);
        }
        console = System.out;
        consoleErr = System.err;
        ps = new PrintStream(pipedOut);
        ps2 = new PrintStream(pipedErrOut);
        System.setOut(ps);
        System.setErr(ps2);
	}
	
	//restores the application's output streams to the way they were
	//before
	public void restore() {
		if (ps == null || ps2 == null)
			throw new RuntimeException("only call restore() once per RedirectedIO, and only after calling beginRedirecting()");
		ps.close();
		ps2.close();
		System.setOut(console);			// Reset standard output
		System.setErr(consoleErr);		// Reset standard err out
	}
	
	public String getOutput() throws IOException {
		if (stdOut == null) stdOut = read(pipedIn);
		return stdOut;
	}
	
	public String getErr() throws IOException {
		if (stdErr == null) stdErr = read(pipedErrIn);
		return stdErr;
	}
	
	private String read(InputStream in) throws IOException {
		StringBuilder target = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = reader.readLine();
		while (line != null) {
			target.append(line);
			target.append("\n");
			line = reader.readLine();
		}

		return target.toString();
	}
}
