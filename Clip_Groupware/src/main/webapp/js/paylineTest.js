// 페이지가 로드될 때 jstree를 초기화합니다.
window.onload = function() {
	
	function paymodal(){
		
		var jstreeData = [];
		
		jstreeData.push({"id":"DEPT_001","parent":"#","text":"디자인","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_002","parent":"#","text":"설계","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_003","parent":"#","text":"공무","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_004","parent":"#","text":"시공","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_005","parent":"#","text":"영업","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_006","parent":"#","text":"관리","state":{"opened":false}});
		jstreeData.push({"id":"DEPT_007","parent":"#","text":"인사","state":{"opened":false}});
	
		
		$.ajax({
					url : './getTree.do',
					method : 'get',
					dataType : 'json',
					success : function(data){
						data.forEach(function(node){
							jstreeData.push({
								"id": node.user_id,
								"parent": node.dept_seq,
								"text": node.user_name+" "+node.ranks_name
							});
						})
						console.log(jstreeData);
						startJstree(jstreeData);
					},
					error: function() {
						alert('결재라인 로드 실패');
					}
				});
		
	}
	
	
	function startJstree(data){
		
		
		//jstree 시작 
		$('#payLine_box').jstree({
			
			//jstree의 사용할 플러그인들.
			plugins: ['search', 'contextmenu'],
			
			core : {
				check_callback: true,	//노드들에 콜백을 적용시킬 수 있게 할 것인지 말것인지 설정값 디폴트는 트루다.
				data: data
			},
			//검색 플러그인 설정 값
			search : {
							'case_insensitive': true,
							'show_only_matches': true
			},
			
			//contextmenu(우클릭?) 플러그인 설정 값
			contextmenu : {
				items: function(node) {
					var items = {
						put: {
							label: "결재자 추가",
							action: function() {	//클릭시 이벤트
								// 선택된 노드의 id 가져옴
								var sel = $("#payLine_box").jstree('get_selected');
	
								//선택된 노드 숨김
								$("#payLine_box").jstree('hide_node', sel);
	
								//선택된 노드의 텍스트 내용을 가져옴
								var selText = $("#payLine_box").jstree().get_text(sel);
								console.log('텍스트 : ',selText, '노드 : ',sel);
	
								
	
								//선택리스트 창의 구조 가져오기
								var htmlCode = $("#pickLine_box").html();
								
								
								//직급 없애고 이름만 추출
								var newSelText = selText.substring(0, selText.indexOf(" ")).trim();
								
								//sel : 선택한 태그의 id,  selText : 선택한 태그위치의 텍스트
								//span 태그 이미지 태그로 바꾸기...
								//  #apr_chk div에 선택한 노드 추가
								htmlCode += "<div class='apr_row'><div class='sel_apr'>" + selText 
								+ "</div><span onclick='del(event)' class='bi bi-file-x-fill'></span><input type='hidden' name='user_id' value='"
								+sel+"'><input type='hidden' name='emp_name' value='"+newSelText+"'><input id='chkPosi' type='hidden' name='" 
								+ selText + "' value='" + $("#payLine_box").jstree().get_node(sel).original.user_id + "'></div>";
	
								$("#pickLine_box").html(htmlCode);
	
	
	
	
								//결재라인 직급 순서 로직 
								
								var jstree = $("#payLine_box").jstree();
								
								//직급의 순서 배열
								var rankseq = ["사원", "주임", "대리", "과장", "차장", "부장", "이사", "부사장", "사장", "대표이사"];
								
								//가져온 노드의 텍스트
								var nodeText = jstree.get_node(sel).text;
								console.log(nodeText, nodeText.indexOf(" "));
								console.log(nodeText.substring(nodeText.indexOf(" "),nodeText.length).trim());
//								var userRankName = userRank.substring()
								//노드의 직급
								var userRank = nodeText.substring(nodeText.indexOf(" "),nodeText.length).trim();
								
								//직급의 순서 번호
								var rankIndex = rankseq.indexOf(userRank);
								
								
								console.log(rankIndex);
	
	
								//선택된 노드 선택 해제하기
								$("#payLine_box").jstree('deselect_node', sel);
	
								//jstree에서 트리에 있는 모든 노드의 정보를 가져와서 변수에 저장
								//null : 첫 번째 매개변수는 가져올 노드의 ID, null을 사용하면 모든 노드를 가지고 오게 됨
								//flat : 모든 노드가 트리 구조를 유지하면서 하나의 배열에 포함 됨
								var allNodes = jstree.get_json(null, { flat: true });
	
								//모든 노드와 선택된 노드의 position_flag 비교 후 disable 해줌
								for (var i = 0; i < allNodes.length; i++) {
									//트리의 노드
									var iNode = jstree.get_node(allNodes[i]);
									
									//구분 노드가 아닐 시 (리프노드일 시 )
									if(iNode.parents != "#"){
										//순서 노드의 텍스트
										var iNodeText = iNode.text; 
										//텍스트에서 가져온 직급
										var iNodeRank= iNodeText.substring(iNodeText.indexOf(" "),iNodeText.length).trim();
										//직급의 순위
										var iRankIndex = rankseq.indexOf(iNodeRank);
									
										if (iRankIndex < rankIndex) {
											$("#payLine_box").jstree('disable_node', iNode);
										}
									}
								}
							}
						}
					};
					// 비활성화된 노드에 대한 컨텍스트 메뉴 항목 비활성화
					if (node.state && node.state.disabled) {
						items.put = false;
					}
	
					var chkParent = $("#payLine_box").jstree().is_parent(node);
					if (chkParent) {
						items.put = false;
					}
					
					return items;
				}
				
			}
			
			
			
		});
	
	
	
	
		// 트리를 처음부터 열린 상태로 보여줌
	$('#payLine_box').on('ready.jstree', function() {
		$(this).jstree('open_all');
	});


	//search 플러그인 설정
	var searchTimer;

	$('#search_input').keyup(function() {
		// 이전에 설정된 타이머가 있다면 클리어
		clearTimeout(searchTimer);

		// 300 밀리초 후에 검색 수행
		searchTimer = setTimeout(function() {
			var v = $('#search_input').val().trim();
			$('#payLine_box').jstree(true).search(v);
		}, 300);
	});
	
		
	}
	
	paymodal();
	
	
	
};



