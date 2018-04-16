package com.fet.expressnote.framework.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fet.expressnote.framework.dto.CommonResponse;
import com.fet.expressnote.framework.exception.CommonException;

import lombok.extern.java.Log;
/**
 * 提供開發者迅速實作crud
 * @author equalhsiao
 *
 * @param <T>
 * @param <PK>
 */
@Log
public abstract class CommonController<T,PK> implements ICommonController<T,PK> {
	
	protected CommonResponse<T> resp;
	protected CommonResponse<List<T>> response;
	protected Object udpateType;
	@Override
	public abstract List<T> doGetAll(Map<String,String> allRequestParams);
	@Override
	@GetMapping("/getAll")
	public  CommonResponse<List<T>> getAll(@RequestParam Map<String,String> allRequestParams){
		try{
			log.info("getAll:"+allRequestParams);
			response = new CommonResponse<List<T>>();
			response.setData(doGetAll(allRequestParams));
		}catch(Exception e){
			errorHandler("getAll",e);
		}
		return response;
	}
	
	//直接實作hibernate單筆查詢
	@GetMapping("/query/{id}")
	public CommonResponse<T> query(@PathVariable PK id){
		try{
			resp = new CommonResponse<T>();
			//resp.setData(Hibernate<T,PK>.query());
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	//提供給開發者快速實作使用
	@Override
	public abstract T doGetOne(PK id,Map<String,String> reqParams);
	@Override
	@GetMapping("/get/{id}")
	public CommonResponse<T> getOne(@PathVariable PK id,@RequestParam(required=true) Map<String,String> reqParams){
		try{
			log.info("getOne:"+reqParams);
			resp = new CommonResponse<T>();
			resp.setData(doGetOne(id,reqParams));
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	
	//直接實作hibernate新增
	@PostMapping("/inert")
	public CommonResponse<T> insert(@Valid@RequestBody T request){
		try{
			resp = new CommonResponse<T>();
			//resp.setData(Hibernate<T,PK>.insert());
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	//提供給開發者快速實作使用
	@Override
	public abstract T doCreate(T requestNode);
	@Override
	@PostMapping("/create")
	public CommonResponse<T> create(@Valid@RequestBody T requestNode){
		try{
			log.info("create:"+requestNode);
			resp = new CommonResponse<T>();
			resp.setData(doCreate(requestNode));
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	//直接實作hibernate更新
	@PostMapping("/modify/{id}")
	public CommonResponse<T> modify(@PathVariable PK id,@RequestBody T request){
		try{
			resp = new CommonResponse<T>();
			//resp.setData(Hibernate<T,PK>.update());
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	//提供給開發者快速實作使用
	@Override
	public  abstract T doUpdate(PK id,T requestNode);
	@Override
	@PutMapping("/update/{id}")
	public  CommonResponse<T> update(@PathVariable PK id,@RequestBody T requestNode){
		try{
			log.info("update:"+requestNode);
			resp = new CommonResponse<T>();
			resp.setData(doUpdate(id,requestNode));
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	
	//直接實作hibernate刪除
	@DeleteMapping("/remove/{id}")
	public CommonResponse<T> remove(@PathVariable PK id){
		try{
			resp = new CommonResponse<T>();
//			resp.setData(Hibernate<T,PK>.delete(id));
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	//提供給開發者快速實作使用
	@Override
	public abstract T doDelete(PK id);
	@DeleteMapping("/delete/{id}")
	public CommonResponse<T> delete(@PathVariable PK id){
		try{
			resp = new CommonResponse<T>();
			resp.setData(doDelete(id));
		}catch(Exception e){
			e.printStackTrace();
			errorHandler(null,e);
		}
		return resp;
	}
	
	 //共用錯誤處理
    public void errorHandler(String type,Exception ex) {
        try{
            throw ex;
        } catch (Exception exception) {
        	exception.printStackTrace();
            if (exception instanceof CommonException) {
            	System.out.println("系統內部錯誤");
                CommonException commonEx = (CommonException) exception;
                if("getAll".equals(type)){
	                response.setRc(commonEx.getErrorCode());
	                response.setRm(commonEx.getErrorMessage());
                }else{
                	resp.setRc(commonEx.getErrorCode());
	                resp.setRm(commonEx.getErrorMessage());
                }
            } else {
            	if("getAll".equals(type)){
            		response.setRc("9999");
            		response.setRm("系統錯誤:" + exception.getMessage());
            	}else{
            		System.out.println(resp);
                    resp.setRc("9999");
                    resp.setRm("系統錯誤:" + exception.getMessage());
            	}
            	
            }
        }
    }
}
