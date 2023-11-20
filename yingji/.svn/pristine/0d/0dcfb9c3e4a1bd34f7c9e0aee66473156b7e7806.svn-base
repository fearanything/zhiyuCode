//基本校验-非空校验  
function valNull(value) {
	if (value == "") {
		return false;
	} else
		return true;
}

//基本校验-特殊字符校验  
function valSpecail(value) {
	var exp = /[\!\@\#\$\%\^\&\*~<>',\.]/;
	if (exp.test(value)) {
		return false;
	} else
		return true;
}

//基本校验-长度验证  
function valLen(value, len) {
	if (value.length > len) {
		return false;
	} else
		return true;
}

//基本校验 数字  
function valNum(value) {
	var ext = /^([0-9]|[1-9][0-9]*)$/;
	if (!ext.test(value)) {
		return false;
	} else
		return true;
}

//基本校验 小数  
function valDou(value) {
	var ext = /^[0-9]+(.[0-9]{1,3})?$/;
	if (!ext.test(value)) {
		return false;
	} else
		return true;
}

//BigDecimal两位小数的校验 123.00
function valDecimal(value) {
	var ext = /^([0-9]{1}|[1-9]{1}[0-9]*)(.[0-9]{1,2})?$/;
	if (ext.test(value)) {
		return true;
	} else {
		return false;
	}
}

//身份证号码校验
function idCard(value) {
	var ext = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
	if (ext.test(value)) {
		return true;
	} else {
		return false;
	}
}

//基本验证 电话 - 座机  
function valTel(value, name) {
	//座机      
	var exp1 = /^\d{3,4}-\d{7,8}(-\d{3,5})*$/;
	if (exp1.test(value))
		return true;
	return false;
}

//基本校验 手机  
function valMob(value) {
	//手机  
	var exp2 = /^1[3|4|5|6|7|8|9][0-9]\d{8}$/;
	if (exp2.test(value))
		return true;
	return false;
}

//邮编  
function postCodeVal(value, name, isNull) {
	//是否为空  
	if (isNull && value.length == 0)
		return true;
	//非空  
	if (!valNull(value, name))
		return false;

	var exp = /^\d{6}$/;
	if (!exp.test(value)) {
		return false;
	} else
		return true;
}

//字符串校验  
function strValSp(value, name, len, isNull) {
	//特殊字符  
	if (!valSpecail(value, name))
		return false;
	if (!strVal(value, name, len, isNull))
		return false;
	return true;
}

//字符串校验 不含特殊字符检测  
function strVal(value, name, len, isNull) {
	//是否为空  
	if (isNull && value.length == 0)
		return true;
	//非空  
	if (!valNull(value, name))
		return false;
	//长度   
	if (!valLen(value, name, len))
		return false;
	return true;
}

//邮件验证  
//isNull是否可以为空：true是  
function mailVal(value, name, len, isNull) {
	//是否为空  
	if (isNull && value.length == 0)
		return true;
	//非空  
	if (!valNull(value, name))
		return false;
	//长度   
	if (!valLen(value, name, len))
		return false;

	//邮件格式  
	var exp = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if (!exp.test(value)) {
		return false;
	}

	return true;
}

//数字校验：type:0正整数,1正小数  
function numberVal(value, name, len, isNull, type) {
	//是否为空  
	if (isNull && value.length == 0)
		return true;

	//验证非空  
	if (!valNull(value, name))
		return false;

	//长度   
	if (!valLen(value, name, len))
		return false;

	//格式  
	if (type == 0)
		return valNum(value, name);
	else
		return valDou(value, name);
}

//电话校验：type:0座机,1手机  
function telVal(value, name, isNull, type) {
	//是否为空  
	if (isNull && value.length == 0)
		return true;

	//验证非空  
	if (!valNull(value, name))
		return false;

	if (type == 0)
		return valTel(value, name);
	else if (type == 1)
		return valMob(value, name);
	else
		return false;

}

//判断是否是中文  
function isChinese(temp) {
	var re = /[^\u4e00-\u9fa5]/;
	return re.test(temp);
}

//输入时数字判断  
function isNumber() {
	if (event.keyCode <= 57 && event.keyCode >= 48)
		return true;
	else
		return false;
}

//验证含有汉字的字符串长度（一个汉字为2个字节）  
function checkLength(val, info, length, isChinese) {
	//特殊字符  
	if (!valSpecail(val, info))
		return false;
	var count = val.length;
	var num = 0;
	if (isChinese) {
		num = length / 2;
	} else {
		num = length;
	}
	var Expression = /^[\u0391-\uFFE5]+$/;
	var objExp = new RegExp(Expression);
	if (count > num) {
		return false;
	} else {
		return true;
	}
}
//验证输入的内容中是否含有汉字  
function checkChinese(val, info, length, isChinese, isNull) {
	if (!isNull) {
		if (val == '') {
			return false
		}
	}
	//特殊字符  
	if (!valSpecail(val, info))
		return false;
	//在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号  
	var Expression = /^[\u0391-\uFFE5]+$/;
	var objExp = new RegExp(Expression);
	//如果允许有汉字  
	if (isChinese) {
		//验证含有汉字的字符串长度（一个汉字为2个字节）  
		return checkLength(val, info, length, isChinese);
	} else {
		//如果不允许有汉字  
		for (var i = 0; i < val.length; i++) {
			if (objExp.test(val.charAt(i)) == true) {
				alert(info + "不允许有中文！");
				return false;
			}
		}
		return checkLength(val, info, length, isChinese);
	}
}