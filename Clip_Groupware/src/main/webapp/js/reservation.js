$(document).ready(function() {
   //리스트로 만든 참석자와 최신예약 시퀀스값넘기기   
   var selempval=[]; //참석자 배열
   
   $("#attChoice").on("click", function() {
   var attends = "";
   for(var i = 0; i<selempval.length; i++){ //참석자 리스트에 , 찍기
      attends += selempval[i];
      if(i < selempval.length-1){
         attends +=",";
      }
   }
   
   var seq =  $('#hiddenValue').val();
    //console.log("넘어가라:", attends, seq);
    $.ajax({
        url: "./attinsert.do",
        type: "POST",
        data: { id: attends, seq: seq },
        dataType: "json",
        success: function(data) {
			if(data!=null){
				console.log("전달받은 data", data);
				$("#reAttModal").modal("hide");
           		alert("참석자가 등록되었습니다.");
           		location.reload();
			}else{
				alert("참석자 등록 실패");	
			}
            
        },
        error: function() {
            alert("서버 에러");
        }
       });
   });
   //현재 날짜 및 시간 가져오기
   var now = new Date();
   var curHour = now.getHours();
   var curDate = now.toISOString().split('T')[0];

    
   //dateTimePicker 날짜-------------------------------------------------
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
         format: "H:00",
      });
   //input 태그 클릭시 이벤트 처리
   $("#re_start_time").datetimepicker({
      datepicker: false,
   });

   //클릭시 창활성화
   $("#re_start_time").datetimepicker({});

   $("#re_start_time_img").click(function() {
      $("#re_start_time").datetimepicker('show');
   });
   
   
   //데이터 jstree형식으로 바꿔줌
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
						alert('결재라인 로드 실패');
					}
				});
   }   
   
   
   //jstree 설정 ----------
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
   
   convertData();  //jstree에 값을 넣어줄 데이터들 조회하는 함수를 실행하기 위함 
   
   
      
//      data.forEach(function(item) {
//         jstreeData.push({
//            "id": item.user_id,
//            "parent": item.dept_seq,
//            "text": item.user_name+" "+item.ranks_name,
//            "type" : 'leaves'
//         });
//      });
//      
//      
//      return jstreeData;
//   }
//   
//   
//   //jstree 결과가 
//   function initializeJSTree() {
//      $.ajax({
//         url: './selectAttendsJstree.do',
//         dataType: 'json',
//         success: function(data) {
//            var jstreeData = convertData(data);
//            $('#selectAttendsJstree').jstree({
//               'core': {
//                  'data': jstreeData,
//                  'check_callback':true
//               },//코어 영역끝
//               checkbox: {
//                  three_state: false
//               },
//               search: {
//                  'case_insensitive': true,
//                  'show_only_matches': true
//               },
//
//               plugins: ["search", "checkbox","contextmenu"]
//            });
//         }/*success 끝*/
//      });/*ajax 끝*/
//   }
//   
//   
//   //아작스 실행하는 놈
//   initializeJSTree();
   

   


