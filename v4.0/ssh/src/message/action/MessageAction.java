package message.action;

import java.util.List;

import action.ActionFunction;
import dao.ProductDAO;
import pojo.Message;

public class MessageAction {
	private ProductDAO pdao;
	private ActionFunction actionFunction;
	
	private Message message;
	private List<Message> messages;
	
	private String transmitStringA;
	private String transmitStringB;
	private String transmitStringC;
	
	public String add(){
		messages = pdao.find("from Message m");
		
		if(0 == messages.size()){
			transmitStringB = "��������";
			transmitStringC = "";
		}
		else{
			transmitStringC = "����" + messages.size() + "������";
		}
		return "add";
	}
	
	public String save(){
		
		//��֤�����Ƿ�Ϊ��
		boolean verificationResult = actionFunction.verificationNull(message.getName(), message.getContent());
		if(verificationResult){
			transmitStringA = "����Ϊ��";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		//�Ƿ񳬳���������
		boolean limitNumber = actionFunction.dataLimitNumber(message.getName(), message.getContent(), 25, 800);
		if(limitNumber){
			transmitStringA = "�����쳣��";
			return "error";
		}
		else{
			transmitStringA = "";
		}
				
				
		pdao.save(message);
		
		messages = pdao.find("from Message m");
		transmitStringC = "����" + messages.size() + "������";
		return "save";
	}
	
	
	
	public void setMessages(List<Message> messages){
		this.messages = messages;
	}
	public List<Message> getMessages(){
		return messages;
	}	
	public void setMessage(Message message){
		this.message = message;
	}
	public Message getMessage(){
		return message;
	}
	
	
	public void setPdao(ProductDAO pdao){
		this.pdao = pdao;
	}
	public ProductDAO getPdao(){
		return pdao;
	}
	
	public void setActionFunction(ActionFunction actionFunction){
		this.actionFunction = actionFunction;
	}
	public ActionFunction getActionFunction(){
		return actionFunction;
	}
	
	
	
	
	public String getTransmitStringA(){
		return transmitStringA;
	}
	public void setTransmitStringA(String transmitStringA){
		this.transmitStringA = transmitStringA;
	}
	public String getTransmitStringB(){
		return transmitStringB;
	}
	public void setTransmitStringB(String transmitStringB){
		this.transmitStringB = transmitStringB;
	}
	public String getTransmitStringC(){
		return transmitStringC;
	}
	public void setTransmitStringC(String transmitStringC){
		this.transmitStringC = transmitStringC;
	}
}
