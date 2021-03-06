package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Goods;
import service.GoodsService;

public class GoodsAction extends ActionSupport {
	private GoodsService goodsService;
	private Map<String,Object> session;
	private int id;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public String getCatalog() throws Exception{
		List result = goodsService.getCatalog();
		if(result != null && result.size() != 0){
			session = ActionContext.getContext().getSession();
			session.put("catalog",result);
			
			return "success";
		}
		else{
			return "error";
		}
		
	}
	
	public String getGoodDetail(){
		Goods result = goodsService.getGoods(id);
		if(result != null ){
			session = ActionContext.getContext().getSession();
			session.put("goods",result);
			
			return "success";
		}
		else{
			return "error";
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
