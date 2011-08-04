package com.server.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;


import com.db.connection.DBConnection;

public class MainThread extends Thread{
	int option;
	Socket socket = null;
	DTO receive_dto;
	DTO send_dto;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	Connection conn=null;
		
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
		Functions_Server f= new Functions_Server();
		conn=DBConnection.Connect();
		
		switch (option){ 
			case 0 : 
					send_dto.setResult(f.register(receive_dto,conn));//��ûó�� &�������
					oos.writeObject(send_dto);//�������
					ois.close();oos.close();
					System.out.println("ȸ�����ԿϷ�");
				break;//ȸ������
				
			case 1 : 
					 send_dto.setResult(f.logIn(receive_dto,conn));
				     oos.writeObject(send_dto);//�������
				     ois.close();oos.close();
				     System.out.println("�α��μ���");
				break;//�α���
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
