//需要客户端的stub
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

//1.创建远程方法接口，里面有想要的方法，必须throws RemoteException 
public interface UserService extends Remote{
	public boolean login(String username, String password) throws RemoteException;

	public boolean logout(String username) throws RemoteException;
}
