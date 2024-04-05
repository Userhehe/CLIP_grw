document.addEventListener('DOMContentLoaded', function() {
	var photoCheck = document.getElementById('photoCheck').value;
	console.log('photoCheck : ' + photoCheck)
	photoCheck = parseInt(photoCheck);
	console.log('photoCheck typeof : ' + typeof photoCheck)
	if(photoCheck === 1) {
		document.getElementById('photoNone').style.display='none'; // 등록한 사진이 있다면 수정, 삭제폼 숨기기
	} else {
		document.getElementById('photoUse').style.display='none'; // 등록한 사진이 있다면 등록폼 숨기기
	}
	
	// 프로필사진등록 파일등록 체크
	document.getElementById('photoNone').addEventListener('submit', function(event) {
		var uploadImage = document.getElementById('uploadImage');
		
		if(!uploadImage || !uploadImage.files || uploadImage.files.length === 0) {
			alert('파일을 첨부해주세요');
			event.preventDefault();
		}
	});
	
	// 프로필사진수정 파일등록 체크
	document.getElementById('photoUpdate').addEventListener('submit', function(event) {
		var updateImage = document.getElementById('updateImage');
		
		if(!updateImage || !updateImage.files || updateImage.files.length === 0) {
			alert('파일을 첨부해주세요');
			event.preventDefault();
		}
	});
});

 document.addEventListener('DOMContentLoaded', function() {
    var photoCheck = document.getElementById('padCheck').value;
    console.log('padCheck : ' + padCheck);
    padCheck = parseInt(padCheck);
    console.log('padCheck typeof : ' + typeof padCheck);
    if(photoCheck >= 1) {
        document.getElementById('signatureButton').style.display='none'; 
    } else {
        document.getElementById('signatureUse').style.display='none'; 
    }
});