package kr.co.hellodrinking.activity;

import kr.co.hellodrinking.R;
import android.app.Activity;
import android.os.Bundle;

public abstract class FrameActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        
        // R.id.frame_linear_content �� invoke ��Ű�� ������ �ʿ�
        // loadContent() �ּ� �� ������ ���
    }
    
    abstract void loadContent();
}
