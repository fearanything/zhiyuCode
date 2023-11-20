<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	//获取统计总数的数据
	function dangerAll(ORG_CODE) {
		let data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/dangerAll.do",
			data: {"ORG_CODE": ORG_CODE},
			type: "POST",
			dataType: "json",
			async: false,
			success: function(res){
				console.log("ORG_CODE",ORG_CODE)
				data = res;
			},
		})
		return data;
	}

	// 获取隐患整改统计
	function dangerComplete(ORG_CODE, dayNum) {
		let data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/dangerComplete",
			data: {"ORG_CODE": ORG_CODE,"dayNum": dayNum},
			type: "POST",
			text: "json",
			async: false,
			success: function(res){
				console.log("mapper返回的数据123:",res)
				data = res;
			},
		})
		return data;
	}

	// 获取隐患整改统计
	function tongjiByStage(ORG_CODE) {
		debugger;
		let data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/tongjiByStage",
			data: {"ORG_CODE": ORG_CODE},
			type: "POST",
			text: "json",
			async: false,
			success: function(res){
				console.log("mapper返回的数据:",res)
				data = res;
			},
		})
		return data;
	}
	
	// 根据隐患类别统计
	function classifyComplete(ORG_CODE) {
		let data = '';
		console.log("123")
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/classifyComplete.do",
			data: {"ORG_CODE": ORG_CODE},
			type: "POST",
			text: "json",
			async: false,
			success: function(res){
				data = res;
			},
		})
		return data;
	}

	// 按隐患因素统计
	function factorComplete(ORG_CODE) {
		let data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/factorComplete.do",
			data: {"ORG_CODE": ORG_CODE},
			type: "POST",
			dataType: "json",
			async: false,
			success: function(res){
				data = res;
			},
		})
		return data;
	}
	
	// 获取二级单位隐患情况，隐患总数mark123
	function erjiComplete() {
		let data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/erjiComplete.do",
			// data: {"ORG_CODE": ORG_CODE},
			type: "GET",
			dataType: "json",
			async: false,
			success: function(res){
				data = res;
			},
		})
		return data;
	}

	//获取机构名称
	function getCompanyName(ORG_CODE){

		var data = '';
		$.ajax({
			url: "<%=basePath%>hkSafeFrontend/getCompanyName.do",
			data: {"ORG_CODE": ORG_CODE},
			type: "POST",
			dataType: "json",
			async: false,
			success: (res) => {

				data = res;
			}
		})
		return data;
	}

</script>