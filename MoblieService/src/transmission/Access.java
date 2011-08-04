package transmission;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Access {
	private Socket client;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	String ip="127.0.0.1";
	int port=5555;
	DTO receive_dto;
	
	public DTO request(DTO send_dto){
		//������ �����Ͽ� ������ �������� ��Ʈ�� �����Ѵ�.
		//dto�� ������ �۽��ϰ� ������� �����Ѵ�.	
		try {
			client = new Socket(ip,port);
			oos = new ObjectOutputStream(client.getOutputStream());
			oos.flush();
			ois = new ObjectInputStream(client.getInputStream());
			
			oos.writeObject(send_dto);
			receive_dto = (DTO)ois.readObject();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return receive_dto;
	}
}
