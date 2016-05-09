//请不要修改本文件名
package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

//2.创建远程方法接口实现类
public class ExecuteServiceImpl implements ExecuteService {

	/**
	 * 请实现该方法
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		String result="";
		char[] c=new char[code.length()];//保存每次运算的结果
		char[] codes = code.toCharArray();//保存bf代码
		char[] input =null;//保存输入的内容,注意换行的问题'\n'
		int[] instruction=new int[code.length()];//保存'['的位置
		if (param != null) {
			input = param.toCharArray();
		}
		for(int i=0,j=0,k=0,m=0,n=0;i<code.length();i++){
			switch (codes[i]) {
			case '+':
				c[j]++;
				break;
			case '-':
				c[j]--;
				break;
			case '>':
				j++;
				break;
			case '<':
				j--;
				break;
			case ',':
				c[j]=input[k];
				k++;
				break;
			case '.':
				result+=c[j];
				break;
			case '[':
				if (c[j]!=0){
					instruction[m]=i-1;
					m++;
				}else {
					for(n=1;(n>0)&&((i+1-code.length())>0);i++){
						if (codes[i]=='['){
							n++;
						}else if (codes[i]==']'){
							n--;
						}
					}
				}
				break;
			case ']':
				if (c[j]!=0){
					m--;
					i=instruction[m];
				}else{
					m--;
				}
				break;
			default:
				result="Wrong!";
				break;
			}
		}	
	 return result;
	}

}
