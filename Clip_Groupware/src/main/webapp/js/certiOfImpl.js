function pdfPrint() {
	html2canvas(document.getElementById("certCt"), {
		onrendered: function(canvas) {
			console.log("작동");
			
			// (그리거나 캡쳐한)캔버스를 지정한포멧에 따라 이미지로 변환후 데이터URL로 반환하는 함수
			var imgData = canvas.toDataURL('image/png');
	
			var imgWidth = 170; // 이미지 가로 길이(mm) A4 기준
			var pageWidth = 195;
			var pageHeight = pageWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
			var originalWidth = 850; // 이미지의 원래 가로 길이
			var originalHeight = 1200; // 이미지의 원래 세로 길이
			var imgHeight = originalHeight * (imgWidth / originalWidth); // 이미지의 새로운 세로 길이
			
			var doc = new jsPDF('p', 'mm', [pageWidth, pageHeight]); // PDF를 생성하고 페이지 크기를 설정
			
			var xPos = (pageWidth - imgWidth) / 2; // 페이지 너비와 이미지 너비의 차를 반으로 나누어 가로 좌표 계산하여 이미지를 가운데로 이동
			var yPos = (pageHeight - imgHeight) / 2; // 페이지 높이와 이미지 높이의 차를 반으로 나누어 세로 좌표 계산하여 이미지를 가운데로 이동
			
			doc.addImage(imgData, 'PNG', xPos, yPos, imgWidth, imgHeight); // 이미지를 가운데에 추가
			
			
			imgHeight -= pageHeight;


			// 파일 저장
			doc.save('재직증명서.pdf');
		}
	});
}

window.onload = function(){
	var pdfBtn = document.querySelector("#pdfBtn");
	pdfBtn.addEventListener("click",function(){
		console.log("실행");
		pdfPrint();
	});
}