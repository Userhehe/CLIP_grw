Dropzone.options.fileDropzone = {
        url: './upload.do', //업로드할 url (ex)컨트롤러)
        init: function () {
            /* 최초 dropzone 설정시 init을 통해 호출 */
            var fileDropzone = document.querySelector("#fileDropzone");
            var submitButton = document.querySelector("#btn-upload-file");
            var clearButton = document.querySelector("#btn-all-clear");
            var myDropzone = this; //closure
            submitButton.addEventListener("click", function () {
                console.log("업로드"); //tell Dropzone to process all queued files
                console.log(myDropzone.getRejectedFiles().length);
                console.log(myDropzone.getQueuedFiles().length);
                if(myDropzone.getRejectedFiles().length>0){
                   alert("파일 업로드 조건에 맞지 않는 파일이 삭제됩니다");
                   console.log(myDropzone.getRejectedFiles(), myDropzone.getRejectedFiles().length);
                   var dlength = myDropzone.getRejectedFiles().length;
                   for(let i=0; i<dlength; i++){
                      myDropzone.removeFile(myDropzone.getRejectedFiles()[0]);
                      console.log(i+"번째 삭제");
                   }
                }else{
                   submitButton.type = "submit";
                   myDropzone.processQueue();
                  alert("파일이 전송되었습니다.");
                }
            });
            
            clearButton.addEventListener("click", function () {
                myDropzone.removeAllFiles(true); //전체 삭제
             });
             this.on("removedfile", function (e) {
                console.log(myDropzone.getQueuedFiles());
                console.log(myDropzone.getRejectedFiles());
             });
             this.on("addedfile", function (file) { //thumbnail 이미지 바꾸기
                var ext = file.name.split('.').pop();
                 if (ext == "pdf") {
                    file.previewElement.querySelector("img").src = "./imgs/pdf.png";
                 } else if (ext.indexOf("docx") != -1) {
                    file.previewElement.querySelector("img").src = "./imgs/word.png";
                 } else if (ext.indexOf("xls") != -1) {
                    file.previewElement.querySelector("img").src = "./imgs/excel.png";
                 }
                file.previewElement.querySelector("img").style = "width:120px";
                
             });


           },
         //, 찍고 한줄 내려가는거 잊지 마세요
//          method: "post", //기본값은 post이다
            autoProcessQueue: false, // // 자동업로드 여부 (true일 경우, 바로 업로드 되어지며, false일 경우, 
            //  서버에는 올라가지 않은 상태임   processQueue() 호출시 업로드된다.)
            clickable: true, // 클릭가능여부
            thumbnailHeight: 120, // 썸네일 아이콘 사이즈(높이)
            thumbnailWidth: 120, //  썸네일 아이콘 사이즈(가로)
            maxFiles: 5, // 업로드 파일수
            maxFilesize: 10, // 최대업로드용량 : 10MB
            parallelUploads: 5, // 동시파일업로드 수(이걸 지정한 수 만큼 여러파일을 한번에 컨트롤러에 넘긴다.)
            addRemoveLinks: true, // 취소버튼 표시 여부
            dictRemoveFile: '취소', // 취소버튼 표시 텍스트
            uploadMultiple: false, // -> 주의 필요 false 유지 추천! true할시 param의 변수명이 바뀌는 듯
            timeout: 300000, //커넥션 타임아웃 설정 -> 허용 데이터 용량이 클 경우 넉넉하게!
            acceptedFiles: '.png,.JPG,.PNG', // 허용파일(.jpeg,.jpg,.JPEG,.GIF,.pdf,.word,.docx,.xlsx,.csv)
            resizeHeight: 200,  //저장될 때 높이 
            resizeWidth: 500,   // 저장될 때 가로
            dictDefaultMessage:'클릭 또는 드래그로 파일 첨부가 가능합니다', //미리보기 텍스트 설정
            dictFileTooBig: "파일이 너무 큽니다 (현재파일크기:{{filesize}}MB)(최대파일크기:{{maxFilesize}}MB)", //파일의 max 크기 설정보다 클때 보이는 텍스트
            dictMaxFilesExceeded: "파일이 너무 많습니다 (최대파일수:{{maxFiles}})",
            dictInvalidFileType: "허용되지 않은 파일 확장자입니다.",


};
