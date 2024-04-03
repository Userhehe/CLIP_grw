var canvas = document.getElementById("signpad");
var signature = new SignaturePad(canvas, {
    minWidth: 2,
    maxWidth: 2,
    penColor: "rgb(0, 0, 0)"
});
 
var clear = document.querySelector("#clear");
clear.addEventListener("click", function() {
    signature.clear();
});

var back = document.querySelector("#back");
back.addEventListener("click", function() {
    history.back(-1);
});

var save = document.querySelector("#save");
save.addEventListener("click", function() {
    var data = signature.toDataURL("image/png");
    var title = document.getElementById("signs_name").value;

    if (signature.isEmpty() || title == '') {
        alert("내용이 없습니다.");
    } else {
        var signData = {
            "user_name": document.getElementById("userName").value,
            "signs_name": title,
            "data": data
        };

        fetch('./insertPad.do', {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(signData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("에러! :( ");
                } else {
                    location.href = "./AllselectPad.do"; // 서명 리스트 페이지로 이동
                    return response.json();
                }
            })
            .then(data => {
                console.log(data);
            })
            .catch(err => {
                console.log('Fetch Error', err);
            });
    }
});
