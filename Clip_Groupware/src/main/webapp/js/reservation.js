var empId = []; //참석자로 선택된 사원 배열



   //현재 날짜 및 시간 가져오기
   var now = new Date();
   var curHour = now.getHours();
   var curDate = now.toISOString().split('T')[0];

    
   //dateTimePicker 날짜-----------------------------------------
	$("#re_start").datetimepicker({
      format: "Y-m-d",
   });
   // 언어를 한국어로 변경
   $.datetimepicker.setLocale('ko');
   //input 태그 클릭시 이벤트 처리
   $("#re_start").datetimepicker({
      // 시간 선택 비활성화
      timepicker: false,
      // 0: 일요일, 6: 토요일 // 주말 선택 불가
      disabledWeekDays: [0, 6],
      // 오늘 이후 날짜만 선택 가능
      minDate: 0,
   });

   //클릭시 창활성화
   $("#re_start").datetimepicker({});
   $("#re_start_img").click(function() {
      $("#re_start").datetimepicker('show');
   });

   //dateTimePicker 시간-------------------------------------------------
      $("#re_start_time").datetimepicker({
         format: "H:00:00",
      });
  
   //input 태그 클릭시 이벤트 처리
   $("#re_start_time").datetimepicker({
      datepicker: false,
   });
   
   
   
//   //클릭시 창활성화
//   $("#re_start_time").datetimepicker({});

