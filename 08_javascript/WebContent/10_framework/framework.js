/**
 * jquery.js 라이브러리의 일부 기능을 구현해본다.
 */
//mlec이라는 함수에 어떤 val를 받으면
function mlec(val) {
	
	// 0번째에 있는 글자를 가져와
	var ch = val.charAt(0);
	console.log("val tabName", val.substring(1, val.length -1));
	console.log("ch", ch);
	var elements;
	switch (ch) {
		case "<":
			elements = document.createElement(val.substring(1, val.length -1));
			// 태그만 새로 만들었고 연결 X
			break;
		case "#":
			elements = document.querySelector(val);
			break;
		default:
			elements = document.querySelectorAll(val);
			break;
	}
	/*
	var pArr = document.querySelector("p");
	for (var i = 0; i < pArr.length; i++) {
		pArr[i].innerHTML = "동적변경";
	}
	
	$("p").html("동적변경"); 
	*/
	
	// 엘리먼트에 html 함수를 추가할게. 그리고 이 함수를 호출할 때 html이라는 매개변수(->"동적변경")를 받아올 수 있어
	elements.html = function (html) {
		if(this.length) {
			// 값이 넘어왔다면 설정
			if (html != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = html;
				}
				return this;
			} // 값이 undefined 존재하진 않는다면 추출
			return this[0].innerHTML;
		} else {
			if (html != undefined) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		} 
	};
	
// 속성만 text로 바뀐 것!

	elements.text = function (text) {
		if(this.length) {
			// 값이 넘어왔다면 설정
			if (text != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = text;
				}
				return this;
			} // 값이 undefined 존재하진 않는다면 추출
			return this[0].innerText;
		} else {
			if (text != undefined) {
				this.innerText = text;
				return this;
			}
			return this.innerText;
		} 
	};

	elements.val = function (value) {
	
		if(this.length) {
			// 값이 넘어왔다면 설정
			if (value != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].value = value;
				}
				return this;
			} // 값이 undefined 존재하지 않는다면 추출
			return this[0].value;
		} 
		else {
			if (value != undefined) {
				this.value = value;
				return this;
			}
			return this.value;
		} 
	};
	
	elements.attr = function (key, value) {
		// key가 {} 형태인 경우의 처리
		// key가 object인 경우 value 매개변수는 존재하지 않는다. 설정파트만 존재 (즉, 추출 X)
		// {"mymsg": "aaa"}, {"title", "연습중ㅋㅋ"}
		if (typeof(key) == "object") {
			if (this.length) {
				for (var i = 0; i < this.length; i++) {
					for (var k in key) {
						this[i].setAttribute(k, key[k]);
					}
				}
				return this;
			} 
			else {
				// 동적 코딩을 해야해 -> 어떻게?
				// key라는 객체 안에 있는 key값(ex:mymsg랑 title)을 k로 넘겨줌
				for (var k in key) {
					this.setAttribute(k, key[k]);
				}
				return this;
			}
		}	
		else {
			if(this.length) {
				// 값이 넘어왔다면 설정
				if (value != undefined) {
					for (var i = 0; i < this.length; i++) {
						this[i].setAttribute(key, value);
					}
					return this;
				} // 값이 undefined 존재하지 않는다면 추출
			return this[0].getAttribute(key);
			} 
			else {
				if (value != undefined) {
					this.setAttribute(key, value);
					return this;
				}
			return this.getAttribute(key);
			} 
		}
	};
	
	
	elements.css = function (key, value) {
		if (typeof(key) == "object") {
			if (this.length) {
				for (var i = 0; i < this.length; i++) {
					for (var k in key) {
						this[i].style[k] = key[k];
					}
				}
				return this;
			} 
			else {
				for (var k in key) {
					this.style[k] = key[k];
				}
				return this;
			}
		}	
		else {
			if(this.length) {
				if (value != undefined) {
					for (var i = 0; i < this.length; i++) {
						this[i].style[key] = value;
					}
					return this;
				}
				// 추출
				return this[0].style[key];
			} 
			else {
				if (value != undefined) {
					this.style[key] = value;
					return this;
				}
				return this.style[key];
			} 
		}
	};
	
	
	elements.append = function (childEle) {
		if(this.length) {
			// 값이 넘어왔다면 설정
			if (html != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].appendChild(childEle);
				}
				return this;
			} // 값이 undefined 존재하진 않는다면 추출
			return this[0].innerHTML;
		} else {
				this.appendChild(childEle);
				return this;
			}
	};
	
	elements.on = function (eventType, callback) {
		
		if(this.length) {
			for (var i = 0; i < this.length; i++) {
				this[i].addEventListener(eventType, callback);
			}
			return this;
		} 
		else {
			this.addEventListener(eventType, callback);
			return this;
		}
	};
	
	return elements;
}
	
	/*
	var msg = document.querySelector("#msg");
	var h1Obj = document.querySelectorAll("h1");
	var h1Obj = document.querySelectorAll("cMsg");
	
	var msg = mlec("#msg"); 
	var h1Obj = mlec("h1");
	var h1Obj = mlec(".cMsg");
	
	0번째 글자가 #이면 querySelector를 해서 element에 담아서 반환해줄게
	#외 나머지는 querySelectorAll할거야 
	*/

// 전역변수 선언은 var를 사용하여!
// $랑 _는 변수명으로 사용할 수 있는 특수문자야

//mlec을 $로 대체할게! 
var $ = mlec; 

