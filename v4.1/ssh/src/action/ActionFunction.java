package action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.ProductDAO;
import pojo.Data;
import pojo.DataBackups;

public class ActionFunction {
	private ProductDAO pdao;
	
	//������ʽ��֤
	public boolean verificationNonChar(String verifyName){
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		Matcher matcher = pattern.matcher(verifyName);
		boolean verifyResult= matcher.matches();
		
		return verifyResult;
	}
	
	public boolean saveData(Data data){
		List<Data> datas = pdao.find("from Data d where d.name=? ", data.getName());
		if(datas.size() >= 1){
			return false;
		}
		
		pdao.save(data);
		
		DataBackups d = new DataBackups();
		
		d.setType(data.getType());
		d.setName(data.getName());
		d.setContent(data.getContent());
		
		pdao.save(d);
		
		return true;
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean verificationNull(String name, String content){
		if(0 == name.length() || null == name){
			return true;
		}
		
		if(0 == content.length() || null == content || content.equals("����д")){
			return true;
		}
		return false;
	}
	
	//����������С
	public boolean dataLimitNumber(String name, String content, int n, int c){
		if(name.length() < n){
			return true;
		}
		
		if(content.length() < c){
			return true;
		}
		
		
		return false;
	}
	
	
	public ProductDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductDAO pdao) {
		this.pdao = pdao;
	}
}