//   $("#re_start_time_img").click(function() {
//      $("#re_start_time").datetimepicker('show');
//   });
   
   //jstree----------------------------------------------------------
   //데이터 jstree형식으로 바꿔줌
   
   function insertAddAtt(){
   
   function convertData() {
      var jstreeData = [];
      
      jstreeData.push({"id":"DEPT_1","parent":"#","text":"디자인","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_2","parent":"#","text":"설계","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_3","parent":"#","text":"공무","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_4","parent":"#","text":"시공","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_5","parent":"#","text":"영업","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_6","parent":"#","text":"관리","state":{"opened":false}});
      jstreeData.push({"id":"DEPT_7","parent":"#","text":"인사","state":{"opened":false}});
      
      $.ajax({
					url : './selectAttendsJstree.do',
					method : 'get',
					dataType : 'json',
					
					success : function(data){
						data.forEach(function(item){
							jstreeData.push({
								"id": item.user_id,
								"parent": item.dept_seq,
								"text": item.user_name+" "+item.ranks_name,
								 "type" : 'leaves'
							});
						})
						console.log(jstreeData);
						startJstree(jstreeData);
					},
					error: function() {
						alert('jstree 로드 실패');
					}
				});
   }   
   
   
	function startJstree(data){
		//jstree 시작 
		$('#emp_box').jstree({
			//jstree 사용할 플러그인 설정
			plugins: ['search','types', 'contextmenu'], 
			
			core : {
				check_callback: true,	//노드들에 콜백을 적용시킬 수 있게 할 것인지 말것인지 설정값 디폴트는 트루다.
				data: data
			},
			
			//검색 플러그인 설정 값
			search : {
				'case_insensitive': true, //검색에 대소문자를 구분하지 않음
				'show_only_matches': true //검색어와 정확하게 일치하는 항목만 보여줌
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
			
			//우클릭 설정
			contextmenu: {
				items: function(node){
					var items ={
						rightClick:{
							label:"참석자 추가",
							action:function(){ //우클릭 이벤트 설정하기 
								// 선택된 노드의 id 가져옴
								var sel = $("#emp_box").jstree('get_selected');
								
								//선택된 노드 숨김
								$("#emp_box").jstree('hide_node', sel);
								
								//선택된 노드의 텍스트 내용을 가져옴
								var selText = $("#emp_box").jstree().get_text(sel);
								console.log('텍스트 : ',selText, '사원 아이디 : ',sel);
								
								//선택리스트 창의 구조 가져오기
								var htmlCode = $("#pickatt_box").html();
								
								//직급 없애고 이름만 추출
								var newSelText = selText.substring(0, selText.indexOf(" ")).trim();
						
								console.log("추출된 이름 :",newSelText)
								console.log("추출된 아이디 배열 :",sel)
								
								var selid =sel[0];
								console.log("selid:",selid);
								empId.push(selid);
								console.log("배열에 있는 아이디:",empId);
								
								//sel : 선택한 태그의 id,  selText : 선택한 태그위치의 텍스트
								//span 태그 이미지 태그로 바꾸기...
								//  #apr_chk div에 선택한 노드 추가
								htmlCode += "<div class='apr_row'><div class='sel_apr'>" + selText 
								+ "<span onclick='del(event)' class='bi bi-file-x-fill'></span></div><input type='hidden' name='user_id' value='"
								+sel+"'><input type='hidden' name='emp_name' value='"+newSelText+"'><input id='chkPosi' type='hidden' name='" 
								+ selText + "' value='" + $("#emp_box").jstree().get_node(sel).original.id + "'></div>";
								
								$("#pickatt_box").html(htmlCode);
								

								
//								//선택된 노드 선택 해제하기
//								$("#pickatt_box").jstree('deselect_node', sel);
							
															
							
								
								
								
							}
						}
					};
					// 비활성화된 노드에 대한 컨텍스트 메뉴 항목 비활성화
					if (node.state && node.state.disabled) {
						items.put = false;
					}
	
					var chkParent = $("#emp_box").jstree().is_parent(node);
					if (chkParent) {
						items.put = false;
					}
					
					return items;
				}
			}
						
		}); //jstree 끝
	
	
		// 트리를 처음부터 열린 상태로 보여줌
	$('#emp_box').on('ready.jstree', function() {
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
			$('#emp_box').jstree(true).search(v);
		}, 300);
	});
	
		
	}
   
   $("#reattmodal").modal("show");
   $("#reattmodalmodify").modal("show");
   convertData();  //jstree에 값을 넣어줄 데이터들 조회하는 함수를 실행하기 위함 
   
   }

 

   
   
   
   // 등록한 예약 상세보기 화면 모달창 및 값전달
   $('.re_title').click(function() {
	   var row = $(this).parent();
	   console.log("row값:",row)
	   var seq = row.find(".re_seq").text();
	   console.log("seq의 값" + seq)
   $("#timebtn")
   

      $.ajax({
      type:"get",
      url:"./reDetail.do",
      data:{seq:seq},
      dataType:"json",
      success:function(data){
		 var preTime = new Date();
         console.log("불러오기 성공.");
         $("#hiddenValue").val(data.seq);
         $("#deroomNum").val(data.roomNum);
         $("#me_room").val(data.roomNum);
     	 $("#destart").val(data.start);
//       $("#re_start").val(data.start);
         $("#deend").val(data.end);
         $("#detitle").val(data.title);
         $("#re_title").val(data.title);
         $("#decontent").val(data.content);
         $("#re_content").val(data.content);
         $("#deattlist").val(data.attends);
//       $("#count").val(data.count + "명");
         console.log("예약시간",data.start);
         
         if(preTime > new Date(data.start)){   //예약시간이 지났다면 상세보기창에서 수정, 삭제버튼을 가림 
		  console.log("if문 시작");
		  console.log("현재시간:",preTime , "예약시간:",data.start)
		  $("#timebtn").hide();
  	     }
  	      $("#redetail").modal("show");
         
      },
      error: function() {
         alert("서버요청 실패했음....");
         }
   })
   
   });
   
   
   // 참석한 예약 상세보기 화면 모달창 및 값전달
   $('.attre_title').click(function() {
   var row = $(this).parent();
   console.log("row값:",row)
   var seq = row.find(".attre_seq").text();
   console.log("seq의 값" + seq)
   
      $.ajax({
      type:"get",
      url:"./reDetail.do",
      data:{seq:seq},
      dataType:"json",
      success:function(data){
         console.log("불러오기 성공.:",data.start);
         $("#hiddenValue").val(data.seq);
         $("#attderoomNum").val(data.roomNum);
         $("#attdestart").val(data.start);
         $("#deend").val(data.end);
         $("#attdetitle").val(data.title);
         $("#attdecontent").val(data.content);
         $("#attdeattlist").val(data.attends);
//         $("#count").val(data.count + "명");
         $("#attredetail").modal("show");
      },
      
      error: function() {
         alert("서버요청 실패했음....");
         }
   })
   
   });
   


