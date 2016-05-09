package service;

import java.rmi.Remote;

//1.创建远程方法接口，里面有想要的方法，必须throws RemoteException 
import java.rmi.RemoteException;
public interface IOService extends Remote{
	public boolean writeFile(String file, String userId, String fileName)throws RemoteException;
	
	public String readFile(String userId, String fileName)throws RemoteException;
	
	public String readFileList(String userId)throws RemoteException;
}
