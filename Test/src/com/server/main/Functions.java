package com.server.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Functions {
	
	
	public int register(DTO receive_dto,Connection conn){
		int result=1;
		PreparedStatement pstmt=null;
		
		try {
		pstmt = conn.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, receive_dto.getId());
		pstmt.setString(2, receive_dto.getName());
		pstmt.setString(3, receive_dto.getPassword());
		pstmt.setString(4, receive_dto.getImage());
		pstmt.setString(5, receive_dto.getAge());
		pstmt.setString(6, receive_dto.getSex());
		pstmt.setString(7, receive_dto.getPhoneNumber());
		pstmt.setString(8, receive_dto.getJob());
		pstmt.setString(9, receive_dto.getLog());
				
		pstmt.executeUpdate();
		conn.commit();
		} catch (SQLException e) {
			result =0;
			e.printStackTrace();
		}	
		return result;
	}//ȸ������
	
	public void logIn(){
		
	}//�α���
	public void search(){
		
	}//�Խù��˻�
	public void post(){
		
	}//�Խù����
	public void modify_Post(){
		
	}//�Խù� ����
	public void delete_Post(){
		
	}//�Խù� ����
	public void detail_Post(){
		
	}//�Խù� �� ����
	public void add_following(){
		
	}//�Խù��� ���� �����ڷ� ��� 
	public void detail_Profile(){
		
	}//������Ȯ��
	public void modify_Profile(){
		
	}//������ ����
	public void send_Message(){
		
	}//�޼��� �߽�
	public void logOut(){
		
	}//�α׾ƿ�
	public void out_Member(){
		
	}//ȸ��Ż��
}
