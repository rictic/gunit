/*
 [The "BSD licence"]
 Copyright (c) 2008 Peter Burns
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
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
