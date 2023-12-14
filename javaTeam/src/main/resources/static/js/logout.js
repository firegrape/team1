

    $(document).ready(function (){
    $("#logout_btn").on("click",function (){
        if(confirm("로그아웃 하시겠습니까?")){
            location.href="/login/logout.do";
        }

    });

});
