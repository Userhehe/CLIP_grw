// 페이지가 로드될 때 jstree를 초기화합니다.
$(document).ready(function() {
	
	
	// 결재라인 모달에서 선택한 결재라인 화면에 입력하는 함수
	var payButton = document.getElementById('applyPayLine');
	payButton.addEventListener("click",
	function(){
	
		//지정된 결재라인 값들을 가져오기.
		var pickLine_div = document.getElementById('pickLine_box');
//		console.log('pickLine_div : ', pickLine_div);
		
		//전체 행 가져오기
		pick_usersList = pickLine_div.getElementsByClassName('apr_row'); 
//		console.log('pick_usersList[0] : ', pick_usersList[0]);
		
		//전체 행의 길이
		var pick_length = pick_usersList.length;
//		console.log(pick_length);
		
		var payseq = ['first','second','third'];
		
		if(pick_length <= 3 && pick_length > 0){
			let html = `<label class="badge bg-warning" >결재라인</label>
						<br/>
						<table class="table table-bordered" style="display: inline-block; vertical-align: middle;">
						<tr>`; 
						
				for(let i = 0; i<pick_length; i++){
					html += `<th>${i+1}차 결재자</th>`;
				}
				
				html += `</tr><tr>`;
				for(let i = 0; i<pick_length; i++){
					var pickUser = pick_usersList[i].querySelector('#chkPosi'); 
	//				console.log('pickUser : ', pickUser);
					var value = pickUser.getAttribute('value');
					var name = pickUser.getAttribute('name');
	//				console.log (value, name);
					html += `<td name=${payseq[i]} value= ${value}>${name}</td>`;
				}
				
				html += `</tr></table>`;
		
				//완성된 table
	//			console.log(html);	
				
				console.log(document.getElementById('selectedPayLine').innerHTML);
				
				document.getElementById('selectedPayLine').innerHTML = html;
			} 
			if(pick_length>3){
				alert('결재인은 3명까지 지정할 수 있습니다!');
				return;
			}
			if(pick_length <= 0){
				document.getElementById('selectedPayLine').innerHTML = '';
			}

			$('#paylinemodal').modal('hide');
		}
	)
	
	
	
	
	
	function paymodal(){
		
		var jstreeData = [];
		
		jstreeData.push({"id":"DEPT_1","parent":"#","text":"디자인","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_2","parent":"#","text":"설계","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_3","parent":"#","text":"공무","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_4","parent":"#","text":"시공","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_5","parent":"#","text":"영업","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_6","parent":"#","text":"관리","state":{"opened":false},"type":"parent"});
		jstreeData.push({"id":"DEPT_7","parent":"#","text":"인사","state":{"opened":false},"type":"parent"});
	
		
		$.ajax({
					url : './getTree.do',
					method : 'get',
					dataType : 'json',
					success : function(data){
						data.forEach(function(node){
							jstreeData.push({
								"id": node.user_id,
								"parent": node.dept_seq,
								"text": node.user_name+" "+node.ranks_name,
								"type" : 'leaves'
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
			plugins: ['search', 'contextmenu','types'],
			
			core : {
				check_callback: true,	//노드들에 콜백을 적용시킬 수 있게 할 것인지 말것인지 설정값 디폴트는 트루다.
				data: data
			},
			//검색 플러그인 설정 값
			search : {
							'case_insensitive': true,
							'show_only_matches': true
			},
			
			//노드의 이미지 설정...
			types : {
				'default' : {
					 'icon' : 'jstree-icon jstree-themeicon'
				},
				'parent' : {
					 'icon' : 'bx bxs-group'
				},
				'leaves' : {
					 'icon' : 'bx bxs-user'
				}
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
								+ "<span onclick='del(event)' class='bi bi-file-x-fill'></span></div><input type='hidden' name='user_id' value='"
								+sel+"'><input type='hidden' name='emp_name' value='"+newSelText+"'><input id='chkPosi' type='hidden' name='" 
								+ selText + "' value='" + $("#payLine_box").jstree().get_node(sel).original.id + "'></div>";
								
								
								//console.log($("#payLine_box").jstree().get_node(sel));
	
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
	
	$("#payModalBtn").on("click", openModal);
	
});





function del(event) {
	// 클릭된 span의 parent div
	var parentDiv = (event.target.parentNode).parentNode;
	console.log('이벤트 노드의 상위 노드 : ',parentDiv);


	//#apr_chk div 탐색
	var chkDiv = parentDiv.parentNode;
	console.log('parentDiv의 상위노드 : ',chkDiv)

	// 삭제
	parentDiv.remove();


	//#apr_chk div안에 있는 apr_row의 총 개수
	var chkDiv_len = chkDiv.querySelectorAll('.apr_row').length;
	console.log("남은 row 개수", chkDiv_len)

	//삭제한 선택 라인의 사원의 직급을 파악하는 작업
	var rankseq = ["사원", "주임", "대리", "과장", "차장", "부장", "이사", "부사장", "사장", "대표이사"];

	if (chkDiv_len !== 0) {
		
		//마지막 apr_row 탐색
		var chkDiv_last = chkDiv.querySelectorAll('.apr_row')[chkDiv_len - 1];
		
		//마지막 apr_row의 position_flag
		var chkDiv_last_p;
		chkDiv_last_p = chkDiv_last.querySelector("#chkPosi").name;
		console.log('chkDiv_last : ', chkDiv_last);
		console.log('chkDiv_last_p : ', chkDiv_last_p);
		
		//노드의 직급
		var userRank = chkDiv_last_p.substring(chkDiv_last_p.indexOf(" "),chkDiv_last_p.length).trim();
		
		//직급의 순서 번호
		var rankIndex = rankseq.indexOf(userRank);
	
	
	} else {
		//chkDiv_len이 0개일때 chkDiv_last값이 -1이 되지 않도록 chkDiv_len이 0일 때(#"apr_chk")에 아무것도 있지 않을 때 chkDiv_last_p를 0으로 만들어줌
		rankIndex = 0;
	}
	//console.log(chkDiv);
	//console.log(chkDiv_len);
	
	//취소한 노드안의 sel_apr이라는 클래스를 가진 div 탐색
	var childDiv = parentDiv.querySelector('.sel_apr')
	
	console.log(childDiv);
	
	//childDiv의 내용 저장
	var childText = childDiv.textContent
	
	
	
	//findTreeNodeByText function을 통해 childText와 같은 내용의 node 저장
	var treeNode = findTreeNodeByText(childText);
	if (treeNode) {
		var jstree = $("#payLine_box").jstree();
		var allNodes = jstree.get_json(null, { flat: true });
		
		//treeNode의 아이디로 hide 됐던 노드 다시 show 해주기
		$("#payLine_box").jstree('show_node', treeNode.id);
		
		console.log('treeNode.id : ', treeNode.id);
		
		
		
		//#apr_chk div에 있던 것들이 삭제되면 다시 #jstree에서 직급에 따라 disable된것이 enable 처리
		for (var i = 0; i < allNodes.length; i++) {
         var iNode = jstree.get_node(allNodes[i]);
         
         //결재라인 맨 마지막에 있는 녀석의 직급을 파악하고 그놈보다 높거나 같은 직급은 활성화 시키는 로직
	   	  if(iNode.parents != "#"){
				//순서 노드의 텍스트
				var iNodeText = iNode.text; 
				//텍스트에서 가져온 직급
				var iNodeRank= iNodeText.substring(iNodeText.indexOf(" "),iNodeText.length).trim();
				//직급의 순위
				var iRankIndex = rankseq.indexOf(iNodeRank);
			
				  if (iRankIndex >= rankIndex) {
		            $("#payLine_box").jstree('enable_node', iNode);
		         }
			}
			
      }
      
      
	}
}



// jsTree의 삭제할 노드의 원래 트리의 위치를 찾는 함수
function findTreeNodeByText(text) {

	var jstree = $("#payLine_box").jstree();

	//null : 첫 번째 매개변수는 가져올 노드의 ID, null을 사용하면 모든 노드를 가지고 오게 됨
	//flat : 모든 노드가 트리 구조를 유지하면서 하나의 배열에 포함 됨
	var allNodes = jstree.get_json(null, { flat: true });
	//원래의 js 트리에서의 가져온 텍스트의 노드 위치를 찾는 과정
	for (var i = 0; i < allNodes.length; i++) {
		if (allNodes[i].text === text) {
			return allNodes[i];
		}
	}
	// 노드를 찾지 못한 경우
	return null;
}

// jsTree의 초기화 버튼 기능
function clean() {
	var jstree = $("#payLine_box").jstree();
	var allNodes = jstree.get_json(null, { flat: true });//jstree를 json 형태로 전체데이터를 가져온 것
	$("#pickLine_box").html("<h4>지정된 결재인</h4><hr/>");
	//모든 노드 표시
	$("#payLine_box").jstree('show_all');
	for (var i = 0; i < allNodes.length; i++) {
		var iNode = $("#payLine_box").jstree().get_node(allNodes[i]);
		//모든 노드 enable
		$("#payLine_box").jstree('enable_node', iNode);
	}
}



//모달 띄우는 함수
var openModal = function openModal(){
//	console.log("모달 나와라~");
	$('#paylinemodal').modal('show');
	
}



