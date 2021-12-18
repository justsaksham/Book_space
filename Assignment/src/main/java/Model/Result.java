package Model;

import java.util.HashMap;
import java.util.List;

public class Result{
private String result;
private String status;

private HashMap<String,List> map;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Result(){
	result="";
	map=new HashMap<String,List>();
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public HashMap<String, List> getMap() {
	return map;
}
public void setMap(HashMap<String, List> map) {
	this.map = map;
}


}
