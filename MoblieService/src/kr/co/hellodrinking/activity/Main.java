package kr.co.hellodrinking.activity;

import java.io.*;
import java.util.*;

import kr.co.hellodrinking.*;
import android.app.*;
import android.os.*;

public class Main extends Activity {
	private List<File> mImageFiles;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		
		mImageFiles = new ArrayList<File>();
		
		
		File sdcardRoot = Environment.getExternalStorageDirectory();
		
		File[] children = sdcardRoot.listFiles();
		
		for(int index=0;index<children.length;index++){
			if(children[index].isDirectory()){
				//���� ���丮
			}else{
				//���� ����
				//�̹��������� �³�?
				mImageFiles.add(children[index]);
				
			}			
		}
		////////////////////////////////////////////
		
		//�ѷ��ֱ� :: �׸����
		
		
	}
	
	///////////////////////////////
	///�ݹ� :: ��ιޱ�
}
