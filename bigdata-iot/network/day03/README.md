```java
	public void startServer() throws Exception {
		System.out.println("TCP/IP Server Start");
		try {
			serverSocket = new ServerSocket(port);
		}catch(Exception e) {
			throw e;
		}	
	}
```

try/catch 생성해서 throws Exception 해야 예외 발생시 잡을 수 있음