function del(event) {
	// 클릭된 span의 parent div
	var parentDiv = event.target.parentNode;


	//#apr_chk div 탐색
	var chkDiv = parentDiv.parentNode;
	console.log(chkDiv)

	// 삭제
	parentDiv.remove();


	//#apr_chk div안에 있는 apr_row의 총 개수
	var chkDiv_len = chkDiv.querySelectorAll('.apr_row').length;
	console.log("남은 row 개수", chkDiv_len)



	if (chkDiv_len !== 0) {
		//마지막 apr_row 탐색
		var chkDiv_last = chkDiv.querySelectorAll('.apr_row')[chkDiv_len - 1];
		
		//마지막 apr_row의 position_flag
		var chkDiv_last_p;
		chkDiv_last_p = chkDiv_last.querySelector("#chkPosi").value;
	} else {
		//chkDiv_len이 0개일때 chkDiv_last값이 -1이 되지 않도록 chkDiv_len이 0일 때(#"apr_chk")에 아무것도 있지 않을 때 chkDiv_last_p를 0으로 만들어줌
		chkDiv_last_p = 0;
	}
	//console.log(chkDiv);
	//console.log(chkDiv_len);
	//console.log(chkDiv_last);
	//console.log(chkDiv_last_p);
	
	
	//sel_apr이라는 클래스를 가진 div 탐색
	var childDiv = parentDiv.querySelector('.sel_apr')
	
	//childDiv의 내용 저장
	var childText = childDiv.textContent
	
	//findTreeNodeByText function을 통해 childText와 같은 내용의 node 저장
	var treeNode = findTreeNodeByText(childText);
	if (treeNode) {
		var jstree = $("#jstree").jstree();
		var allNodes = jstree.get_json(null, { flat: true });
		
		//treeNode의 아이디로 hide 됐던 노드 다시 show 해주기
		$("#jstree").jstree('show_node', treeNode.id);
		
		//#apr_chk div에 있던 것들이 삭제되면 다시 #jstree에서 직급에 따라 disable된것이 enable 처리
		for (var i = 0; i < allNodes.length; i++) {
         var iNode = jstree.get_node(allNodes[i]);
         var iPosition_flag = parseInt(iNode.original.position_flag);
         if (iPosition_flag >= chkDiv_last_p) {
            $("#jstree").jstree('enable_node', iNode);
         }
      }
	}
}

function findTreeNodeByText(text) {

	var jstree = $("#jstree").jstree();

	//null : 첫 번째 매개변수는 가져올 노드의 ID, null을 사용하면 모든 노드를 가지고 오게 됨
	//flat : 모든 노드가 트리 구조를 유지하면서 하나의 배열에 포함 됨
	var allNodes = jstree.get_json(null, { flat: true });
	for (var i = 0; i < allNodes.length; i++) {
		if (allNodes[i].text === text) {
			return allNodes[i];
		}
	}
	// 노드를 찾지 못한 경우
	return null;
}

// 초기화 버튼 기능
function clean() {
	var jstree = $("#jstree").jstree();
	var allNodes = jstree.get_json(null, { flat: true });
	$("#apr_chk").html("");
	//모든 노드 표시
	$("#jstree").jstree('show_all');
	for (var i = 0; i < allNodes.length; i++) {
		var iNode = $("#jstree").jstree().get_node(allNodes[i]);
		//모든 노드 enable
		$("#jstree").jstree('enable_node', iNode);
	}
}




function openModal(){
	console.log("모달 나와라~");
	$('#paylinemodal').modal('show');
}