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

public interface ICommonController<Model,PK> {
	
	@GetMapping("/getAll")
	public CommonResponse<List<Model>> getAll(@RequestParam Map<String,String> reqParams);
	public List<Model> doGetAll(Map<String,String> reqParams);

	@GetMapping("/get/{id}")
	public CommonResponse<Model> getOne(@PathVariable PK id,@RequestParam Map<String,String> reqParams);
	public Model doGetOne(PK id,Map<String,String> reqParams);
	
	@PostMapping("/create")
	public CommonResponse<Model> create(@Valid@RequestBody Model requestNode);
	public Model doCreate(Model requestNode);
	
	@PutMapping("/update/{id}")
	public  CommonResponse<Model> update(@PathVariable PK id,@RequestBody Model requestNode);
	public  Model doUpdate(PK id,Model requestNode);
	
	
	@DeleteMapping("/delete/{id}")
	public CommonResponse<Model> delete(@PathVariable PK id);
	public Model doDelete(PK id);
	
}
