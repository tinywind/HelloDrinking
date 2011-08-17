package kr.co.hellodrinking.activity;

import kr.co.hellodrinking.R;
import kr.co.hellodrinking.activity.map.MapActivity;
import kr.co.hellodrinking.activity.map.PostsModel;
import kr.co.hellodrinking.ar.BasicOpenARDemoActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public abstract class FrameActivity extends Activity implements OnClickListener{
	public static PostsModel mPostsModel;

	protected LayoutInflater mInflater;
	protected ViewGroup mViewgroup;
	protected LinearLayout mButtonPosts, mButtonMap, mButtonAR;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame);
        
        mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewgroup = (ViewGroup) findViewById(R.id.frame_linear_contents);
        
        mButtonPosts = (LinearLayout) findViewById(R.id.frame_linear_posts);
        mButtonMap = (LinearLayout) findViewById(R.id.frame_linear_map);
        mButtonAR = (LinearLayout) findViewById(R.id.frame_linear_ar);
        
        mButtonPosts.setOnClickListener(this);
        mButtonMap.setOnClickListener(this);
        mButtonAR.setOnClickListener(this);
        
        mPostsModel = new PostsModel();
        
        loadContent();
    }

	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.frame_linear_posts){
			startActivity(new Intent(this, PostsActivity.class));
		}else if(view.getId() == R.id.frame_linear_map){
			startActivity(new Intent(this, MapActivity.class));			
		}else if(view.getId() == R.id.frame_linear_ar){
			startActivity(new Intent(this, BasicOpenARDemoActivity.class));			
		}
	}

	protected abstract void loadContent();
}