function insertAddAtt(){   
   $("#reAttModal").modal("show");
      //select_node.jstree 이벤트 핸들링
      var txtarea = $("#addemp"); //선택한 사원의 정보가 보이는곳
      var selemptxt=[]; //jsp에 보이는 값
//      var selempval=[]; //db에 전달될 값
      var seq=$("#hiddenValue").val();
      
      $('#selectAttendsJstree').on('select_node.jstree', function(e, data) {
          if (!data.node.id.includes('DEPT')) { // 부서의 정보가 전달되는 것을 방지
              var selemp = data.node.text; // 화면에 보일 사원정보
              var selempid = data.node.id; // 컨트롤러로 보낼 사원정보
              selemptxt.push(selemp);
              selempval.push(selempid);
              
             console.log("선택한 사원정보:",selemp);
             console.log("선택한 사원정보 배열:",selemptxt);
             console.log("선택한 사원id 배열:",selempval);
      
              txtarea.val(selemptxt.join("\n"));
          }
      });
      
      // deselect_node.jstree 이벤트 핸들링
      $('#selectAttendsJstree').on('deselect_node.jstree', function(e, data) {
          if (!data.node.id.includes('DEPT')) { // 부서의 정보가 전달되는 것을 방지
              var deselemp = data.node.text;
              var deselempid = data.node.id;
            selemptxt = selemptxt.filter(emp => emp !== deselemp);
            selempval = selempval.filter(emp => emp !== deselempid);
            
            console.log("선택취소한 사원정보:",deselemp);
             console.log("선택한 사원정보 배열:",selemptxt);
             console.log("선택한 사원id 배열:",selempval);
             
             txtarea.val(selemptxt.join("\n"));
          }
          
   });   
}
      
   
   
   // 검색창 글자 입력하면 나오는놈
   $('#selectAttendsJstree_search').keyup(function() {
   $('#selectAttendsJstree').jstree(true).show_all();
   $('#selectAttendsJstree').jstree('search', $(this).val());
   });
   

   //jstree-----------------------------------
 
 
//   //예약 등록 버튼-----------------------------------
   $("#addReservation").click(function() {
   
      var me_room = document.getElementById("me_room").value;
      var re_start = document.getElementById("re_start").value;
      var re_start_time = document.getElementById("re_start_time").value;
      var re_title = document.getElementById("re_title").value;
      var re_content = document.getElementById("re_content").value;
      
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
      } else {
         datata = $("#reservationForm").serialize();
         
         $.ajax({
            type: "POST",
            url:"./myReservationInsert.do",
            data:datata,
            success:function(data){
               console.log("data값", data);
               if(data==0){
                  alert("예약 실패");
                  return false;
               }else{
            alert("예약 되었습니다.");
            $("#reservationForm")[0].reset();
            $("#hiddenValue").val(data);
//          $("#selectAttendsJstree").jstree("deselect_all");
//          $("#selectAttendsJstree").jstree("close_all");
            
            var result = confirm("회의 참가인원을 선택하시겠습니까?")
            if(result){
               $("#reservationModal").modal("hide");
               insertAddAtt()
               
            }else{
               $("#reservationModal").modal("hide");
               alert("참가인원을 정하지 않고 예약되었습니다.")
               location.reload();
            }
               }
               
            },error: function() {
                  alert("서버 에러");
               }
         });      
      }      
   });
   
   
   
   // 예약 상세보기 화면 모달창 및 값전달
   $('.re_title').click(function() {
   var row = $(this).parent();
   console.log("row값:",row)
   var seq = row.find(".re_seq").text();
   console.log("seq의 값" + seq)
   
      $.ajax({
      type:"get",
      url:"./reDetail.do",
      data:{seq:seq},
      dataType:"json",
      success:function(data){
         console.log("불러오기 성공.");
         $("#hiddenValue").val(data.seq);
         $("#deroomNum").val(data.roomNum);
         $("#destart").val(data.start);
         $("#deend").val(data.end);
         $("#detitle").val(data.title);
         $("#decontent").val(data.content);
         $("#deattlist").val(data.attends);
         $("#count").val(data.count + "명");
         $("#redetail").modal("show");
      },
      
      error: function() {
         alert("서버요청 실패했음....");
         }
   })
   
   });
});








//dcoument ready 끝------------------------------------



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
         $("#nawarayo").show();
         
         
         data.forEach(function(item) {
            console.log(item);
         });
         $("#re_start_time").datetimepicker({
            allowTimes: data
         });
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

//예약 등록모달 호출
function reservationModal(){
   console.log("예약 등록 모달");
   $("#reservationModal").modal("show");
}


//모달창 닫기
function redetailclose(){
   console.log("모달창 닫기")
   $("#redetail").modal("hide");
   $("#reservationModal").modal("hide");
   $("#reAttModal").modal("hide");
   location.reload();
   
}

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

//예약수정 작업중...
function modifyRev(){
	var seq = $("#hiddenValue").val();
	
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

function TLqkf(){
	$("#paylinemodal").modal("show");
}
