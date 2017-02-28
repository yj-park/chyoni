/**
 * 
체크해야할 객체, 보여줄 메세지 내용이 달라짐
 */

function isEmpty(obj, msg) {
	
	if (obj.value == "") {
		alert(msg);
		obj.focus(); 
		return true;
	}
	return false;
}

