package com.illidan.fireragekit.base;

import com.illidan.fireragekit.base.BaseException;
import android.app.Application;

public class BaseApplication extends Application {
	private static BaseApplication mInstance;  
//    private static DaoMaster daoMaster;  
//    private static DaoSession daoSession;  
      
    @Override  
    public void onCreate() {  
        super.onCreate();  
        if(mInstance == null) {
        	mInstance = this;
        }
        
        BaseException baseException = BaseException.getInstance(); 
        baseException.init(getApplicationContext()); 
        
//        initDeviceID();
    }  
    
    @Override
	public void onLowMemory()
	{
		super.onLowMemory();
	}

	@Override
	public void onTerminate()
	{
		super.onTerminate();
	}
	
//	/**
//	 * 
//	 * @param context
//	 * @return
//	 */
//    public static DaoMaster getDaoMaster(Context context) {  
//        if (daoMaster == null) {  
//            OpenHelper helper = new DaoMaster.DevOpenHelper(context,Constants.DB_NAME, null);  
//            daoMaster = new DaoMaster(helper.getWritableDatabase());  
//        }  
//        return daoMaster;  
//    }  
//      
//    /** 
//     * ȡ��DaoSession 
//     *  
//     * @param context 
//     * @return 
//     */  
//    public static DaoSession getDaoSession(Context context) {  
//        if (daoSession == null) {  
//            if (daoMaster == null) {  
//                daoMaster = getDaoMaster(context);  
//            }  
//            daoSession = daoMaster.newSession();  
//        }  
//        return daoSession;  
//    }
//    
//    /**
//	 * ��������λ�豸ID
//	 */
//	public void initDeviceID() {
//		List<DeviceID> list = DbService.getInstance(this).loadAllDeviceID();
//		DeviceID deviceID = null;
//		if (list.size() == 0) {
//			deviceID = new DeviceID(null, 153, (int)(Math.random() * 255 + 1), (int)(Math.random() * 255 + 1));
//			daoSession.insert(deviceID);
//		} else {
//			deviceID = list.get(0);
//		}
//		NetworkClient.getInstance().setDeviceID(deviceID);
//	}
}
