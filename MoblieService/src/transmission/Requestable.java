package transmission;


public interface Requestable {
	
	public int register();        //ȸ������
	
    public void logIn();          //�α���
   
	public void search();         //�Խù��˻�     
	
	public void post();	          //�Խù����    
	
	public void modify_Post();    //�Խù� ����

	public void delete_Post();    //�Խù� ���� 

	public void detail_Post();    //�Խù� �� ����
	
	public void add_following(); //�Խù��� ���� �����ڷ� ���
	
	public void detail_Profile();//������Ȯ��
	
	public void modify_Profile(); //������ ����
	
	public void send_Message();   //�޼��� �߽�
	
	public void logOut();    //�α׾ƿ�     
	
	public void out_Member();     //ȸ��Ż��
}
