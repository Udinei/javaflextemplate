package com.myorg.business.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.business.entitys.AppTest;
import com.myorg.business.repositorys.AppTestDAO;

@Service(value = "appTestService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AppTestServiceImpl  implements AppTestService {
	
	private AppTestDAO appTest;
	private Integer totalRegistros; 

	@Autowired
	public void setAppTest(AppTestDAO appTest) {
		this.appTest = appTest;
	}

	public AppTest save(AppTest appTest) throws Exception {
		try {
			this.appTest.save(appTest);
			return appTest;
		} catch (Exception e) {
			throw new Exception("Não foi possível salvar." + e.getCause());
		}
	}

	public void remove(AppTest appTest) throws Exception {
		try {
			this.appTest.remove(appTest);
		} catch (Exception e) {
			throw new Exception("Não foi possível excluir." + e.getMessage());
		}
	}

	public AppTest findById(AppTest appTest) throws Exception {
		try {
			return this.appTest.findById(appTest);
		
		} catch (Exception e) {
			throw new Exception("Não foi possível procurar pela ID." +e.getMessage());
		}
	}

	public List<AppTest> getList() throws Exception {
		try {
			
			 //obtem qtd de registros
			 totalRegistros = appTest.getTotalRegistros();
			return this.appTest.getList();
			
		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}

	public List<AppTest> getSearch(AppTest appTest) throws Exception{
		try {
			return this.appTest.getSearch(appTest);
			
		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}

	@Override
	public ArrayList listPaginacao(int firstResult, int maxResults) throws Exception {
		
		try{
			
		   //return this.listPaginacao(firstResult, maxResults);
			 totalRegistros = getList(firstResult, maxResults).size();
		     return getList(firstResult, maxResults);
		}catch(Exception e){
			throw new Exception("Não foi possivel listar " + e.getMessage());
		}
	}
	

	public ArrayList getList(int firstResult, int maxResults) throws Exception {
		try {
			return this.appTest.getList(firstResult, maxResults);
			
		} catch (Exception e) {
			throw new Exception("Não foi possível listar." + e.getMessage());
		}
	}
	
	public String getTotalRegistros() throws Exception {
		return  totalRegistros.toString();
	}
	

}