package com.illidan.fireragekit.base;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.util.Log;

public class BaseException implements UncaughtExceptionHandler {
	
	//上下文
    private Context mContext; 
    
    private Thread.UncaughtExceptionHandler defaultExceptionHandler; 
    //CustomException; 
    private static BaseException baseException; 
    
    private BaseException(){    
    	
    } 
    
    public static BaseException getInstance(){ 
        if(baseException == null){ 
        	baseException = new BaseException(); 
        } 
        return baseException; 
    } 
    
    @Override 
    public void uncaughtException(Thread thread, Throwable exception) { 
        // TODO Auto-generated method stub 
        if(defaultExceptionHandler != null){ 
            
        	exception.printStackTrace();
            Log.e("tag", "异常 >>>>>>>"+exception.getLocalizedMessage()); 
            defaultExceptionHandler.uncaughtException(thread, exception); 
            
        } 
    } 
    
	public void init(Context context) {
		setmContext(context);
		defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}
	
}
