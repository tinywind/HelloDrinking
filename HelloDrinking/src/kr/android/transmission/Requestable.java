package kr.android.transmission;


public interface Requestable {
	
	int register();        //ȸ������
	
    DTO logIn(String id,String password);          //�α���
   
	void search();         //�Խù��˻�     
	
	void post();	          //�Խù����    
	
	void modify_Post();    //�Խù� ����

	void delete_Post();    //�Խù� ���� 

	void detail_Post();    //�Խù� �� ����
	
	void add_following(); //�Խù��� ���� �����ڷ� ���
	
	void detail_Profile();//������Ȯ��
	
	void modify_Profile(); //������ ����
	
	void send_Message();   //�޼��� �߽�
	
	void logOut();    //�α׾ƿ�     
	
	void out_Member();     //ȸ��Ż��
}
