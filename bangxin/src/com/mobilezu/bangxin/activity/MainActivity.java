package com.mobilezu.bangxin.activity;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.mobilezu.bangxin.R;

public class MainActivity extends Activity {
	public XMPPConnection connection;
	private String host = "10.10.20.222";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置无标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		try {
			ConnectionConfiguration connectionConfig = new ConnectionConfiguration(host, 5222, "");
			connectionConfig.setSASLAuthenticationEnabled(false);
			connectionConfig.setSecurityMode(SecurityMode.disabled);
			connectionConfig.setReconnectionAllowed(true);
			connectionConfig.setCompressionEnabled(false);
			connectionConfig.setDebuggerEnabled(true);
			connectionConfig.setTruststorePath("/system/etc/security/cacerts.bks");
			connectionConfig.setTruststoreType("BKS");
			connection = new XMPPConnection(connectionConfig);
			connection.connect();
			Log.i(this.getClass().getName(),
					"连接成功：" + connection.getConnectionID());
		} catch (XMPPException e) {
			Log.d(this.getClass().getName(), "onCreate：" + e.getMessage());
		}
	}
	
	/**
	 * 登录
	 */
	private void login(){
		
	}
	
	/**
	 * 注册
	 */
	private void register(){
		
	}


}
