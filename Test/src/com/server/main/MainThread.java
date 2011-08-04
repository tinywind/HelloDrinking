package com.server.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;

import com.db.connection.DBConnection;

public class MainThread extends Thread {
	int option;
	Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	Connection conn = null;
	DTO receive_dto;
	DTO send_dto;

	public MainThread(Socket socket) {
		this.socket = socket;

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

			System.out.println("�����б�1");
			receive_dto = (DTO) ois.readObject();// ���Ⱑ����
			System.out.println("�����б�2");
			option = receive_dto.getOption();
			System.out.println("�����б�3");
			Functions_Server f = new Functions_Server();
			System.out.println("�����б�4");
			conn = DBConnection.Connect();

			switch (option) {
			case 0:
				send_dto.setResult(f.register(receive_dto, conn));// ��ûó�� &�������
				oos.writeObject(send_dto);// �������
				ois.close();
				oos.close();
				System.out.println("ȸ�����ԿϷ�");
				break;// ȸ������

			case 1:
				System.out.println("���� �α��� �б�1");
				send_dto.setResult(f.logIn(receive_dto, conn));
				System.out.println("���� �α��� �б�1");
				oos.writeObject(send_dto);// �������
				ois.close();
				oos.close();
				System.out.println("�α��μ���");
				break;// �α���

			case 2:
				break;// �Խù� �˻�(����,����,�Ÿ�?)
			case 3:
				break;// �Խù� ���
			case 4:
				break;// �Խù� ����
			case 5:
				break;// �Խù� ����
			case 6:
				break;// �Խù� �� ����
			case 7:
				break;// �Խù��� ���� �����ڷ� ���(�ϳ��� �Խù��� ���� ������ ������)
			case 8:
				break;// ������ Ȯ��
			case 9:
				break;// ������ ����
			case 10:
				break;// �޼��� �߽�, ����
			case 11:
				break;// �α׾ƿ�
			case 12:
				break;// ȸ��Ż��
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
