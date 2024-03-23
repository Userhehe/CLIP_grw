function openModal(){
	console.log("모달 나와라~");
	$('#paylinemodal').modal('show');
}



	//jstree 참석자-----------------------------------
		

	
	//데이터 받아오는 아작스 
	function initializeJSTree() {
		$.ajax({
			url: './selectAttendsJstree.do',
			dataType: 'json',
			success: function(data) {
				var jstreeData = convertData(data);
				
				//js 설정 시작하는 곳
				$('#selectAttendsJstree').jstree({
					'core': {
						'data': jstreeData
						//트리로 출력할 데이터
					},//코어 영역끝

					//jstree에서 사용하는 플러그인 옵션 설정
					checkbox: {
						three_state: false
						
					},
					search: {
						'case_insensitive': true,
						'show_only_matches': true
					},


					//jstree에서 사용할 플러그인들
					plugins: ["search", "checkbox"]

				});
			}//success끝나는 부분
		});//ajax끝나는 부분
	}
	//아작스 실행하는 놈
	initializeJSTree();
	
	// 검색창 글자 입력하면 나오는놈
	$('#selectAttendsJstree_search').keyup(function() {
		$('#selectAttendsJstree').jstree(true).show_all();
		$('#selectAttendsJstree').jstree('search', $(this).val());
	});
	
	
	
		//받은 데이터를 jstree형식으로 
	function convertData(data) {
		var jstreeData = [];
		data.forEach(function(item) {
			jstreeData.push({
				//컨트롤러에서 디비에서 받은 값을 json 타입으로 전환해서 줄거기 때문에 제이슨 타입의 값을 가져오는 과정....
				"id": item.user_id,
				"parent": item.dept_seq,
				"text": item.user_name+" "+item.ranks_name
			});
		});
		jstreeData.push({"id":"DEPT_001","parent":"#","text":"디자인","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_002","parent":"#","text":"설계","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_003","parent":"#","text":"공무","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_004","parent":"#","text":"시공","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_005","parent":"#","text":"영업","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_006","parent":"#","text":"관리","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_007","parent":"#","text":"인사","state":{"opened":false}});
		
		return jstreeData;
	}

	
	//jstree-----------------------------------