//참석자 이름 빼기
function del(event) {
	// 클릭된 span의 parent div
	var parentDiv = (event.target.parentNode).parentNode;
	console.log('이벤트 노드의 상위 노드 : ',parentDiv);


	//#apr_chk div 탐색
	var chkDiv = parentDiv.parentNode;
	console.log('parentDiv의 상위노드 : ',chkDiv)

	// 선택된 노드 삭제하기 
	parentDiv.remove();
	console.log("사원 삭제됨");


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
	console.log(chkDiv);
	console.log(chkDiv_len);
	
	
	
	//취소한 노드안의 sel_apr이라는 클래스를 가진 div 탐색
	var childDiv = parentDiv.querySelector('.sel_apr')
	
	//childDiv의 내용 저장
	var childText = childDiv.textContent;
	console.log("취소된 노드이름:",childText);
	
	//findTreeNodeByText function을 통해 childText와 같은 내용의 node 저장
	var treeNode = findTreeNodeByText(childText);
	if (treeNode) {
		var jstree = $("#emp_box").jstree();
		var allNodes = jstree.get_json(null, { flat: true });
		
		//treeNode의 아이디로 hide 됐던 노드 다시 show 해주기
		$("#emp_box").jstree('show_node', treeNode.id);
		
		//지정된 참석자에서 제외시키기
		var delId = treeNode.id
		console.log('treeNode.id : ', treeNode.id);
		empId = empId.filter(data => data!=delId);
		
		console.log("컨트롤러로 전달될 사원들", empId);	
		
		
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
		            $("#emp_box").jstree('enable_node', iNode);
		         }
			}
      }
	}
	
}

