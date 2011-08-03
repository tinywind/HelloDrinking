package com.server.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainThread extends Thread{
	int option;
	Socket socket = null;
	DTO receive_dto;
	DTO send_dto;
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
		
		try {
			receive_dto =(DTO)ois.readObject();
		
		
		option = receive_dto.getOption();
		Functions f= new Functions();
		
		switch (option){ 
			case 0 : 
					f.register();
					send_dto.setResult(1);
					oos.writeObject(send_dto);
				break;//ȸ������
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
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
