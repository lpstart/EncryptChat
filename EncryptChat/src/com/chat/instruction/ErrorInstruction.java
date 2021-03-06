package com.chat.instruction;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
/**
 * 18 Sep Chat System Project Yu XIAO yxiao1 616882<br/>
 *	The instruction is used to convey error message
 */
public class ErrorInstruction extends Instruction {
	private String error = "";
	@Override
	public String Type() {
		return Instruction.ERROR;
	}

	public ErrorInstruction() {
	}

	public ErrorInstruction(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String ToJSON() {
		JSONObject jo = new JSONObject();
		jo.put("type", Type());
		jo.put("error", error);
		return jo.toJSONString();
	}

	@Override
	public void FromJSON(String jst) {
		JSONObject jo = null;
		try {
			jo = (JSONObject)parser.parse(jst);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(jo!=null){
			error = (String)jo.get("error");
		}
	}

}
