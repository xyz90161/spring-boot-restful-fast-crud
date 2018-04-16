package com.fet.expressnote.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fet.expressnote.dto.FareastoneNoteDto;
import com.fet.expressnote.framework.controller.CommonController;
import com.fet.expressnote.framework.exception.ExpressPrintException;
import com.fet.expressnote.framework.exception.ExpressPrintException.ExpressPrintEnum;
import com.fet.expressnote.service.MockService;

@RestController
@RequestMapping(value="/print")
public class ExpressPrintController extends CommonController<FareastoneNoteDto,Long>{
	
	@Autowired
	private MockService mockService;
	
	
	@Override
	public List<FareastoneNoteDto> doGetAll(Map<String,String> parameters) {
		String startDate = parameters.get("startDate");
		String endDate = parameters.get("endDate");
		String userId = parameters.get("userId");
		String preExpressDate = parameters.get("PreExpressDate");
		
        if(startDate == null && endDate== null && userId== null && preExpressDate== null){
        	throw new ExpressPrintException(ExpressPrintEnum.OPTIONAL_MUST_ONE_ERROR);
        }
        if((startDate== null && endDate== null) || (endDate== null && startDate== null)){
        	throw new ExpressPrintException(ExpressPrintEnum.APPLYDATE_NULL_ERROR);
        }
		return mockService.getAllNotes();
	}
	
	@Override
	public FareastoneNoteDto doGetOne(Long id, Map<String,String> reqParams) {
		return mockService.getOneNotes();
	}


	@Override
	public FareastoneNoteDto doCreate(FareastoneNoteDto requestNode) {
		// TODO Auto-generated method stub
		return mockService.getOneNotes();
	}

	@Override
	public FareastoneNoteDto doUpdate(Long id,FareastoneNoteDto requestNode) {
		// TODO Auto-generated method stub
		return mockService.getOneNotes();
	}

	@Override
	public FareastoneNoteDto doDelete(Long id) {
		// TODO Auto-generated method stub
		return mockService.getOneNotes();
	}


}