// jsTree의 삭제할 노드의 원래 트리의 위치를 찾는 함수
function findTreeNodeByText(text) {

	var jstree = $("#emp_box").jstree();

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

//// jsTree의 초기화 버튼 기능
//function clean() {
//	var jstree = $("#emp_box").jstree();
//	var allNodes = jstree.get_json(null, { flat: true });//jstree를 json 형태로 전체데이터를 가져온 것
//	$("#emp_box").html("<h4>지정된 결재인</h4><hr/>");
//	//모든 노드 표시
//	$("#payLine_box").jstree('show_all');
//	for (var i = 0; i < allNodes.length; i++) {
//		var iNode = $("#emp_box").jstree().get_node(allNodes[i]);
//		//모든 노드 enable
//		$("#emp_box").jstree('enable_node', iNode);
//	}
//
//
//
//	
//}

// 배열로 만든 id값들을 컨트롤러로 보내기
function attconfirm(){
	var seq = $("#hiddenValue").val();
	console.log("저장된 seq값",seq)
	var strEmpId = empId.join(',');
	console.log("저장된 empId 문자열", strEmpId);
	
	$.ajax({
		method:"post",
		url:"./attinsert.do",
		data:{seq:seq,id:strEmpId},
		dataType:"json",
		success:function(data){
			alert("참석자를 등록하였습니다!")
			$("#reattmodal").modal("hide");
			location.reload();
		},
		error: function() {
        	alert("서버요청 실패했음....");
        } 
		
	})
}




// 예약가능시간 조회
function selPDate() {
   var me_room = document.getElementById("me_room").value;
   var re_start = document.getElementById("re_start").value;
   
   if(re_start == ""){
	console.log(re_start);
	alert("날짜를 선택해 주세요");
	}

   $.ajax({
      type: "POST",
      url: './selectPossibleMeRoom.do',
      data: { "me_room": me_room, "re_start": re_start },
      success: function(data) {
         console.log("반환 값", data);
         if(data.length!=0){
         $("#nawarayo").show();
         data.forEach(function(item) {
            console.log(item);
         });
         
         $("#re_start_time").datetimepicker({
            allowTimes: data,
//            format: "H:00:00",
//         	minTime: 0,
         });
		}else{
			alert("회의실 예약이 불가 합니다. 다른 날짜나 회의실을 선택해 주세요")
			return false
		}
         
      }
   });
}
//예약 일 + 시간 
function reservationTime(){
   var day = document.getElementById("re_start").value;
   var time = document.getElementById("re_start_time").value;
   
   console.log("일, 시", day, time);
   document.getElementById("re_start").value = day + " " +time;
   if(time=""){
		alert("시간을 선택해 주세요")
	}
  	 $("#nawarayo").hide();
	}






//예약 취소
function delRev(){
   var result = confirm("해당 예약을 취소 하시겠습니까?")
   var seq = $("#hiddenValue").val();
   console.log("seq값:",seq);
   if(result){
      $.ajax({
         url:"./reDel.do",
         type:"get",
         data:{seq:seq},
         success:function(data){
            if(data!=0){
               location.reload();
               alert("해당 예약이 취소 되었습니다.")
            }else{
               alert("예약 취소에 실패했습니다.")
            }
         },
         error: function() {
            alert("서버요청 실패했음....");
            }
      });
   }
}


//예약수정 모달창 히든 변경하기
function modifyRev(){

	var result = confirm("현재 예약 내용을 수정 하시겠습니까?");
	if(result){
		var mohidden = document.getElementsByClassName("modifyhidden");
		var dehidden = document.getElementsByClassName("detailhidden");
			for(var i =0; i<mohidden.length; i++){
					mohidden[i].style.display = "block"
			}
			for(var i =0; i<dehidden.length; i++){
					dehidden[i].style.display = "none"
			}
				
		console.log("히든 변경됨")
	}
	
}

//예약내용 수정하기
	function modifycon(){
	
	var modify = $("#Revmodify").serialize(); //컨트롤러에서 requestparam으로 받아줘야함 
	var dateTimeRegex = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
      var me_room = $("#me_room").val();
      var re_start = $("#re_start").val();
      var re_start_time = $("#re_start_time").val();
      var re_title = $("#re_title").val();
      var re_content = $("#re_content").val();
      console.log("re_srart:",re_start)
      
       if (me_room == null || me_room == "") {
         alert("회의실을 선택하세요.");
      } else if (re_start == null || re_start == "") { 
         alert("예약일을 선택하세요.");
      } else if (re_start_time == null || re_start_time == "") { 
         alert("예약시간을 선택하세요.");
      }  else if (re_title == null || re_title == "") { 
         alert("회의 주제를 작성해주세요.");
      } else if (re_content == null || re_content == "") { 
         alert("회의 내용을 작성해주세요.");
      } else if(!dateTimeRegex.test(re_start)){
		 alert("<예약 시간 선택 완료> 버튼을 눌러주세요")
	  } else{
         datata = $("#reservationForm").serialize();

      
		$.ajax({
			url:"./reModify.do",
			type:"post",
			data:modify,
			dataType:"json",
			success:function(data){
//			alert("수정되었습니다. 확인해보소")
				var result = confirm("참석자 명단을 수정하시겠습니까?");
				if(result){
					alert("참석자가 초기화되었습니다.");
					modifyAtt();
					$("#redetail").modal("hide");
				}else{
					location.reload();
					alert("예약이 수정되었습니다.");
					$("#redetail").modal("hide");
				}
			},
			error: function() {
	            alert("서버요청 실패했음....");
	            }
		})
		}
		}


//참석자 수정 모달창 열기
function modifyAtt(){
	console.log("참여자 수정모달 오쁜");
	insertAddAtt();
}



// 배열로 만든 id값.들을 컨트롤러로 보내기 (등록, 수정 사용)
function attmodify(){
	var seq = $("#hiddenValue").val();
	console.log("저장된 seq값",seq)
	var strEmpId = empId.join(',');
	console.log("저장된 empId 문자열", strEmpId);
	
	$.ajax({
		method:"post",
		url:"./reAttModify.do",
		data:{seq:seq,id:strEmpId},
		dataType:"json",
		success:function(data){
			alert("참석자를 수정하였습니다! ヽ(✿ﾟ▽ﾟ)ノ");
			$("#reattmodal").modal("hide");
			location.reload();
		},
		error: function() {
        	alert("서버요청 실패했음....");
        } 
		
	})
}

//모달창 닫기
function redetailclose(){
   console.log("모달창 닫기")
   $("#redetail").modal("hide");
   $("#reservationModal").modal("hide");
   location.reload();
}

function attredetailclose(){
	$("#attredetail").modal("hide");
}
