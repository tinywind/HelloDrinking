package com.server.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainThread extends Thread{
	int option;
	Socket socket = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
		
	public MainThread(Socket socket) {
	this.socket=socket;
	}
    
	
	@Override
	public void run() {
		
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.flush();
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		switch (option){ 
			case 0 : break;//ȸ������
			case 1 : break;//�α���
			case 2 : break;//�Խù� �˻�(����,����,�Ÿ�?)
			case 3 : break;//�Խù� ���
			case 4 : break;//�Խù� ����
			case 5 : break;//�Խù� ����
			case 6 : break;//�Խù� �� ����
			case 7 : break;//�Խù��� ���� �����ڷ� ���(�ϳ��� �Խù��� ���� ������ ������)
			case 8 : break;//������ Ȯ��
			case 9 : break;//������ ����
			case 10 : break;//�޼��� �߽�, ����
			case 11 : break;//�α׾ƿ�
			case 12 : break;//ȸ��Ż��
		}
	}

	
	
}
